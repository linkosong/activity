package com.activity.common;

import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.Format;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.log4j.Logger;

public class GenerateSequenceUtil {

	private static final Logger logger=Logger.getLogger(GenerateSequenceUtil.class);
	
	private static final FieldPosition HELPER_POSITION=new FieldPosition(0);
	
	private final static Format dateFormat = new SimpleDateFormat("YYYYMMddHHmmssS");
	
	private final static NumberFormat numberFormat = new DecimalFormat("00000");
	
	private static int seq=0;
	
	private static final int MAX=9999;
	
	/**
	 * 时间格式生成序列
	 * @return String
	 */
	public static synchronized String generateSequenceNo(){
		Calendar rightNow =Calendar.getInstance();
		StringBuffer sb = new StringBuffer();
		dateFormat.format(rightNow.getTime(),sb,HELPER_POSITION);
		numberFormat.format(seq,sb,HELPER_POSITION);
		if(seq==MAX){
			seq=0;
		}else{
			seq++;
		}
		logger.info("THE SQUENCE IS:"+sb.toString());
		return sb.toString();
	}
	
	 public static synchronized long next(){ 
		 	StringBuilder buf = new StringBuilder();
		 	Date date=new Date();
		    if (seq > MAX) seq = 0;  
		    buf.delete(0, buf.length());  
		    date.setTime(System.currentTimeMillis());  
		    String str = String.format("%1$tY%1$tm%1$td%1$tk%1$tM%1$tS%2$05d", date, seq++);  
		    return Long.parseLong(str);  
	 }
	 public static String Random1() throws Exception {   
		 String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";   
	        char[] c = s.toCharArray();   
	        String str="";
	        Random random = new Random();   
	        for( int i = 0; i < 3; i ++) {   
	            System.out.println(c[random.nextInt(c.length)]);  
	            str=str+c[random.nextInt(c.length)];
	        }  
	       return str;
	  } 
}
