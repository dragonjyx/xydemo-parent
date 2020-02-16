package com.xydemo.utils.excel;

/**
 * @author DRAGON
 * @date 2019-07-29
 */
public class FileConstants {

    /**
     * 导出文件类型
     *
     */
    public static class nameSuffix{
        public static final String NAMESUFFIX_HTML  = ".html"; //HTML
        public static final String NAMESUFFIX_PDF   = ".pdf"; //PDF
        public static final String NAMESUFFIX_EXCEL = ".xls"; //EXCEL
        public static final String NAMESUFFIX_WORD  = ".doc"; //WORD
        public static final String NAMESUFFIX_ZIP   = ".zip"; //ZIP
        public static final String NAMESUFFIX_TXT   = ".txt"; //HTML
    }

    /**
     * 下载类型，用于反射视图界面对应值
     *
     */
    public static class downLoadType{
        public static final  String DOWNLOAD_PDF   ="1";//PDF
        public static final  String DOWNLOAD_EXCEL ="2";//EXCEL
        public static final  String DOWNLOAD_WORD  ="3";//WORD
        public static final  String DOWNLOAD_ZIP   ="4";//ZIP
        public static final  String DOWNLOAD_TXT   ="5";//TXT
        public static final  String DOWNLOAD_HTML  ="6";//HTML
    }
}
