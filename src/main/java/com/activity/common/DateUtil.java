package com.activity.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {
	
	  public static final int YEAR = GregorianCalendar.YEAR;
	  public static final int MONTH = GregorianCalendar.MONTH;
	  public static final int DAY = GregorianCalendar.DATE;
	  public static final int HOUR = GregorianCalendar.HOUR;
	  public static final int MINUTE = GregorianCalendar.MINUTE;
	  public static final int SECOND = GregorianCalendar.SECOND;
	    

	/**
	 * 取得系统时间
	 * 
	 * @return 系统当前时间
	 */
	public static String getSyetemTime(String formatTime) {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat(formatTime);
		return format.format(date);
	}

	/**
	 * 
	 * 
	 * @return 系统当前时间
	 */
	public static Date addDay(Date date,int addCount) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, addCount);
		return cal.getTime();
	}

	/**
     * 
     * @return 字符串转date时间类型
     */
	public static Date parseDateTime(String s) {
	    Date date = null;
	    try {
	           SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	           date = sdf2.parse(s);
	     } catch (Exception e) {
	    }
	    return date;
	}
	
	/**
	 * 按一定格式将日期转字符串
	 * @param date
	 * @param formatPattern
	 * @return String
	 */
	public static String convertDateToString(Date date, String formatPattern) {
		SimpleDateFormat sdf = new SimpleDateFormat();
		try {
			if ((formatPattern == null) || formatPattern.equals("")) {
				formatPattern = "yyyy-MM-dd HH:mm:ss";
			}
			sdf.applyPattern(formatPattern);
			return sdf.format(date);
		}
		catch (Exception e) {
			//e.printStackTrace();
			return null;
		}
	}
	
	 /**
	  * 按一定格式将字符串转日期
	  * @param date
	  * @param formatPattern
	  * @return
	  */
	public static Date convertStringToDate(String date, String formatPattern) {
		SimpleDateFormat sdf = new SimpleDateFormat();
		try {
			if ((formatPattern == null) || formatPattern.equals("")) {
				formatPattern = "yyyy-MM-dd HH:mm:ss";
			}
				sdf.applyPattern(formatPattern);
				return sdf.parse(date);
		}
		catch (Exception e) {
				//e.printStackTrace();
				return null;
		}
	}
	
	 /**
	  * 对某一日期进行增减操作
	  * @param date
	  * @param field
	  * @param amount
	  * @return
	  */
    public static Date addDate(Date date, int field, int amount) {
    	GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        gc.add(field, amount);
        return gc.getTime();
    }
    
    
    /**
     * 获取当前日期是星期几<br>
     * 
     * @param dt
     * @return 当前日期是星期几
     */
    public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);

        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;

        return weekDays[w];
    }
    
    /**
     * 获取连续7天<br>
     * 
     * @param dt
     * @return 当前日期是星期几的连续7天
     */
    public static String get7DayOfDate(Date dt,int c) {
    	String days="";
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        System.out.println(w);
        if (w < 0)
            w = 0;
        
        for (int i = 0; i < c; i++) {
        	if(i!=0){
        		days=days+",";	
        	}
        	days= days + weekDays[(w+i)%7];
		}
        return days;
    }
    
    /**
     * 获取当前日期是星期几<br>
     * 
     * @param dt
     * @return 当前日期是星期几
     */
    public static String getMonthOfDate(Date dt) {
        String[] weekDays = {"一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);

        int w = cal.get(Calendar.MONTH);
        System.out.println(w);

        if (w < 0)
            w = 0;

        return weekDays[w];
    }
    
    public static void main(String[] args) {
    	
//    	Date dt = new Date();
//    	Date date =	addDay(dt, 3*(-1));
//    	
//    	System.out.println(get7DayOfDate(date,3));
//    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	    String dateString = formatter.format(date);
//	    String hour="";
//	    hour = dateString.substring(11, 13);
//		System.out.println(hour);
		
//    	System.out.println(getMonthOfDate(date));
//    	
//    	
//    	BigDecimal bd = new BigDecimal(7);
//		BigDecimal divide = bd.divide(new BigDecimal(2*5), 2, BigDecimal.ROUND_DOWN);
//		Double distribute = Math.round(divide.doubleValue() * 1000) / 1000.000;
//		System.out.println(distribute);
		
		
		String f =DateUtil.getSyetemTime("HHmm"); //格式化为HHmm
		System.out.println(f);
		System.out.println(String.valueOf("8:00"));
		
		
			String aaa[]="12:10".split(":");
			String bbb[]="15:01".split(":");
			String startTime =aaa[0]+aaa[1];
			String endTime =bbb[0]+bbb[1];
			
		int nowNumber = Integer.parseInt(f); //将第一个时间格式化后转为int
		int d1Number = Integer.parseInt(startTime); //将第一个时间格式化后转为int
		int d2Number = Integer.parseInt(endTime); //将第二个时间格式化后转为int
		System.out.println(nowNumber);
		System.out.println(d1Number);
		System.out.println(d2Number);
		if(nowNumber>d1Number&&nowNumber<d2Number){
			System.out.println(11111);
		}
	}
}
