[TOC]

# [Apache POI](utils/utilities/src/main/java/com/dcy/common/util/ExcelUtil.java)

参考：https://blog.csdn.net/vbirdbest/article/details/72870714

## Apache POI常用的类

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

## 常用的类和方法

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

# [反射](utils/utilities/src/main/java/com/dcy/common/java/reflect/ReflectPlay.java)

参考文档

https://blog.csdn.net/sinat_38259539/article/details/71799078

https://huanglinqing.blog.csdn.net/article/details/88554510

主要参考帮助文档：java.lang.Class API

