package com.xydemo.utils.encrypt;

import java.nio.ByteBuffer;

/**
 * <p>基础类型 <=>byte[]
 * <p>@author DRAGON 日期 2014年12月23日
 * <p>@date 2015年1月23日
 * <p>@version 1.0
 */
public class BytesUtility {

    /**
     * 将short转成byte[2]
     *
     * @param a
     * @return
     */
    public static byte[] short2Byte(short a) {
        byte[] b = new byte[2];

        b[0] = (byte) (a >> 8);
        b[1] = (byte) (a);

        return b;
    }

    /**
     * 将short转成byte[2]
     *
     * @param a
     * @param b
     * @param offset b中的偏移量
     */
    public static void short2Byte(short a, byte[] b, int offset) {
        b[offset] = (byte) (a >> 8);
        b[offset + 1] = (byte) (a);
    }

    /**
     * 将byte[2]转换成short
     *
     * @param b
     * @return
     */
    public static short byte2Short(byte[] b) {
        return (short) (((b[0] & 0xff) << 8) | (b[1] & 0xff));
    }

    /**
     * 将byte[2]转换成short
     *
     * @param b
     * @param offset
     * @return
     */
    public static short byte2Short(byte[] b, int offset) {
        return (short) (((b[offset] & 0xff) << 8) | (b[offset + 1] & 0xff));
    }

    /**
     * long转byte[8]
     *
     * @param a
     * @param b
     * @param offset b的偏移量
     */
    public static void long2Byte(long a, byte[] b, int offset) {
        b[offset + 0] = (byte) (a >> 56);
        b[offset + 1] = (byte) (a >> 48);
        b[offset + 2] = (byte) (a >> 40);
        b[offset + 3] = (byte) (a >> 32);

        b[offset + 4] = (byte) (a >> 24);
        b[offset + 5] = (byte) (a >> 16);
        b[offset + 6] = (byte) (a >> 8);
        b[offset + 7] = (byte) (a);
    }

    /**
     * byte[8]转long
     *
     * @param b
     * @param offset b的偏移量
     * @return
     */
    public static long byte2Long(byte[] b, int offset) {
        return ((((long) b[offset + 0] & 0xff) << 56)
                | (((long) b[offset + 1] & 0xff) << 48)
                | (((long) b[offset + 2] & 0xff) << 40)
                | (((long) b[offset + 3] & 0xff) << 32)

                | (((long) b[offset + 4] & 0xff) << 24)
                | (((long) b[offset + 5] & 0xff) << 16)
                | (((long) b[offset + 6] & 0xff) << 8) | (((long) b[offset + 7] & 0xff) << 0));
    }

    /**
     * byte[8]转long
     *
     * @param b
     * @return
     */
    public static long byte2Long(byte[] b) {
        return ((b[0] & 0xff) << 56) | ((b[1] & 0xff) << 48)
                | ((b[2] & 0xff) << 40) | ((b[3] & 0xff) << 32) |

                ((b[4] & 0xff) << 24) | ((b[5] & 0xff) << 16)
                | ((b[6] & 0xff) << 8) | (b[7] & 0xff);
    }

    /**
     * long转byte[8]
     *
     * @param a
     * @return
     */
    public static byte[] long2Byte(long a) {
        byte[] b = new byte[4 * 2];

        b[0] = (byte) (a >> 56);
        b[1] = (byte) (a >> 48);
        b[2] = (byte) (a >> 40);
        b[3] = (byte) (a >> 32);

        b[4] = (byte) (a >> 24);
        b[5] = (byte) (a >> 16);
        b[6] = (byte) (a >> 8);
        b[7] = (byte) (a >> 0);

        return b;
    }

    /**
     * byte数组转int
     *
     * @param b
     * @return
     */
    public static int byte2Int(byte[] b) {
        return ((b[0] & 0xff) << 24) | ((b[1] & 0xff) << 16)
                | ((b[2] & 0xff) << 8) | (b[3] & 0xff);
    }

    /**
     * byte数组转int
     *
     * @param b
     * @param offset
     * @return
     */
    public static int byte2Int(byte[] b, int offset) {
        return ((b[offset++] & 0xff) << 24) | ((b[offset++] & 0xff) << 16)
                | ((b[offset++] & 0xff) << 8) | (b[offset++] & 0xff);
    }

    /**
     * int转byte数组
     *
     * @param a
     * @return
     */
    public static byte[] int2Byte(int a) {
        byte[] b = new byte[4];
        b[0] = (byte) (a >> 24);
        b[1] = (byte) (a >> 16);
        b[2] = (byte) (a >> 8);
        b[3] = (byte) (a);

        return b;
    }

    /**
     * int转byte数组
     *
     * @param a
     * @param b
     * @param offset
     * @return
     */
    public static void int2Byte(int a, byte[] b, int offset) {
        b[offset++] = (byte) (a >> 24);
        b[offset++] = (byte) (a >> 16);
        b[offset++] = (byte) (a >> 8);
        b[offset++] = (byte) (a);
    }

    /**
     * 开辟并赋值
     *
     * @param byteLength
     * @param intValue
     * @return
     */
    public static byte[] intToByteArray(int byteLength, int intValue) {
        return ByteBuffer.allocate(byteLength).putInt(intValue).array();

    }

