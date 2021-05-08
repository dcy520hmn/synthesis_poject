[TOC]

# 总览

该项目用于日常技术学习与积累，包含了大量的Demo，每个Demo都与node.md知识相对应，可先参考node中学习概念知识，然后在Readme中找到对应练习。为方便日后查询Demo，可参考以下内容。

## 模块描述

|                    模块名称                    |                             描述                             |
| :--------------------------------------------: | :----------------------------------------------------------: |
|              **synthesis_poject**              |            父模块队以下模块的依赖进行版本控制管理            |
|            **[bigdata](# bigdata)**            |                          大数据内容                          |
|           [**dtabase**](# database)            |                          数据库内容                          |
|       **[fgosRelation](# fgosRelation)**       |                        项目中技术内容                        |
|         **[java_Basic](# java_Basic)**         |                           jdk内容                            |
|        **[leading_End](# leading_End)**        |                           前端内容                           |
|           **[rabbitMq](# rabbitMq)**           |                            MQ内容                            |
|        **[sping_redis](# sping_redis)**        |                          Redis内容                           |
|        **[spring_boot](# spring_boot)**        |     一个完整的springboot应用，具有启动器，可以web访问。      |
|       **[spring_cloud](# spring_cloud)**       |   spring_cloud应用包含，服务之间的调用、注册中心、负载均衡   |
| **[spring_httpInvoker](# spring_httpInvoker)** |                      RPC的一种调用方式                       |
|   **[spring_springmvc](# spring_springmvc)**   |           最原始的springmvc定义方式，采用xml的形式           |
|         **[spring_ssh](# spring_ssh)**         |                  ssh框架集成（采用xml形式）                  |
|         **[spring_ssm](# spring_ssm)**         |                  ssm框架集成（采用xml形式）                  |
|              **[utils](# utils)**              | 日常工具：dorm4j（xml文件解析）、trace（链路追踪）、utilities(POI，反射) |
|          [**utilities**](# utilities)          |                        各种工具集学习                        |
|          **[serverSOA](# serverSAP)**          |                           服务治理                           |

## 技术清单

| 技术                                                         | 模块                             |
| ------------------------------------------------------------ | -------------------------------- |
| [注解配置Bean](spring_boot/src/main/java/com/springboot/config/beanDemo/BeanDemo.java) | **[spring_boot](# spring_boot)** |
| [AOP](spring_boot/src/main/java/com/springboot/config/aspect/AccountAspect.java) | **[spring_boot](# spring_boot)** |
| [AOP动态代理实现方式](https://blog.csdn.net/q982151756/article/details/80586894) | **[spring_boot](# spring_boot)** |
| [动态代理技术](https://blog.csdn.net/q982151756/article/details/80586894) | **[spring_boot](# spring_boot)** |
| [反射](utils/utilities/src/main/java/com/dcy/common/java/reflect/ReflectPlay.java) | [**utilities**](# utilities)     |
| [POI](utils/utilities/src/main/java/com/dcy/common/util/ExcelUtil.java) | [**utilities**](# utilities)     |



# bigdata

- ***curator-zk***

- ***hadoopClient***

  描述：用于学习Hadoop客户端API

- ***kafkaClient***

  描述：用于学习kafka生成者API与消费者API

  - ***producer***

    - 同步向kafa发送消息

      [ProducerAsync](bigdata/kafkaClient/producer/src/main/java/com/dcy/kafka/ProducerAsync.java)

    - 异步向kafka发送消息

      [ProducerSync](bigdata/kafkaClient/producer/src/main/java/com/dcy/kafka/ProducerSync.java)

  - ***consumer***

    - 消费kafka中消息

      [ConsumerKafka](bigdata/kafkaClient/consumer/src/main/java/com/dcy/kafka/ConsumerKafka.java)

# database

# fgosRelation

# java_Basic

- 阿里巴巴技术

  [AsyncCall](java_Basic/src/test/java/com/dcy/alibaba/AsyncCall.java)：异步非阻塞编程

  

## java_Basic

- Stream特性

  :full_moon:[StreamDemo](java_Basic/src/test/java/com/dcy/util/StreamDemo.java)

- 比较器

  :full_moon:[ComparatorDemo](java_Basic/src/test/java/com/dcy/util/ComparatorDemo.java)

- 虚拟机

  - 静态方法解析

    [StaticMethodResolution](java_Basic/src/main/java/com/dcy/hotspot/executeSystem/stackFrame/StaticMethodResolution.java)
  
  - Java虚拟机类加载以及子系统实战：在服务端执行临时代码
  
    [practice](java_Basic/src/main/java/com/dcy/hotspot/executeSystem/practice)

# leading_End

# rabbitMq

# sping_redis

# spring_boot

##  技术清单

- [注解配置Bean](spring_boot/src/main/java/com/springboot/config/beanDemo/BeanDemo.java)
- [AOP](spring_boot/src/main/java/com/springboot/config/aspect/AccountAspect.java)

## 技术学习

- AOP

  **前置通知[Before advice]：**在连接点前面执行，前置通知不会影响连接点的执行，除非此处抛出异常。
  **正常返回通知[After returning advice]：**在连接点正常执行完成后执行，如果连接点抛出异常，则不会执行。
  **异常返回通知[After throwing advice]：**在连接点抛出异常后执行。
  **返回通知[After (finally) advice]：**在连接点执行完成后执行，不管是正常执行完成，还是抛出异常，都会执行返回通知中的内容。
  **环绕通知[Around advice]：**环绕通知围绕在连接点前后，比如一个方法调用的前后。这是最强大的通知类型，能在方法调用前后自定义一些操作。环绕通知还需要负责决定是继续处理join point(调用ProceedingJoinPoint的proceed方法)还是中断执行。

- 

# spring_cloud

# spring_httpInvoker

# spring_springmvc

# **spring_ssh**

# spring_ssm

# trace

- 项目预览

  :waxing_crescent_moon:[ReadMe](utils/trace/README.md)

# utilities

## 技术清单

- [POI](utils/utilities/src/main/java/com/dcy/common/util/ExcelUtil.java)
- [反射](utils/utilities/src/main/java/com/dcy/common/java/reflect/ReflectPlay.java)

## 技术学习

### POI

1. Apache POI

   参开https://blog.csdn.net/vbirdbest/article/details/72870714

2. Apache POI常用的类

   - HSSF － 提供读写Microsoft Excel XLS格式档案的功能。
   - XSSF － 提供读写Microsoft Excel OOXML XLSX格式档案的功能。
   - HWPF － 提供读写Microsoft Word DOC97格式档案的功能。
   - XWPF － 提供读写Microsoft Word DOC2003格式档案的功能。
   - HSLF － 提供读写Microsoft PowerPoint格式档案的功能。
   - HDGF － 提供读Microsoft Visio格式档案的功能。
   - HPBF － 提供读Microsoft Publisher格式档案的功能。
   - HSMF － 提供读Microsoft Outlook格式档案的功能。

   在开发中我们经常使用HSSF用来操作Excel处理表格数据，对于其它的不经常使用。

   HSSF 是Horrible SpreadSheet Format的缩写，通过HSSF，你可以用纯Java代码来读取、写入、修改Excel文件。HSSF 为读取操作提供了两类API：usermodel和eventusermodel，即“用户模型”和“事件-用户模型”。

3. 常用的类和方法

   - HSSFWorkbook ：工作簿，代表一个excel的整个文档
     - HSSFWorkbook(); // 创建一个新的工作簿
     - HSSFWorkbook(InputStream inputStream); // 创建一个关联输入流的工作簿，可以将一个excel文件封装成工作簿
     - HSSFSheet createSheet(String sheetname); 创建一个新的Sheet
     - HSSFSheet getSheet(String sheetName); 通过名称获取Sheet
     - HSSFSheet getSheetAt(int index); // 通过索引获取Sheet，索引从0开始
     - HSSFCellStyle createCellStyle()； 创建单元格样式
     - int getNumberOfSheets(); 获取sheet的个数
     - setActiveSheet(int index); 设置默认选中的工作表
     - write();
     - write(File newFile);
     - write(OutputStream stream);

   - HSSFSheet：工作表
     - HSSFRow createRow(int rownum); 创建新行，需要指定行号，行号从0开始
     - HSSFRow getRow(int index); 根据索引获取指定的行
     - int addMergedRegion(CellRangeAddress region); 合并单元格
     - CellRangeAddress(int firstRow, int lastRow, int firstCol, int lastCol); 单元格范围, 用于合并单元格，需要指定要合并的首行、最
     - 后一行、首列、最后一列。
     - autoSizeColumn(int column); 自动调整列的宽度来适应内容
     - getLastRowNum(); 获取最后的行的索引，没有行或者只有一行的时候返回0
     - setColumnWidth(int columnIndex, int width); 设置某一列的宽度，width=字符个数 * 256，例如20个字符的宽度就是20 * 256

   - HSSFRow ：行
     - HSSFCell createCell(int column); 创建新的单元格
     - HSSFCell setCell(shot index);
     - HSSFCell getCell(shot index);
     - setRowStyle(HSSFCellStyle style); 设置行样式
     - short getLastCellNum(); 获取最后的单元格号，如果单元格有第一个开始算，lastCellNum就是列的个数
     - setHeightInPoints(float height); 设置行的高度
   - HSSFCell：单元格
     - setCellValue(String value); 设置单元格的值
       setCellType(); 设置单元格类型，如 字符串、数字、布尔等
       setCellStyle(); 设置单元格样式
       String getStringCellValue(); 获取单元格中的字符串值
       setCellStyle(HSSFCellStyle style); 设置单元格样式，例如字体、加粗、格式化
       setCellFormula(String formula); 设置计算公式，计算的结果作为单元格的值，也提供了异常常用的函数，如求和"sum(A1,C1)"、日期函数、字符串相关函数、CountIf和SumIf函数、随机数函数等
   - HSSFCellStyle ：单元格样式
     - setFont(Font font); 为单元格设置字体样式
     - setAlignment(HorizontalAlignment align); // 设置水平对齐方式
     - setVerticalAlignment(VerticalAlignment align); // 设置垂直对齐方式
     - setFillPattern(FillPatternType fp);
     - setFillForegroundColor(short bg); 设置前景色
     - setFillBackgroundColor(short bg); 设置背景颜色
   - HSSFFont：字体，
     - setColor(short color); // 设置字体颜色
     - setBold(boolean bold); // 设置是否粗体
     - setItalic(boolean italic); 设置倾斜
     - setUnderline(byte underline); 设置下划线
   - HSSFName：名称
     - HSSFDataFormat ：日期格式化
     - HSSFHeader ： Sheet的头部
     - HSSFFooter ：Sheet的尾部
     - HSSFDateUtil ：日期工具
     - HSSFPrintSetup ：打印设置
     - HSSFErrorConstants：错误信息表

   Excel中的工作簿、工作表、行、单元格中的关系：

   ```
   一个Excel文件对应于一个workbook(HSSFWorkbook)，
   一个workbook可以有多个sheet（HSSFSheet）组成，
   一个sheet是由多个row（HSSFRow）组成，
   一个row是由多个cell（HSSFCell）组成
   ```

4. 。

### 反射

参考文档

https://blog.csdn.net/sinat_38259539/article/details/71799078

https://huanglinqing.blog.csdn.net/article/details/88554510

主要参考帮助文档：java.lang.Class API

## 功能



# dorm4j



# serverSAP

# message

- 简介

  国际化处理，springboot中使用MessageSource国际化

- 