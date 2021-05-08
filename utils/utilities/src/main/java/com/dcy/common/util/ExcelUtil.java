package com.dcy.common.util;


import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.*;

import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.util.Calendar;
import java.util.Date;

/**
 * @author duanchunyu
 */
public class ExcelUtil {

    private static OutputStream getFileOutStream() throws FileNotFoundException {
        FileSystemView fsv = FileSystemView.getFileSystemView();
        String desktop = fsv.getHomeDirectory().getPath();
        String filePath = desktop + "/workbook.xlsx";
        File file = new File(filePath);
        OutputStream outputStream = new FileOutputStream(file);
        return outputStream;
    }

    /**
     * 创建一个excel
     *
     * @throws IOException
     */
    public static void createExcel() throws IOException {
        // 获取桌面路径
        FileSystemView fsv = FileSystemView.getFileSystemView();
        String desktop = fsv.getHomeDirectory().getPath();
        String filePath = desktop + "/template.xls";

        File file = new File(filePath);
        OutputStream outputStream = new FileOutputStream(file);
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Sheet1");
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("id");
        row.createCell(1).setCellValue("订单号");
        row.createCell(2).setCellValue("下单时间");
        row.createCell(3).setCellValue("个数");
        row.createCell(4).setCellValue("单价");
        row.createCell(5).setCellValue("订单金额");
        row.setHeightInPoints(30); // 设置行的高度

        HSSFRow row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue("1");
        row1.createCell(1).setCellValue("NO00001");

        // 日期格式化
        HSSFCellStyle cellStyle2 = workbook.createCellStyle();
        HSSFCreationHelper creationHelper = workbook.getCreationHelper();
        cellStyle2.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
        sheet.setColumnWidth(2, 20 * 256); // 设置列的宽度

        HSSFCell cell2 = row1.createCell(2);
        cell2.setCellStyle(cellStyle2);
        cell2.setCellValue(new Date());

        row1.createCell(3).setCellValue(2);


        // 保留两位小数
        HSSFCellStyle cellStyle3 = workbook.createCellStyle();
        cellStyle3.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
        HSSFCell cell4 = row1.createCell(4);
        cell4.setCellStyle(cellStyle3);
        cell4.setCellValue(29.5);


        // 货币格式化
        HSSFCellStyle cellStyle4 = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setFontName("华文行楷");
        font.setFontHeightInPoints((short) 15);
        font.setColor(HSSFColor.RED.index);
        cellStyle4.setFont(font);

        HSSFCell cell5 = row1.createCell(5);
        cell5.setCellStyle(cellStyle4);
        cell5.setCellFormula("D2*E2");  // 设置计算公式

        // 获取计算公式的值
        HSSFFormulaEvaluator e = new HSSFFormulaEvaluator(workbook);
        cell5 = e.evaluateInCell(cell5);
        System.out.println(cell5.getNumericCellValue());

        workbook.setActiveSheet(0);
        workbook.write(outputStream);
        outputStream.close();
    }

    /**
     * 读取Excel，解析数据
     *
     * @throws IOException
     */
    public static void readExcel() throws IOException {
        //获取桌面路径
        FileSystemView fsv = FileSystemView.getFileSystemView();
        String desktop = fsv.getHomeDirectory().getPath();
        String filePath = desktop + "/template.xls";
        FileInputStream fileInputStream = new FileInputStream(filePath);

        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        POIFSFileSystem fileSystem = new POIFSFileSystem(bufferedInputStream);
        HSSFWorkbook workbook = new HSSFWorkbook(fileSystem);
        HSSFSheet sheet = workbook.getSheet("Sheet1");
        DataFormatter formatter = new DataFormatter();

        int lastRowIndex = sheet.getLastRowNum();
        System.out.println(lastRowIndex);
        for (Row row : sheet) {
            for (Cell cell : row) {

            }
        }
    }

    /**
     * @throws
     * @description Excel XSSF  创建表
     * @author duanchunyu
     * @updateTime 2021/4/28 15:44
     */
    public static void XSSFCreatExcel() throws Exception {
        //创建工作本
        Workbook wb = new XSSFWorkbook();
        //创建sheet
        Sheet oneSheet = wb.createSheet("one");

        //创建单元格

        //表头
        Row row0 = oneSheet.createRow(0);
        row0.createCell(0).setCellValue("id");
        row0.createCell(1).setCellValue("name");
        row0.createCell(2).setCellValue("age");
        row0.createCell(3).setCellValue("birthday");

        //第一行数据
        Row row1 = oneSheet.createRow(1);
        row1.createCell(0).setCellValue("1");
        row1.createCell(1).setCellValue("张三");
        row1.createCell(2).setCellValue(45);
        //设置日期单元格
        CellStyle cellDateStyle = wb.createCellStyle();
        CreationHelper createHelper = wb.getCreationHelper();
        cellDateStyle.setDataFormat(
                createHelper.createDataFormat().getFormat("m/d/yy h:mm"));
        Cell cellBirth = row1.createCell(3);
        cellBirth.setCellValue(new Date());
        cellBirth.setCellStyle(cellDateStyle);
        //第一行数据

        //第二行数据
        Row row2 = oneSheet.createRow(2);
        row2.createCell(0).setCellValue(1.1);
        row2.createCell(1).setCellValue(new Date());
        row2.createCell(2).setCellValue(Calendar.getInstance());
        row2.createCell(3).setCellValue("a string");
        row2.createCell(4).setCellValue(true);
        row2.createCell(5).setCellType(CellType.ERROR);
        //第二行数据


        //输出
        try (OutputStream fileOut = new FileOutputStream("workbook.xlsx")) {
            wb.write(fileOut);
        }
        wb.close();
    }

