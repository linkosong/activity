package com.activity.service.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.activity.aspect.Seller;
import com.activity.aspect.Waiter;
import com.activity.aspect.WaiterDelegate;


@Service
public class Test {

	public static void main(String[] args) {
		
//		testAdvisor();
//		testAdvisor2();
//		testAdvisor3();
//		testAdvisor4();
		testAdvisor5();
	}
//	配置切面：静态方法配置切面
	public static void testAdvisor(){
		String configPath = "classpath:spring/aop.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter)ctx.getBean("waiter");
        Seller seller = (Seller)ctx.getBean("seller");
        waiter.greetTo("John");
        waiter.serveTo("John");
        seller.greetTo("John");
    }
//	静态正则表达式方法匹配切面
	 public static void testAdvisor2(){
		 	String configPath = "classpath:spring/aop.xml";
	        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
	        Waiter waiter = (Waiter)ctx.getBean("waiter1");
	        waiter.greetTo("John");
	        waiter.serveTo("John");
	    }
	 
//	 动态切面
	 public static void testAdvisor3(){
		 	String configPath = "classpath:spring/aop.xml";
	        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
	        Waiter waiter = (Waiter)ctx.getBean("waiter2");
	        waiter.serveTo("Peter");
	        waiter.greetTo("Peter");
	        waiter.serveTo("John");
	        waiter.greetTo("John");
	    }
	 
//	 流程切面
	 public static void testAdvisor4(){
		 	String configPath = "classpath:spring/aop.xml";
	        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
	        Waiter waiter = (Waiter)ctx.getBean("waiter3");
	        WaiterDelegate wd = new WaiterDelegate();
	        wd.setWaiter(waiter);
	        waiter.serveTo("Peter");
	        waiter.greetTo("Peter");
	        wd.service("Peter");
	    }
	 
	 
//	 复合切点切面
	 public  static void testAdvisor5(){
		 	String configPath = "classpath:spring/aop.xml";
	        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
	        Waiter waiter = (Waiter)ctx.getBean("waiter4");
	        WaiterDelegate wd = new WaiterDelegate();
	        wd.setWaiter(waiter);
	        waiter.serveTo("Peter");
	        waiter.greetTo("Peter");
	        wd.service("Peter");
	    }
}
