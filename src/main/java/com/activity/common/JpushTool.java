package com.activity.common;


import java.util.HashMap;
import java.util.Map;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.APIConnectionException;
import cn.jpush.api.common.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.audience.AudienceTarget;
import cn.jpush.api.push.model.notification.Notification;
public class JpushTool {

	public static String sendPush_android(String orderNo,String... custId) {
		if(orderNo == null && "".equals(orderNo)){
       	 return "orderno不能为空";
        }
		System.out.println("MASTERSECRET==="+Contants.JPUSHTOPOSAPPKEY);
    	
		PushResult result = null;
    	 try {  
             JPushClient jpushClient = new JPushClient(Contants.JPUSHTOPOSMASTERSECRET, Contants.JPUSHTOPOSAPPKEY, Contants.JPUSHTOPOSMAXRETRYTIMES);  
             PushPayload payload = buildPushObject_android_audiencetarget_alias(orderNo,custId);  
             System.out.println(payload.toString());  
             result = jpushClient.sendPush(payload);
         } catch (APIConnectionException e) {
        	 System.out.println("通知也发出！但商家未登入过！");
        	 return "通知也发出！但商家未登入过！";
         } catch (APIRequestException e) {
        	 System.out.println("通知也发出！但商家未登入过！");
        	 return "通知也发出！但商家未登入过！";
         }  
    	return result.toString();
    	
	}
	
	
	public static PushPayload buildPushObject_android_audiencetarget_alias(String orderNo,String... alias) {  
        
        Map<String, String> hashMap = new HashMap<String,String>();
        hashMap.put("orderno", orderNo);
		return PushPayload.newBuilder()  
                .setPlatform(Platform.android())  
                .setAudience(Audience.newBuilder()  
                        .addAudienceTarget(AudienceTarget.alias(alias))  
                        .build()) 
                .setNotification(Notification.android(Contants.JPUSHTOPOSALERT,Contants.JPUSHTOPOSTITLE, hashMap))  
                .build();
    }
	
	/**
	 * android_ios 一起推送
	 * @param orderNo
	 * @param alias
	 * @return
	 */
	public static String sendPush_android_ios(String orderNo,String... custId) {
		if(orderNo == null && "".equals(orderNo)){
       	 return "orderno不能为空";
        }
		System.out.println("MASTERSECRET==="+Contants.JPUSHTOPOSAPPKEY);
    	
		PushResult result = null;
    	 try {  
             JPushClient jpushClient = new JPushClient(Contants.JPUSHTOPOSMASTERSECRET, Contants.JPUSHTOPOSAPPKEY, Contants.JPUSHTOPOSMAXRETRYTIMES);  
             PushPayload payload = buildPushObject_android_ios_audiencetarget_alias(orderNo,custId);  
             System.out.println(payload.toString());  
             result = jpushClient.sendPush(payload);
         } catch (APIConnectionException e) {
        	 System.out.println("通知也发出！但商家未登入过！");
        	 return "通知也发出！但商家未登入过！";
         } catch (APIRequestException e) {
        	 System.out.println("通知也发出！但商家未登入过！");
        	 return "通知也发出！但商家未登入过！";
         }  
    	return result.toString();
    	
	}
	
	/**
	 * android_ios 一起推送
	 * @param orderNo
	 * @param alias
	 * @return
	 */
	public static PushPayload buildPushObject_android_ios_audiencetarget_alias(String orderNo,String... alias) {  
        
        Map<String, String> hashMap = new HashMap<String,String>();
        hashMap.put("orderno", orderNo);
		return PushPayload.newBuilder()  
                .setPlatform(Platform.android_ios())  
                .setAudience(Audience.newBuilder()  
                        .addAudienceTarget(AudienceTarget.alias(alias))  
                        .build()) 
                .setNotification(Notification.android(Contants.JPUSHTOPOSALERT,Contants.JPUSHTOPOSTITLE, hashMap))  
                .build();
    }
	
}