    /**
     * @throws
     * @description 单元格对其方式
     * @author duanchunyu
     * @updateTime 2021/4/28 16:25
     */
    public static void align() throws Exception {
        OutputStream fileOutStream = getFileOutStream();
        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet();
        Row row = sheet.createRow(0);
        row.setHeightInPoints(30);
        createCell(wb, row, 0, HorizontalAlignment.CENTER, VerticalAlignment.BOTTOM);
        createCell(wb, row, 1, HorizontalAlignment.CENTER_SELECTION, VerticalAlignment.BOTTOM);
        createCell(wb, row, 2, HorizontalAlignment.FILL, VerticalAlignment.CENTER);
        createCell(wb, row, 3, HorizontalAlignment.GENERAL, VerticalAlignment.CENTER);
        createCell(wb, row, 4, HorizontalAlignment.JUSTIFY, VerticalAlignment.JUSTIFY);
        createCell(wb, row, 5, HorizontalAlignment.LEFT, VerticalAlignment.TOP);
        createCell(wb, row, 6, HorizontalAlignment.RIGHT, VerticalAlignment.TOP);
        // Write the output to a file
        wb.write(fileOutStream);
        wb.close();
    }

    /**
     * @throws
     * @description
     * @author duanchunyu
     * @updateTime 2021/4/28 16:17
     */
    private static void createCell(Workbook wb, Row row, int column, HorizontalAlignment halign, VerticalAlignment valign) {
        Cell cell = row.createCell(column);
        cell.setCellValue("Align It");
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(halign);
        cellStyle.setVerticalAlignment(valign);
        cell.setCellStyle(cellStyle);
    }

    /**
     * @throws
     * @description 单元格边框
     * @author duanchunyu
     * @updateTime 2021/4/28 16:32
     */
    private static void border() throws Exception {
        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet();
        // Create a row and put some cells in it. Rows are 0 based.
        Row row = sheet.createRow(1);
        // Create a cell and put a value in it.
        Cell cell = row.createCell(1);
        cell.setCellValue(4);
        // Style the cell with borders all around.
        CellStyle style = wb.createCellStyle();
        style.setBorderBottom(BorderStyle.THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(BorderStyle.THIN);
        style.setLeftBorderColor(IndexedColors.GREEN.getIndex());
        style.setBorderRight(BorderStyle.THIN);
        style.setRightBorderColor(IndexedColors.BLUE.getIndex());
        style.setBorderTop(BorderStyle.MEDIUM_DASHED);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        cell.setCellStyle(style);
        // Write the output to a file
        try (OutputStream fileOut = new FileOutputStream("workbook.xlsx")) {
            wb.write(fileOut);
        }
        wb.close();
    }

    /**
     * @throws
     * @description 读取Excel
     * @author duanchunyu
     * @updateTime 2021/4/28 16:36
     */
    public static void readExcelByXSSF() throws IOException, InvalidFormatException {
        Workbook wb = WorkbookFactory.create(new File("workbook.xlsx"));

        CellReference cellReference = new CellReference("B3");
        FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();

        for (Sheet sheet : wb) {
            for (Row row : sheet) {
                Cell cell = row.getCell(cellReference.getCol());
                CellValue cellValue = evaluator.evaluate(cell);
                switch (cellValue.getCellType()) {
                    case Cell.CELL_TYPE_BOOLEAN:
                        System.out.println(cellValue.getBooleanValue());
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        System.out.println(cellValue.getNumberValue());
                        break;
                    case Cell.CELL_TYPE_STRING:
                        System.out.println(cellValue.getStringValue());
                        break;
                    case Cell.CELL_TYPE_BLANK:
                        break;
                    case Cell.CELL_TYPE_ERROR:
                        break;
                    // CELL_TYPE_FORMULA will never happen
                    case Cell.CELL_TYPE_FORMULA:
                        break;
                }
            }
        }
    }

    public static void test() throws Exception{
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Data Validation");

        XSSFDataValidationHelper dvHelper = new XSSFDataValidationHelper(sheet);

        XSSFDataValidationConstraint dvConstraint = (XSSFDataValidationConstraint)
                dvHelper.createExplicitListConstraint(new String[]{"11", "21", "31"});

        CellRangeAddressList addressList = new CellRangeAddressList(0, 0, 0, 0);
        XSSFDataValidation validation =(XSSFDataValidation)dvHelper.createValidation(dvConstraint, addressList);

        validation.setShowErrorBox(true);
        sheet.addValidationData(validation);

        try (OutputStream fileOut = new FileOutputStream("workbook.xlsx")) {
            workbook.write(fileOut);
        }
        workbook.close();
    }

    public static void test1() throws Exception{
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Data Validation");

        DataValidationHelper helper = sheet.getDataValidationHelper();
        // 加载下拉列表内容
        DataValidationConstraint constraint = helper.createExplicitListConstraint(new String[]{"11", "21", "31"});
        // 设置数据有效性加载在哪个单元格上,四个参数分别是：起始行、终止行、起始列、终止列
        CellRangeAddressList regions = new CellRangeAddressList(0, 0, 0, 0);
        // 数据有效性对象
        DataValidation dataValidation = helper.createValidation(constraint, regions);
        // 处理Excel兼容性问题
        if (dataValidation instanceof XSSFDataValidation)
        {
            dataValidation.setSuppressDropDownArrow(true);
            dataValidation.setShowErrorBox(true);
        }
        else
        {
            dataValidation.setSuppressDropDownArrow(false);
        }

        sheet.addValidationData(dataValidation);
        try (OutputStream fileOut = new FileOutputStream("workbook.xlsx")) {
            workbook.write(fileOut);
        }
        workbook.close();
    }
    public static void main(String[] args) throws Exception {
        ExcelUtil.test1();
    }

}
