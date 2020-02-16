package com.xydemo.utils.encrypt;


import org.apache.commons.codec.binary.Base64;

/**
 * <p>Base64编解码
 * <p>@author DRAGON
 * <p>@date 2015年1月23日
 * <p>@version 1.0
 */
public class Base64Util {

	/**
	 * base64编码
	 * @param str
	 * @return
	 */
	public static String encodeStr(String str) {
		return new String(encode(str));
	}

	public static byte[] encode(String str) {
		byte[] b = str.getBytes();
		return encode(b);
	}

	public static String encodeByte(byte[] b) {
		byte[] enc = encode(b);
		return new String(enc);
	}

	public static byte[] encode(byte[] b) {
		Base64 base64 = new Base64();
		b = base64.encode(b);
		return b;
	}


	/**
	 * base64解码
	 * @param encodeStr
	 * @return
	 */
	public static String decodeStr(String encodeStr) {
		byte[] b = encodeStr.getBytes();
		Base64 base64 = new Base64();
		b = base64.decode(b);
		return new String(b);
	}


	public static byte[] decode(String encodeStr) {
		byte[] b = encodeStr.getBytes();
		Base64 base64 = new Base64();
		b = base64.decode(b);
		return b;
	}

}
