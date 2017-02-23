package com.activity.common;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import com.activity.pojo.WeixinOauth2Token;

import net.sf.json.JSONObject;




public class WeixinTools {

	/**
     * 获取网页授权凭证
     * 
     * @param appId 公众账号的唯一标识
     * @param appSecret 公众账号的密钥
     * @param code
     * @return WeixinAouth2Token
     */
   /* public static String getUrl1(String appId, String redirectUri, String scope) {
//    	Map<String,Object> mapR = new HashMap<String, Object>();
        // 拼接请求地址
//        String requestUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE&connect_redirect=1#wechat_redirect";
        String requestUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=123#wechat_redirect";
//        String requestUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
        requestUrl = requestUrl.replace("APPID", appId);
        requestUrl = requestUrl.replace("REDIRECT_URI", redirectUri);
        requestUrl = requestUrl.replace("SCOPE", scope);
        return requestUrl;
    }*/
    
    public static String getUrl2(String appId, String redirectUri, String scope) {
//    	Map<String,Object> mapR = new HashMap<String, Object>();
    	// 拼接请求地址
    	String requestUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE&connect_redirect=1#wechat_redirect";
//        String requestUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
    	requestUrl = requestUrl.replace("APPID", appId);
    	requestUrl = requestUrl.replace("REDIRECT_URI", redirectUri);
    	requestUrl = requestUrl.replace("SCOPE", scope);
    	return requestUrl;
    }
    
    
    /**
     * 获取网页授权凭证
     * 
     * @param appId 公众账号的唯一标识
     * @param appSecret 公众账号的密钥
     * @param code
     * @return WeixinAouth2Token
     */
    public static WeixinOauth2Token getOauth2AccessToken(String appId, String appSecret, String code) {
    	WeixinOauth2Token wat = null;
    	// 拼接请求地址
    	String requestUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
    	requestUrl = requestUrl.replace("APPID", appId);
    	requestUrl = requestUrl.replace("SECRET", appSecret);
    	requestUrl = requestUrl.replace("CODE", code);
    	// 获取网页授权凭证
    	JSONObject jsonObject = CommonUtil.httpsRequestToJsonObject(requestUrl, "GET", null);
    	System.out.println("WeixinOauth2Token---"+jsonObject.toString());
    	if (null != jsonObject) {
    		try {
    			wat = new WeixinOauth2Token();
    			wat.setAccessToken(jsonObject.getString("access_token").trim());
    			wat.setExpiresIn(jsonObject.getInt("expires_in"));
    			wat.setRefreshToken(jsonObject.getString("refresh_token").trim());
    			wat.setOpenId(jsonObject.getString("openid").trim());
    			wat.setScope(jsonObject.getString("scope").trim());
    			System.out.println("WeixinOauth2Token----"+wat.toString());
    		} catch (Exception e) {
    			wat = null;
    			int errorCode = jsonObject.getInt("errcode");
    			String errorMsg = jsonObject.getString("errmsg");
//                log.error("获取网页授权凭证失败 errcode:{} errmsg:{}", errorCode, errorMsg);
    		}
    	}
    	return wat;
    }
    
    
    public static WeixinOauth2Token getOauth2RefreshAccessToken(String appId, String refreshtoken) {
    	WeixinOauth2Token wat = null;
    	// 拼接请求地址
    	String requestUrl = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESHTOKEN";
    	requestUrl = requestUrl.replace("APPID", appId);
    	requestUrl = requestUrl.replace("REFRESHTOKEN", refreshtoken);
    	// 获取网页授权凭证
    	JSONObject jsonObject = CommonUtil.httpsRequestToJsonObject(requestUrl, "GET", null);
    	if (null != jsonObject) {
    		try {
    			wat = new WeixinOauth2Token();
    			wat.setAccessToken(jsonObject.getString("access_token").trim());
    			wat.setExpiresIn(jsonObject.getInt("expires_in"));
    			wat.setRefreshToken(jsonObject.getString("refresh_token").trim());
    			wat.setOpenId(jsonObject.getString("openid").trim());
    			wat.setScope(jsonObject.getString("scope").trim());
    		} catch (Exception e) {
    			wat = null;
    			int errorCode = jsonObject.getInt("errcode");
    			String errorMsg = jsonObject.getString("errmsg");
//                log.error("获取网页授权凭证失败 errcode:{} errmsg:{}", errorCode, errorMsg);
    		}
    	}
    	return wat;
    }
	
