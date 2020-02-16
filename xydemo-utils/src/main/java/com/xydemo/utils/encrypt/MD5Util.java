package com.xydemo.utils.encrypt;

import java.security.MessageDigest;

/**
 * <p>MD5摘要
 * <p>@author DRAGON
 * <p>@date 2015年3月26日
 * <p>@version 1.0
 */
public class MD5Util {

	 private final static String MD5 = "MD5";


	 public static byte[] md5Encrypt(String data) {
         try {
             MessageDigest md = MessageDigest.getInstance(MD5);
             byte[] md5Bytes= md.digest(data.getBytes());
             return md5Bytes;
         } catch (Exception e) {
             e.printStackTrace();
             return null;
         }
     }
	 
     /**
      * MD5加密算法
      * @param data
      * @return
      */
     public static String md5Encrypt32(String data) {
         String resultString = null;
         try {
             byte[] md5Bytes = md5Encrypt(data);
             resultString    = BytesUtility.bytesToHexString(md5Bytes);
         } catch (Exception e) {
             e.printStackTrace();
         }
         return resultString;
     }
     
     
	   /**
      * MD5加密算法
      * @param data
      * @return
      */
     public static String md5Encrypt16(String data) {
         String resultString = md5Encrypt32(data);
         return resultString.substring(8, 24);
     }
     



}
