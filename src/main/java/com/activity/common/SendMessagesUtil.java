package com.activity.common;

/**
 * 验证码发送工具类
 * 类: SendMessagesUtil <br>
 * 描述: TODO <br>
 * 时间: 2016年9月13日 下午4:29:28
 */
public class SendMessagesUtil {
//	public static Map<String, Object> getSmsCode(String telphone,String Url) {
//		// TODO Auto-generated method stub
//		System.out.println("telphone:"+telphone);
//		Map<String, Object> map=new HashMap<String, Object>();
//		HttpClient client = new HttpClient(); 
//		PostMethod method = new PostMethod(Url); 
//		client.getParams().setContentCharset("UTF-8");
//		method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=UTF-8");
//		int mobile_code = (int)((Math.random()*9+1)*100000);
//		System.out.println(mobile_code);
//	    String content = new String("您的验证码是：" + mobile_code + "。请不要把验证码泄露给其他人。"); 
//	    System.out.println("content:"+content);
//		NameValuePair[] data = {//提交短信
//			    new NameValuePair("account", "cf_lianjiu"), 
//			    new NameValuePair("password", StringUtil.MD5Encode("LianJiu001")), //密码可以使用明文密码或使用32位MD5加密
//			    //new NameValuePair("password", util.StringUtil.MD5Encode("密码")),
//			    new NameValuePair("mobile", telphone), 
//			    new NameValuePair("content", content),
//		};
//		method.setRequestBody(data);
//		try {
//			client.executeMethod(method);	
//			String SubmitResult =method.getResponseBodyAsString();
//			System.out.println(SubmitResult);
//			Document doc = DocumentHelper.parseText(SubmitResult); 
//			Element root = doc.getRootElement();
//
//			String code = root.elementText("code");	
//			String msg = root.elementText("msg");	
//			String smsid = root.elementText("smsid");	
//			
//			System.out.println(code);
//			System.out.println(msg);
//			System.out.println(smsid);
//			
//			map.put("code", code);
//			map.put("msg", msg);
//			map.put("phoneCode", mobile_code);
//			map.put("phoneNumber", telphone);
//			 if("2".equals(code)){
//				System.out.println("短信提交成功");
//			}
//		} catch (Exception e) {
//			ExceptionUtil.getStackTrace(e);
//			e.printStackTrace();
//		} 
//		return map;
//	}
//	
//	public static Map<String, Object> getCustAuditSuccessSmsCode(String telphone,String Url,String content) {
////		String content = new String("恭喜您，您的审核已经通过！使用电脑登录链酒后台即可管理您的店铺，如需帮助，可拨打我们的VIP专线：400-636-8919。更快的上架商品销售可以抢占先机哦！"); 
////		String content = new String("很遗憾，您的审核未能通过！ 可使用电脑登陆链酒后台查看具体原因，请您修改后重新提交申请。如有疑惑，可拨打400-636-8919垂询"); 
//		// TODO Auto-generated method stub
//		System.out.println("telphone:"+telphone);
//		Map<String, Object> map=new HashMap<String, Object>();
//		HttpClient client = new HttpClient(); 
//		PostMethod method = new PostMethod(Url); 
//		
//		System.out.println(Url);
//		
//		client.getParams().setContentCharset("UTF-8");
//		method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=UTF-8");
//		
//		System.out.println("content:"+content);
//		NameValuePair[] data = {//提交短信
//				new NameValuePair("account", "cf_lianjiu"), 
//				new NameValuePair("password","1f1a4c178aea682c1a9b5170a70d990e"), //密码可以使用明文密码或使用32位MD5加密
////				new NameValuePair("password","ed0b05752433d5fdde08ceff91f62df3"), //密码可以使用明文密码或使用32位MD5加密
//				new NameValuePair("mobile", telphone),
//				new NameValuePair("content", content)
//		};
//		method.setRequestBody(data);
//		try {
//			client.executeMethod(method);	
//			
//			String SubmitResult =method.getResponseBodyAsString();
//			
//			System.out.println(SubmitResult);
//			
//			Document doc = DocumentHelper.parseText(SubmitResult); 
//			Element root = doc.getRootElement();
//			
//			String code = root.elementText("code");	
//			String msg = root.elementText("msg");	
//			String smsid = root.elementText("smsid");	
//			
//			System.out.println(code);
//			System.out.println(msg);
//			System.out.println(smsid);
//			
//			map.put("code", code);
//			map.put("msg", msg);
//			map.put("phoneNumber", telphone);
//			if("2".equals(code)){
//				System.out.println("短信提交成功");
//			}
//		} catch (Exception e) {
//			ExceptionUtil.getStackTrace(e);
//			e.printStackTrace();
//		} 
//		return map;
//	}
//	
//	
//
}
