package com.dcy.hbase.util;

import com.dcy.hbase.config.HbaseConfig;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CompareOperator;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 主要学习各种过滤器与比较运算符
 * 过滤器：
 *      值过滤器:ValueFilter
 *      单列值过滤器：SingleColumnValueFilter
 *      分页过滤器：PageFilter
 *      过滤器列表：FilterList      就像是where后面多个条件,同时可以设置嵌套条件。
 *      行键过滤器：RowFilter{MultiRowRangeFilter：多行范围过滤器}
 *      列过滤器：{FamilyFilter：列族过滤器，QualifierFilter列过滤器}
 *
 *
 * 运算符：
 *  new SubstringComparator(value)  "Like"
 *  new BinaryComparator(Bytes.toBytes(value))  "="
 *  CompareOperator.GREATER       ">"
 *                  LESS：小于。
 *                  LESS_OR_EQUAL：小于等于。
 *                  EQUAL：等于。
 *                  NOT_EQUAL：不等于。
 *                  GREATER_OR_EQUAL：大于等于。
 *                  GREATER：大于。
 *                  NO_OP：无操作
 * @param <T>
 */
@Component
public class HbaseDQL<T> {

    private static Connection connection = null;
    private static Admin admin = null;

    private static final Logger logger = LoggerFactory.getLogger(HbaseDQL.class);

    @PostConstruct
    public void init() {
        if (connection != null) {
            return;
        }
        try {
            connection = ConnectionFactory.createConnection(HbaseConfig.configuration());
            admin = connection.getAdmin();
        } catch (Exception e) {
            logger.error("HBase create connection failed: {}", e);
        }
    }

    /**
     * 获取一行数据
     * @param tableName
     * @param rowKey
     */
    public void selectOneRow(String tableName, String rowKey) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));
        Get get = new Get(Bytes.toBytes(rowKey));
        Result result = table.get(get);
        byte[] value = result.getValue(Bytes.toBytes("cf1"), Bytes.toBytes("age"));
        System.out.println(Bytes.toLong(value));
    }

    /**
     * 获取某行某列数据
     * @param tableName
     * @param rowKey
     */
    public String getValue(String tableName, String rowKey,String columnFamily,String column) throws IOException {
        String value = "";
        Table table = connection.getTable(TableName.valueOf(tableName));
        Get get = new Get(Bytes.toBytes(rowKey));
        get.addColumn(Bytes.toBytes(columnFamily),Bytes.toBytes(column));
        Result result = table.get(get);
        List<Cell> ceList = result.listCells();
        if (ceList != null && ceList.size() > 0) {
            for (Cell cell : ceList) {
                value = Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength());
            }
        }
        return value;
    }

    /**
     * 值过滤器
     *  使用过滤器来进行scan。类似关系型数据库中的where,
     * 作用：过滤所有的value
     * @param tableName
     * @param columnFamily
     * @param column 指定获取那一列值
     * @param value
     * @throws IOException
     *
     */
    public void scanOfValueFilter(String tableName,String columnFamily,String column,String value) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));
        //创建Scan
        Scan scan = new Scan();
        //创建过滤器
        ValueFilter filter = new ValueFilter(CompareOperator.EQUAL, new SubstringComparator(value));
        scan.setFilter(filter);
        ResultScanner scanner = table.getScanner(scan);
        for (Result result : scanner) {
            String name = Bytes.toString(result.getValue(Bytes.toBytes(columnFamily),Bytes.toBytes(column)));
            System.out.println(name);
        }
    }

    /**
     * 单列值过滤器
     * 作用：根据列和值来进行过滤，值是通用类型，不限于String与Long
     * @param tableName
     * @param columnFamily
     * @param column 根据哪一列来进行过滤
     * @param value
     */
    public void scanOfColumnValueFilter(String tableName,String columnFamily,String column,T value) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));
        Scan scan = new Scan();
        byte[] targetType = null;
        if(value instanceof Long){
            targetType = Bytes.toBytes((Long) value);
        }else if(value instanceof String){
            targetType = Bytes.toBytes((String) value);
        }
        SingleColumnValueFilter filter = new SingleColumnValueFilter(Bytes.toBytes(columnFamily),
                Bytes.toBytes(column),
                CompareOperator.GREATER,
                new BinaryComparator(targetType));
        scan.setFilter(filter);
        ResultScanner scanner = table.getScanner(scan);
        for (Result result : scanner) {
            Object ret = null;
            if(value instanceof Long){
                ret = Bytes.toLong(result.getValue(Bytes.toBytes(columnFamily),Bytes.toBytes(column)));
            }else if(value instanceof String){
                ret = Bytes.toString(result.getValue(Bytes.toBytes(columnFamily),Bytes.toBytes(column)));
            }
            System.out.println(ret);
        }
    }

    /**
     * 分页操作，类似limit 2
     * @param tableName
     * @param columnFamily
     * @param size
     * @throws IOException
     */
    public void scanOfPageFilter(String tableName,String columnFamily,Long size) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));
        Scan scan = new Scan();
        PageFilter pageFilter = new PageFilter(size);
        scan.setFilter(pageFilter);
        ResultScanner scanner = table.getScanner(scan);
        print(columnFamily,scanner);
    }

    /**
     * 使用行过滤器进行查询
     * @param tableName
     * @param columnFamily
     * @throws IOException
     */
    public void scanRowFilter(String tableName,String columnFamily,String rowNum) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));
        Scan scan = new Scan();
        RowFilter rowFilter = new RowFilter(CompareOperator.GREATER, new BinaryComparator(Bytes.toBytes(rowNum)));
        scan.setFilter(rowFilter);
        ResultScanner scanner = table.getScanner(scan);
        print(columnFamily,scanner);
    }

    /**
     * 查询row2-row5的记录
     * @param tableName
     * @param columnFamily
     * @param startRow
     * @param endRow
     */
    public void scanMultiRowRangeFilter(String tableName,String columnFamily,String startRow,String endRow) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));
        Scan scan = new Scan();
        MultiRowRangeFilter.RowRange rowRange = new MultiRowRangeFilter.RowRange(Bytes.toBytes(startRow),true,Bytes.toBytes(endRow),true);
        ArrayList<MultiRowRangeFilter.RowRange> rowRanges = new ArrayList<>();
        rowRanges.add(rowRange);
        MultiRowRangeFilter multiRowRangeFilter = new MultiRowRangeFilter(rowRanges);
        scan.setFilter(multiRowRangeFilter);
        ResultScanner scanner = table.getScanner(scan);
        print(columnFamily,scanner);
    }
    private void print(String columnFamily,ResultScanner scanner){
        for (Result result : scanner) {
            String ret = "";
            byte[] rowKey = result.getRow();
            String name = Bytes.toString(result.getValue(Bytes.toBytes(columnFamily),Bytes.toBytes("name")));
            Long age = Bytes.toLong(result.getValue(Bytes.toBytes(columnFamily),Bytes.toBytes("age")));
            ret = Bytes.toString(rowKey)+": name:"+name+" age:"+age;
            System.out.println(ret);
        }
    }
}
