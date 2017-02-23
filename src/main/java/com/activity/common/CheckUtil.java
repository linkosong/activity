package com.activity.common;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckUtil {

	// 邮箱格式 正则表达式
	private static String FORMAT_MAIL = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";

	/**
	 * 邮箱验证
	 * 
	 * @param mailAddress
	 *            邮箱地址
	 * @return true 是正确邮箱 false 不是邮箱
	 */
	public static boolean checkMailFormat(String mailAddress) {

		Pattern pattern = Pattern.compile(FORMAT_MAIL);
		Matcher matcher = pattern.matcher(mailAddress);
		return matcher.matches();
	}

	/**
	 * list null验证
	 * 
	 * @param <T>
	 * 
	 * @param list
	 *            被验证List
	 * @return true 空 ,false 非空
	 */
	public static <T> boolean isNullList(List<T> list) {

		if (list.size() == 0 || list == null) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		List<String>  list = new ArrayList<String>();
		list.add("a");
		List<Integer>  list1 = new ArrayList<Integer>();
		//list1.add(new Integer("1"));
		
	System.out.println(isNullList(list));
	System.out.println(isNullList(list1));
	
	}

}
