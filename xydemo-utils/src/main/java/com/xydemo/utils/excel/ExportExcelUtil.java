package com.xydemo.utils.excel;


import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>poi 输出 excel
 * <p>@author DRAGON
 * <p>@date 2016年4月4日
 * <p>@version 1.0
 */
public class ExportExcelUtil<T> {

    // 构造函数
    public ExportExcelUtil() {
        super();
        createWorkBook();
    }

    // 构造函数
    public ExportExcelUtil(String dataFormatStr, HSSFCellStyle headStyle, HSSFCellStyle tableStyle) {
        super();
        createWorkBook();
        this.dataFormatStr = dataFormatStr;
        this.headStyle = headStyle;
        this.tableStyle = tableStyle;
    }

    // 默认时间格式
    private String dataFormatStr = "yyyy-MM-dd";
    //作者
    private String author = "DRAGON";
    // 表头样式
    private HSSFCellStyle headStyle = null;
    // 表格样式
    private HSSFCellStyle tableStyle = null;

    public void setDataFormatStr(String dataFormatStr) {
        this.dataFormatStr = dataFormatStr;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    //workbook
    private HSSFWorkbook workbook;

    public HSSFWorkbook getWorkbook() {
        return workbook;
    }
    private void createWorkBook() {
        this.workbook = new HSSFWorkbook();
    }

    /**
     * 默认头风格
     */
    private void defaultHeadStyle() {
        if (this.headStyle != null) {
            return;
        }
        this.headStyle = this.workbook.createCellStyle();
        // 设置这些样式
        headStyle.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
        headStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        headStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        headStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        headStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        headStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        headStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 生成一个字体
        HSSFFont font = workbook.createFont();
        font.setColor(HSSFColor.VIOLET.index);
        font.setFontHeightInPoints((short) 12);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 把字体应用到当前的样式
        headStyle.setFont(font);
    }

    /**
     * 默认表格风格
     */
    private void defaultTableStyle() {
        if (this.tableStyle != null) {
            return;
        }
        // 生成并设置另一个样式
        this.tableStyle = this.workbook.createCellStyle();
        tableStyle.setFillForegroundColor(HSSFColor.WHITE.index);
        tableStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        tableStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        tableStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        tableStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        tableStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        tableStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        tableStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        // 生成另一个字体
        HSSFFont font = workbook.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        // 把字体应用到当前的样式
        tableStyle.setFont(font);
    }

    /**
     * 没有表格头
     * @param title
     * @param dataset
     * @param out
     */
    public void exportExcel(String title, Collection<T> dataset, OutputStream out) {
        defaultHeadStyle();
        defaultTableStyle();
        exportExcel(title, null, dataset, out, this.dataFormatStr,this.headStyle, this.tableStyle);
    }

    /**
     * 有表格头
     * @param title
     * @param headers
     * @param dataset
     * @param out
     */
    public void exportExcel(String title, String[] headers,Collection<T> dataset, OutputStream out) {
        defaultHeadStyle();
        defaultTableStyle();
        exportExcel(title, headers, dataset, out, this.dataFormatStr,this.headStyle, this.tableStyle);
    }

    /**
     * 这是一个通用的方法，利用了JAVA的反射机制，可以将放置在JAVA集合中并且符号一定条件的数据以EXCEL 的形式输出到指定IO设备上
     * @param title   表格标题名
     * @param headers  表格属性列名数组
     * @param dataset
     *            需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。此方法支持的
     *            javabean属性的数据类型有基本数据类型及String,Date,byte[](图片数据)
     * @param out  与输出设备关联的流对象，可以将EXCEL文档导出到本地文件或者网络中
     * @param pattern  如果有时间数据，设定输出格式。默认为"yyy-MM-dd"
     * @param headStyle 表头样式
     * @param tableStyle 表格样式
     */
    public void exportExcel(String title, String[] headers,Collection<T> dataset, OutputStream out, String pattern,HSSFCellStyle headStyle, HSSFCellStyle tableStyle) {
        // 生成一个表格
        HSSFSheet sheet = this.workbook.createSheet(title);
        // 设置表格默认列宽度为50个字节
        sheet.setDefaultColumnWidth(30);

        // 声明一个画图的顶级管理器
        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
        // 定义注释的大小和位置,详见文档
        HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0,0, 0, 0, (short) 4, 2, (short) 6, 5));
        // 设置注释内容
        comment.setString(new HSSFRichTextString("添加注释"));
        // 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
        comment.setAuthor(this.author);

        HSSFFont font3 = this.workbook.createFont();

        HSSFRow row = null;
        if (headers != null) {
            // 产生表格标题行
            row = sheet.createRow(0);
            for (int i = 0; i < headers.length; i++) {
                HSSFCell cell = row.createCell(i);
                cell.setCellStyle(headStyle);
                HSSFRichTextString text = new HSSFRichTextString(headers[i]);
                cell.setCellValue(text);
            }
        }

        // 遍历集合数据，产生数据行
        Iterator<T> it = dataset.iterator();
        int index = 0;
        if (headers == null) {
            index = -1;
        }
        while (it.hasNext()) {
            index++;
            row = sheet.createRow(index);
            T t = (T) it.next();
            // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
            Field[] fields = t.getClass().getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                HSSFCell cell = row.createCell(i);
                cell.setCellStyle(tableStyle);
                Field field = fields[i];
                String fieldName = field.getName();
                String getMethodName = "get"+ fieldName.substring(0, 1).toUpperCase()+ fieldName.substring(1);//获取方法
                try {
                    Class<? extends Object> tCls = t.getClass();
                    Method getMethod = tCls.getMethod(getMethodName,new Class[] {});
                    Object value = getMethod.invoke(t, new Object[] {});
                    // 判断值的类型后进行强制类型转换
                    String textValue = null;

                    //每条记录强制转换
                    if (value instanceof Boolean) {//boolean类型
                        boolean bValue = (Boolean) value;
                        textValue = "1";
                        if (!bValue) {
                            textValue = "0";
                        }
                    }else if (value instanceof Integer || value instanceof Long || value instanceof Float || value instanceof Double) {//数值类型
                        if (value == null) {
                            value = "";
                        }
                        textValue = value + "";
                    }else if (value instanceof Date) {
                        Date date = (Date) value;
                        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                        textValue = sdf.format(date);
                    } else if (value instanceof byte[]) {//字节 图片
                        // 有图片时，设置行高为60px;
                        row.setHeightInPoints(60);
                        // 设置图片所在列宽度为80px,注意这里单位的一个换算
                        sheet.setColumnWidth(i, (short) (35.7 * 80));
                        // sheet.autoSizeColumn(i);
                        byte[] bsValue = (byte[]) value;
                        HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0,1023, 255, (short) 6, index, (short) 6, index);
                        anchor.setAnchorType(2);
                        patriarch.createPicture(anchor, this.workbook.addPicture(bsValue, HSSFWorkbook.PICTURE_TYPE_JPEG));
                    } else {//字符串
                        // 其它数据类型都当作字符串简单处理
                        if (value == null) {
                            textValue = "";
                        }else{
                            textValue = value.toString();
                        }
                    }

                    // 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
                    if (textValue != null) {
                        Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                        Matcher matcher = p.matcher(textValue);
                        if (matcher.matches()) {
                            // 是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        } else {
                            HSSFRichTextString richString = new HSSFRichTextString(textValue);
                            font3.setColor(HSSFColor.BLUE.index);
                            richString.applyFont(font3);
                            cell.setCellValue(richString);
                        }
                    }

                } catch (SecurityException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

        }

        try {
            // 清理资源
            this.workbook.write(out);
            this.workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
