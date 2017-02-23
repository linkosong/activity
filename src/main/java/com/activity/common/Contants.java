package com.activity.common;

public class Contants {

	/** 登入状态 :已登入 */
	public static final Integer LOGIN_STATUS_Y = 999;

	/** 登入状态 :未登入 */
	public static final Integer LOGIN_STATUS_N = 001;

	/** 响应业务状态:错误 */
	public static final Integer ERROR = 404;

	/** 响应业务状态:未授权 */
	public static final Integer UNAUTHORIZED = 401;

	/** 响应业务状态:成功:200 */
	public static final Integer SUCCESS = 200;

	/** 响应业务状态:检索结果0件：201 */
	public static final Integer SUCCESS_0 = 201;
	
	/** 响应业务状态:业务异常：202 */
	public static final Integer BUSINESS_ERROR=202;
	
	/** 响应业务状态:成功，但订单价格或数量有变更 */
	public static final Integer SUCCESS_CHANGE = 202;
	
	/** 响应业务状态: 请求成功，但账户信息修改失败 */
	public static final Integer UPDATE_CHANGE = 202;

	/** 响应业务状态:Erp登录 第一次登陆 */
	public static final Integer LOGINFIRST = 101;

	/** 响应业务状态:参数值不能为空 */
	public static final Integer PARAMNULL = 200;

	/** 响应业务状态:重置内容 */
	public static final Integer RESET_CONTENT = 205;

	public static final Integer NOT_IMPLEMENTED = 203;

	/** 响应业务状态:无记录 */
	public static final Integer SUCCESSBUTNULL = 300;
	
	/** 响应业务状态: 订单hmac签名验证失败 */
	public static final Integer HMAC_ERROR = 600;
	
	/** 伦理删除FLG_0 新增:0 */
	public static final String DELETE_FLAG_0 = "0";

	/** 伦理删除FLG_1 删除:1 */
	public static final String DELETE_FLAG_1 = "1";

	/** 审核状态 1:未审核:1 */
	public static final String PROCESS_STATUS_1 = "1";

	/** 审核状态 2:已审核:2 */
	public static final String PROCESS_STATUS_2 = "2";

	/** 订单状态:待付款:0 */
	public static final String ORDER_STATUS_0 = "0";

	/** 订单状态:待发货:1 */
	public static final String ORDER_STATUS_1 = "1";

	/** 订单状态:待收货:2 */
	public static final String ORDER_STATUS_2 = "2";

	/** 订单状态:已收货未评价 :3*/
	public static final String ORDER_STATUS_3 = "3";

	/** 订单状态:已评价 :4*/
	public static final String ORDER_STATUS_4 = "4";

	/** 订单状态:完成(已过理赔期):5 */
	public static final String ORDER_STATUS_5 = "5";

	/** 订单状态:已取消状态:9 */
	public static final String ORDER_STATUS_9 = "9";
	
	/** 订单状态:取消：过时 :10*/
	public static final String ORDER_STATUS_10 = "10";
	
	/** 订单状态:代发货，未付款:20 */
	public static final String ORDER_STATUS_20 = "20";
	
	/** 订单状态:代收货，未付款 :21*/
	public static final String ORDER_STATUS_21 = "21";
	
	/** 订单状态:已收货，未付款:22 */
	public static final String ORDER_STATUS_22 = "22";
	
	/** 订单状态:已收货，已收款:23 */
	public static final String ORDER_STATUS_23 = "23";

	/** 单号前缀:入货单 */
	public static final String TYPE_II = "ii";

	/** 单号前缀:出货单 :oi*/
	public static final String TYPE_OI = "oi";

	/** 单号前缀:普通订单 :no*/
	public static final String TYPE_NO = "no";

	/** 单号前缀:积分订单:io */
	public static final String TYPE_IO = "io";
	
	/** 单号前缀:支付单号:po */
	public static final String TYPE_PO = "po";
	
	/** 单号前缀:退款单号:ro */
	public static final String TYPE_RO = "ro";
	
	/** 未支付订单时效:1天 */
	public static final int ORDER_TIME = 1;
	
	//已经收藏该商品
	public static final String COLLECT_YES = "1";
	
	//已经收藏该商品
	public static final String COLLECT_NO = "0";
	
	/** 购物车redis KEY:商家 */
	public static final String SHOPPING_CART_CUST = "SHOPPING_CART_CUST:";
	
	/** 购物车数量redis KEY:商家 */
	public static final String SHOPPING_CART_CUST_COUNT = "SHOPPING_CART_CUST_COUNT:";
	
	/** 购物车redis KEY:用户 */
	public static final String SHOPPING_CART_USER = "SHOPPING_CART_USER:";
	
	/** 购物车数量redis KEY:用户 */
	public static final String SHOPPING_CART_USER_COUNT = "SHOPPING_CART_USER_COUNT:";
	
	/** redis KEY:用户商品价格 */
	public static final String GOODS_GOODSPRICE = "GOODS:GOODSPRICE:";
	
	/** redis KEY:用户商品库存 */
	public static final String GOODS_GOODSINVENTORY = "GOODS:GOODSINVENTORY:";
	
	/** redis KEY:催单 */
	public static final String REMINDER = "REMINDER:";
	
	//极光推送  应用AppKey
	public static final String JPUSHTOPOSAPPKEY = "a41e246ca99a98b2f60a359a";
	//极光推送  应用Master Secret
	public static final String JPUSHTOPOSMASTERSECRET = "e95d3a32e3a67d60eb82fb6e";
	//极光推送  再次发送时间
	public static final Integer JPUSHTOPOSMAXRETRYTIMES = 300;
	//极光推送  标题
	public static final String JPUSHTOPOSTITLE = "订单提醒";
	//极光推送  内容
	public static final String JPUSHTOPOSALERT = "您有新的订单，请尽快安排发货。点击查看详情<<";

	//互亿无线发短信url
	public static final String SENDMESSAGEURL = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";
	//互亿无线发短信给 商家审核成功消息
	public static final String SUCCESSSMSCODE = "恭喜您，您的审核已经通过！使用电脑登录链酒后台即可管理您的店铺，如需帮助，可拨打我们的VIP专线：400-636-8919。更快的上架商品销售可以抢占先机哦！";
	//互亿无线发短信给 商家审核失败消息
	public static final String FAILSMSCODE = "很遗憾，您的审核未能通过！ 可使用电脑登陆链酒后台查看具体原因，请您修改后重新提交申请。如有疑惑，可拨打400-636-8919垂询。";

	//networking 程序所在内网ip 推送接口地址
	public static final String NETWORKINGJPUSH = "http://10.26.33.119:8089/networking/push/jpushToOrder";
	//networking 程序所在内网ip 发送验证码接口地址
	public static final String NETWORKINGSENDCODE = "http://10.26.33.119:8089/networking/sendMessages/getSmsCode";
	//networking 程序所在内网ip 推送审核商家成功地址
	public static final String NETWORKINGAUDITSUCCESS = "http://10.26.33.119:8089/networking/sendMessages/auditSuccessSmsCode";
	//networking 程序所在内网ip 推送审核商家失败地址
	public static final String NETWORKINGAUDITFAIL = "http://10.26.33.119:8089/networking/sendMessages/auditFailedSmsCode";
	
	
	
}
