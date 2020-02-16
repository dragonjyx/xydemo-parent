package com.xydemo.utils.excel;

import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p> excel导入工具
 * <p> @author DRAGON
 * <p> @date 2017年1月3日
 * <p> @version 1.0
 */
public class ImportExcelUtil {
    private final static String excel2003L = ".xls"; // 2003- 版本的excel
    private final static String excel2007U = ".xlsx"; // 2007+ 版本的excel

    FormulaEvaluator formulaEvaluator = null;

    /**
     * 描述：根据文件后缀，自适应上传文件的版本
     *
     * @param inStr,fileName
     * @return
     * @throws Exception
     */
    public Workbook getWorkbook(InputStream inStr, String fileName) throws Exception {
        Workbook wb = null;
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if (excel2003L.equals(fileType)) {
            wb = new HSSFWorkbook(inStr); // 2003-
            formulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) wb);
        } else if (excel2007U.equals(fileType)) {
            wb = new XSSFWorkbook(inStr); // 2007+
            formulaEvaluator = new XSSFFormulaEvaluator((XSSFWorkbook) wb);
        } else {
            throw new Exception("解析的文件格式有误！");
        }
        return wb;
    }

    /**
     * 描述：对表格中数值进行格式化
     *
     * @param cell
     * @return
     */
    public Object getCellValue(Cell cell) {
        if(cell == null){
            return "";
        }
        Object value = null;
        DecimalFormat df = new DecimalFormat("0"); // 格式化number String字符
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd"); // 日期格式化
        DecimalFormat df2 = new DecimalFormat("0.00"); // 格式化数字

        Integer type = cell.getCellType();
        if(type == null){
            return "";
        }
        switch (type) {
            case Cell.CELL_TYPE_STRING:
                value = cell.getRichStringCellValue().getString();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                String tmp = cell.toString();
                boolean isDou = NumberValidationUtils.isPositiveDouble(tmp);
                if (!isDou) {
                    if ("General".equals(cell.getCellStyle().getDataFormatString())) {
                        value = df.format(cell.getNumericCellValue());
                    } else if ("m/d/yy".equals(cell.getCellStyle().getDataFormatString())) {
                        value = sdf.format(cell.getDateCellValue());
                    } else {
                        value = df2.format(cell.getNumericCellValue());
                    }
                } else {
                    double val = Double.parseDouble(tmp);

                    double val0 = Math.ceil(val);
                    if (val0 == val) {//如果相等,则转换为整数
                        int val1 = (int) val;
                        value = val1 + "";
                    } else {
                        value = tmp;
                    }
                }
                break;
            case Cell.CELL_TYPE_FORMULA:
                value = String.valueOf(formulaEvaluator.evaluate(cell).getNumberValue());
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                value = cell.getBooleanCellValue();
                break;
            case Cell.CELL_TYPE_BLANK:
                value = "";
                break;
            case Cell.CELL_TYPE_ERROR:
                value = "";
                break;
            default:
                break;
        }
        return value;
    }


    /**
     * 描述：获取IO流中的数据，组装成List<List<Object>>对象
     *
     * @param in,fileName
     * @return
     */
    public Map<String,List<Object>> getBankListByExcel(InputStream in, String fileName) throws Exception {
        Map<String,List<Object>> sheepMap = null;
        // 创建Excel工作薄
        Workbook work = this.getWorkbook(in, fileName);
        if (null == work) {
            throw new Exception("创建Excel工作薄为空！");
        }
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;

        sheepMap = new HashMap<String,List<Object>>();
        // 遍历Excel中所有的sheet
        for (int i = 0; i < work.getNumberOfSheets(); i++) {
            sheet = work.getSheetAt(i);
            if (sheet == null) {
                continue;
            }

            String sheetName = sheet.getSheetName();

            // 遍历当前sheet中的所有行
            // 遍历所有的列
            List<Object> rowlist = new ArrayList<Object>();
            for (int j = sheet.getFirstRowNum(); j < sheet.getLastRowNum() + 1; j++) {
                row = sheet.getRow(j);
                if (row == null) {
                    continue;
                }

                List<Object> columnLi = new ArrayList<Object>();
                for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
                    cell = row.getCell(y);
                    columnLi.add(this.getCellValue(cell));
                }
                rowlist.add(columnLi);
            }
            sheepMap.put(sheetName,rowlist);
        }
        work.close();
        return sheepMap;
    }


}
