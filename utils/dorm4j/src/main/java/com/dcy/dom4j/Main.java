package com.dcy.dom4j;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;

/**
 * 目标：对dorm4j的api进行了解
 * 描述：主要是对元素的增删改查
 */
public class Main {

    @Test
    public void test() throws Exception {
        //获取文件
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File("src/main/resources/test.xml"));
        //获取根元素
        Element rootElement = document.getRootElement();
        //遍历根元素
        //listNodes(rootElement);

        //获取节点
        Element redElement = rootElement.element("红楼梦");
        //删除属性
        Attribute id = redElement.attribute("id");
        redElement.remove(id);
        //在红楼梦节点下增加新的元素
        Element newElement = redElement.addElement("朝代");
        newElement.setText("清朝");
        //删除作者
        Element workElement = redElement.element("作者");
        redElement.remove(workElement);

        writer(document);
    }

    /**
     * 重新写入文件
     * @param document
     */
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

    /**
     * 遍历所有元素的节点
     *
     * @param node
     */
    private void listNodes(Element node) {
        System.out.println("当前节点：：" + node.getName());
        //获取节点属性
        List<Attribute> attributes = node.attributes();
        attributes.forEach(attr -> {
            System.out.println(attr.getText() + "-----" + attr.getName()
                    + "---" + attr.getValue());
        });
        //获取节点内容
        if (!node.getTextTrim().equals("")) {
            System.out.println("文本内容：：" + node.getText());
        }
        System.out.println("=========================");
        //遍历该节点的子节点
        Iterator<Element> iterator = node.elementIterator();
        while (iterator.hasNext()) {
            Element element = iterator.next();
            listNodes(element);
        }
    }


}
