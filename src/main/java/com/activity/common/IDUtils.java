package com.activity.common;


import java.util.Random;

/**
 * 各种id生成策略
 * <p>Title: IDUtils</p>
 * <p>Description: </p>
 * @author	米世廷
 * @version 1.0
 */
public class IDUtils {

	/**
	 * 图片名生成
	 */
	public static String genImageName() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		//加上三位随机数
		Random random = new Random();
		int end3 = random.nextInt(999);
		//如果不足三位前面补0
		String str = millis + String.format("%03d", end3);
		
		return str;
	}
	
	/**
	 * 商品id生成
	 */
	public static long genItemId() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		//加上两位随机数
		Random random = new Random();
		int end2 = random.nextInt(99);
		//如果不足两位前面补0
		String str = millis + String.format("%02d", end2);
		long id = new Long(str);
		return id;
	}
	
	/**
	 * 用户id生成
	 */
	public static String genUserId() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		//加上两位随机数
		Random random = new Random();
		int end2 = random.nextInt(99);
		//如果不足两位前面补0
		String str = millis + String.format("%02d", end2);
		long id = new Long(str);
		return id+"";
	}
	
	public static int genRandom() {
		Random random = new Random();
		return random.nextInt(99);
	}
	
	/**
	 * 商品id生成
	 */
	public static String genItemIdOnly() {
		//取当前时间的长整形值包含毫秒
		long millis = System.nanoTime();
		//加上两位随机数
		Random random = new Random();
		int end3 = random.nextInt(999);
		//如果不足两位前面补0
		String str = millis + String.format("%03d", end3);
		return str;
	}
	
	/**
	 * 商品id生成
	 */
	public static String getInviteCode() {
		StringBuilder str2=new StringBuilder();//定义变长字符串
	    for(int i=0;i<2;i++){
	    	str2.append((char) (Math.random ()*26+'A'));
	    }
	    Random random=new Random();
	    for(int i=0;i<8;i++){
	        str2.append(random.nextInt(10));
	    }
	    return str2.toString();
	}
	
	public static void main(String[] args) {
		for(int i=0;i< 100;i++)
		System.out.println(genItemIdOnly());
	}
	
	
}
