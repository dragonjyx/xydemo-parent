package com.xydemo.utils.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexVaildate {

	//通用regex
	public static boolean validate(String value,String regex){
		if (null == value) {
			return false;
		}
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(value);
		return m.matches();
	}
	
	/**
	 * 检测邮箱
	 * @param email
	 * @return
	 */
	public static boolean isEmail(String email) {
		String str = "^([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)*@([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$";
		return validate(email, str);
	}
	

	/**
	 * 检测身份证合法性
	 * @param identityCardNum
	 * @return
	 */
	public static boolean isRightIdentity(String identityCardNum){
		String str = "(\\d{14}[0-9a-zA-Z])|(\\d{17}[0-9a-zA-Z])";  
		return validate(identityCardNum, str);
	}
	
	/**
	 * 检测是否为手机号码
	 * @param phoneNum
	 * @return
	 */
	public static boolean isPhoneNumber(String phoneNum){
		String str = "^((13[0-9])|(15[^4,\\D])|(18[0,2,5-9]))\\d{8}$";  
		return validate(phoneNum, str);
	}

	/**
	 * 判断是否IPV4
	 * @param ipv4
	 * @return
	 */
	public static boolean Isipv4(String ipv4){
		if(ipv4==null || ipv4.length()==0){
			return false;//字符串为空或者空串
		}
		String[] parts=ipv4.split("\\.");//因为java doc里已经说明, split的参数是reg, 即正则表达式, 如果用"|"分割, 则需使用"\\|"
		if(parts.length!=4){
			return false;//分割开的数组根本就不是4个数字
		}
		for(int i=0;i<parts.length;i++){
			try{
				int n=Integer.parseInt(parts[i]);
				if(n<0 || n>255){
					return false;//数字不在正确范围内
				}
			}catch (NumberFormatException e) {
				return false;//转换数字不正确
			}
		}
		return true;
	}



}
