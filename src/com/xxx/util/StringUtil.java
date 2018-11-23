package com.xxx.util;

public class StringUtil {

	public static boolean isNull(String value){
		return null == value ? true : false;
	}
	
	public static boolean isNotNull(String value){
		return null == value ? false : true;
	}
	
	public static boolean isBlank(String value){
		if(isNull(value)){
			return true;
		}
		return "".equals(value.trim()) ? true : false;
	}
	
	public static boolean isNotBlank(String value){
		if(isNull(value)){
			return false;
		}
		return "".equals(value.trim()) ? false : true;
	}
	
	public static boolean isNullString(final String value){
		if(isBlank(value)){
			return true;
		}
		return "null".equals(value.trim().toLowerCase()) ? true : false;
	}
	
	public static boolean isNotNullString(final String value){
		if(isBlank(value)){
			return false;
		}
		return "null".equals(value.trim().toLowerCase()) ? false : true;
	}
}