    /**
     * 合并
     *
     * @param array1
     * @param array2
     * @return
     */
    public static byte[] combineByteArray(byte[] array1, byte[] array2) {
        byte[] combined = new byte[array1.length + array2.length];
        System.arraycopy(array1, 0, combined, 0, array1.length);
        System.arraycopy(array2, 0, combined, array1.length, array2.length);
        return combined;

    }

    /**
     * 字符串截取
     *
     * @param source   -----原字符串
     * @param startStr -----开始字符串
     * @param endStr   -----结束字符串
     * @return -----返回截取code
     * @throws Exception
     */
    public static String splitStr(String source, String startStr, String endStr)
            throws Exception {

        if (startStr.length() + endStr.length() > source.length()) {
            throw new Exception("截取字符不合法");
        }

        String[] tmpArr = source.split(startStr);
        String[] tmpArr1 = tmpArr[1].split(endStr);
        String code = tmpArr1[0];

        return code.trim();
    }

    /**
     * 打印16进制
     *
     * @param b
     * @return
     */
    public static String printHexString(byte[] b) {
        StringBuffer returnValue = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            System.out.print(hex.toUpperCase() + " ");
            returnValue.append(hex.toUpperCase() + " ");
        }

        return "[" + returnValue.toString() + "]";
    }


    /**
     * 字节数组转换为16进制字符串
     *
     * @param bytes
     * @return
     */
    public static String bytesToHexString(byte[] bytes) {
        StringBuilder buf = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) { // 使用String的format方法进行转换
            buf.append(String.format("%02x", new Integer(b & 0xff)));
        }
        return buf.toString();
    }


    /**
     * 16进制字符串转16进制字节
     *
     * @param hexs
     * @return
     */
    public static byte[] hexStringToHexbytes(String[] hexs) {
        byte[] hexBytes = new byte[hexs.length];
        for (int i = 0; i < hexs.length; i++) {
            hexBytes[i] = (byte) Integer.parseInt(hexs[i], 16);
        }
        return hexBytes;
    }


    /**
     * 16进制字符串转字符串
     *
     * @param s
     * @return
     */
    public static String hexStringToString(String s) {
        if (s == null || s.equals("")) {
            return null;
        }
        s = s.replace(" ", "");
        byte[] baKeyword = new byte[s.length() / 2];
        for (int i = 0; i < baKeyword.length; i++) {
            try {
                baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            s = new String(baKeyword, "UTF-8");
            new String();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return s;
    }


    /**
     * 16进制数组转字符串
     *
     * @param hexs
     * @return
     */
    public static String hexToStrings(String[] hexs) {
        String result = "";
        for (int i = 0; i < hexs.length; i++) {
            result += hexStringToString(hexs[i]);
        }
        return result;
    }


    /**
     * 十六进制字符串转byte数组
     *
     * @param hexString
     * @return
     */
    public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.trim().equals("")) {
            return new byte[0];
        }

        byte[] bytes = new byte[hexString.length() / 2];
        for (int i = 0; i < hexString.length() / 2; i++) {
            String subStr = hexString.substring(i * 2, i * 2 + 2);
            bytes[i] = (byte) Integer.parseInt(subStr, 16);
        }
        return bytes;
    }


    public static int hexCharToInt(char c) {
        if ((c >= '0') && (c <= '9')) return (c - '0');
        if ((c >= 'A') && (c <= 'F')) return (c - 'A' + 10);
        if ((c >= 'a') && (c <= 'f')) return (c - 'a' + 10);
        throw new RuntimeException("invalid hex char '" + c + "'");

    }


    /**
     * 转换为ascii
     * @param bytes
     * @return
     */
    public static String byte2ascii(byte[] bytes) {
        int start = 0 ;
        int end   = bytes.length;
        int size  = end - start;
        char[] theChars = new char[size];
        int i = 0;

        for(int var6 = start; i < size; theChars[i++] = (char)(bytes[var6++] & 255)) {
            ;
        }
        return new String(theChars);
    }


    public static String bytesToHexString(byte[] bytes, int offset, int len) {
        if (bytes == null) return "null!";
        StringBuilder ret = new StringBuilder(2 * len);
        for (int i = 0; i < len; ++i) {
            int b = 0xF & bytes[(offset + i)] >> 4;
            ret.append("0123456789abcdef".charAt(b));
            b = 0xF & bytes[(offset + i)];
            ret.append("0123456789abcdef".charAt(b));
        }
        return ret.toString();
    }


    public static String bytesToHexString(byte[] bytes, int len) {
        return ((bytes == null) ? "null!" : bytesToHexString(bytes, 0, len));
    }


    public static String byte2String(byte[] bytes){
        if(bytes == null){
            return null;
        }

        StringBuffer sb = new StringBuffer();
        int length = bytes.length;

        for(int i=0 ; i < length ; i++){
            byte b = (byte)(bytes[i]);
            if(b < 0 ){
                int tmp = b + 256;
                sb.append(tmp);
            }else{
                sb.append((byte)(bytes[i]));
            }

        }
        return sb.toString();
    }




}
