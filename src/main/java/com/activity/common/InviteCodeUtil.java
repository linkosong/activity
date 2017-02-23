package com.activity.common;

import java.util.Date;
/**
 * 邀请码工具类
 * 类: InviteCodeUtil <br>
 * 描述: TODO <br>
 * 时间: 2016年9月13日 下午4:29:07
 */
public class InviteCodeUtil {

	private static int seq=0;
	
	private static final int MAX=9999;
	long re=GenerateSequenceUtil.next();
	String str=Integer.toHexString((int)re);
	public static synchronized long next(){ 
			 	StringBuilder buf = new StringBuilder();
			 	Date date=new Date();
			    if (seq > MAX) seq = 0;  
			    buf.delete(0, buf.length());  
			    date.setTime(System.currentTimeMillis());  
			    String str = String.format("%1$tY%1$tm%1$td%1$tk%1$tM%1$tS%2$05d", date, seq++);  
			    return Long.parseLong(str);  
		 }
}
