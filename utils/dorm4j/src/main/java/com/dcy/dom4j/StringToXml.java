package com.dcy.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * 目标：
 *      1)将xml文件转成xml字串
 *      2)将xml字符串转到xml文件
 */
public class StringToXml {

    /**
     * 将xml文件转成xml字串
     * @throws Exception
     */
    @Test
    public  void rest1() throws Exception{
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File("src/main/resources/test.xml"));
        String s = document.asXML();
        System.out.println("===========全部文件===========");
        System.out.println(s);
        System.out.println("===========某个元素===========");
        Element rootElement = document.getRootElement();
        Element redOfElement = rootElement.element("红楼梦");
        String s1 = redOfElement.asXML();
        System.out.println(s1);
    }

    /**
     * 将xml字符串转到xml文件
     */
    @Test
    public void test2() throws Exception{
        String text = "<csdn><java>Java班</java><net>Net班</net></csdn>";
        Document document = DocumentHelper.parseText(text);
        writer(document);
    }

    private void writer(Document document) throws Exception{
        // 紧凑的格式
        // OutputFormat format = OutputFormat.createCompactFormat();
        // 排版缩进的格式
        OutputFormat format = OutputFormat.createPrettyPrint();
        // 设置编码
        format.setEncoding("UTF-8");
        // 创建XMLWriter对象,指定了写出文件及编码格式
        // XMLWriter writer = new XMLWriter(new FileWriter(new
        // File("src//a.xml")),format);
        XMLWriter writer = new XMLWriter(new OutputStreamWriter(
                new FileOutputStream(new File("src/main/resources/a.xml")), "UTF-8"), format);
        // 写入
        writer.write(document);
        // 立即写入
        writer.flush();
        // 关闭操作
        writer.close();
    }
}