    /**
     * 通过网页授权获取用户信息
     * 
     * @param accessToken 网页授权接口调用凭证
     * @param openId 用户标识
     * @return SNSUserInfo
     */
    /*@SuppressWarnings( { "deprecation", "unchecked" })
    public static SNSUserInfo getSNSUserInfo(String accessToken, String openId) {
        SNSUserInfo snsUserInfo = null;
        // 拼接请求地址
        String requestUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID";
        requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
        // 通过网页授权获取用户信息
        JSONObject jsonObject = CommonUtil.httpsRequestToJsonObject(requestUrl, "GET", null);

        if (null != jsonObject) {
            try {
                snsUserInfo = new SNSUserInfo();
                // 用户的标识
                snsUserInfo.setOpenId(jsonObject.getString("openid"));
                // 昵称
                snsUserInfo.setNickname(jsonObject.getString("nickname"));
                // 性别（1是男性，2是女性，0是未知）
                snsUserInfo.setSex(jsonObject.getInt("sex"));
                // 用户所在国家
                snsUserInfo.setCountry(jsonObject.getString("country"));
                // 用户所在省份
                snsUserInfo.setProvince(jsonObject.getString("province"));
                // 用户所在城市
                snsUserInfo.setCity(jsonObject.getString("city"));
                // 用户头像
                snsUserInfo.setHeadImgUrl(jsonObject.getString("headimgurl"));
                // 用户特权信息
                snsUserInfo.setPrivilegeList(JSONArray.toList(jsonObject.getJSONArray("privilege"), List.class));
            } catch (Exception e) {
                snsUserInfo = null;
                int errorCode = jsonObject.getInt("errcode");
                String errorMsg = jsonObject.getString("errmsg");
//                log.error("获取用户信息失败 errcode:{} errmsg:{}", errorCode, errorMsg);
            }
        }
        return snsUserInfo;
    }*/
	
    
    
    /**
     * 发送https请求
     * 
     * @param requestUrl 请求地址
     * @param requestMethod 请求方式（GET、POST）
     * @param outputStr 提交的数据
     * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
     */
    public static JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr) {
        JSONObject jsonObject = null;
        try {
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = { new MyX509TrustManager() };
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(requestUrl);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setSSLSocketFactory(ssf);
            
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            conn.setRequestMethod(requestMethod);

            // 当outputStr不为null时向输出流写数据
            if (null != outputStr) {
                OutputStream outputStream = conn.getOutputStream();
                // 注意编码格式
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }

            // 从输入流读取返回内容
            InputStream inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuffer buffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }

            // 释放资源
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            conn.disconnect();
            jsonObject = JSONObject.fromObject(buffer.toString());
        } catch (ConnectException ce) {
//            log.error("连接超时：{}", ce);
        } catch (Exception e) {
//            log.error("https请求异常：{}", e);
        }
        return jsonObject;
    }
    
    /**
     * URL编码（utf-8）
     * 
     * @param source
     * @return
     */
    public static String urlEncodeUTF8(String source) {
        String result = source;
        try {
            result = java.net.URLEncoder.encode(source, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public static String SHA1(String decript) {
		try {
			MessageDigest digest = java.security.MessageDigest
					.getInstance("SHA-1");
			digest.update(decript.getBytes());
			byte messageDigest[] = digest.digest();
			// Create Hex String
			StringBuffer hexString = new StringBuffer();
			// 字节数组转换为 十六进制 数
			for (int i = 0; i < messageDigest.length; i++) {
				String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
				if (shaHex.length() < 2) {
					hexString.append(0);
				}
				hexString.append(shaHex);
			}
			return hexString.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}
	
}
