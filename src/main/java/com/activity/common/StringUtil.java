package com.activity.common;

import java.security.MessageDigest;
import java.util.List;
/**
 * md5加密工具类
 * 类: StringUtil <br>
 * 描述: TODO <br>
 * 时间: 2016年9月13日 下午4:29:51
 */
public class StringUtil {
	public static String str;
	public static final String EMPTY_STRING = "";

	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	public static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	public static String MD5Encode(String origin) {
		String resultString = null;
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byteArrayToHexString(md.digest(resultString
					.getBytes()));
		} catch (Exception ex) {
		}
		return resultString;
	}
	
	/**
	 * 判断字符串是否为空或空字符
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmptyString(String str) {
		return str == null || "".equals(str.trim()) || "[]".equals(str.trim());
	}
	
	/**
	 * 根据分隔符，将字符串转换成数组
	 * 
	 * @param str
	 * @return
	 */
	public static String[] strToStringArrayBySeparator(String str, String separator) {
		if (isEmptyString(str) || isEmptyString(separator)) {
			return null;
		}
		String[] strArray = null;
		if (str.indexOf(separator) != -1) {
			strArray = str.split("\\" + separator);
		} else {
			strArray = new String[] { str };
		}
		return strArray;
	}

	/**
	 * 将字符串数组转换成用单引号括起来，并以逗号隔开的字符串 供sql中的in/not in语句使用，如（'aaa','bbb','ccc'）
	 * 
	 * @param str1
	 * @return
	 */
	public static String arrayToQuoStr(String[] str1) {
		String str = "";
		if (str1 != null && str1.length > 0) {
			for (int i = 0; i < str1.length; i++) {
				if (i == 0) {
					str = "'" + (String) str1[i] + "'";
				} else {
					str += ",'" + str1[i] + "'";
				}
			}
		}
		return str;
	}
	
	/**
	 * 根据分隔符，将字符串转换成用单引号括起来，并以逗号隔开的字符串 供sql中的in/not in语句使用，如（'aaa','bbb','ccc'）
	 * 
	 * @param str
	 * @param separator
	 * @return
	 */
	public static String strToQuoStrBySeparator(String str, String separator){
		return arrayToQuoStr(strToStringArrayBySeparator(str, separator));
	}
	
	 /**
     * LIST将其转为按逗号分隔
     * @return
     */
	public static  <T> String  getTlistToString(List<T> list ){
		StringBuffer strBuffer = new StringBuffer("");
		for(int i=0;list!=null && list.size()>i;i++){
			strBuffer.append(list.get(i));
			if(list.size()>i+1){
				strBuffer.append(",");
			}
		}
		return strBuffer.toString();
	}

}
