package com.activity.common;
/**
 * 
 * @Function:订单支付返回码列表
 * @Desc :
 * @Date :2016年9月23日
 */
public class OrderPayCodes {

	/** 订单支付返回状态 : 成功 */
	public static final Integer ORDERPAY_SUCCESS = 1;
	
	/** 订单支付返回状态 : 订单已结算确认 */
	public static final Integer ORDERPAY_STATEMENT_OK = 101000;
	
	/** 订单支付返回状态 : 订单已结算确认错误 */
	public static final Integer ORDERPAY_STATEMENT_ERROR = 101003;
	
	/** 订单支付返回状态 : 订单结算确认失败 */
	public static final Integer ORDERPAY_STATEMENT_FAIL = 101005;
	
	/** 订单支付返回状态 : 订单不存在 */
	public static final Integer ORDERPAY_NOEXIST = 110001;
	
	/** 订单支付返回状态 : 订单号重复 */
	public static final Integer ORDERPAY_NUMREPEAT = 110002;
	
	/** 订单支付返回状态 : 订单信息错误 */
	public static final Integer ORDERPAY_INFO_ERROR = 110003;
	
	/** 订单支付返回状态 : 订单状态错误 */
	public static final Integer ORDERPAY_STATUS_ERROR = 110004;
	
	/** 订单支付返回状态 : 完成订单失败 */
	public static final Integer ORDERPAY_ENDFAIL = 110005;
	
	/** 订单支付返回状态 : 订单支付失败 */
        public static final Integer ORDERPAY_PAYERROR = 110006;
        
        /** 订单支付返回状态 : 订单通知失败 */
        public static final Integer ORDERPAY_MESSAGE_ERROR = 110007;
        
	/** 订单支付返回状态 : 订单业务类型不为担保订单 */
	public static final Integer ORDERPAY_TYPE_NOWARRANT = 111004;
	
	/** 订单支付返回状态 : 退款请求不存在 */
	public static final Integer REFUND_NOEXIST_REQUEST = 120001;
	
	/** 支付返回状态 : 重复退款请求 */
	public static final Integer REFUND_REPEAT_REQUEST = 120002;
	
	/** 支付返回状态 : 退款请求状态错误 */
	public static final Integer REFUND_STATUSERROR = 120004;
	
	/** 支付返回状态 : 退款失败 */
	public static final Integer REFUND_FAIL = 120005;
	
	/** 支付返回状态 : 分账记录不存在 */
	public static final Integer ROUTING_RECORD_NOEXIST = 130001;
	
	/** 支付返回状态 : 创建分账请求报错 */
	public static final Integer ROUTING_REQUEST_ERROR = 130003;
	
	/** 支付返回状态 : 分账记录状态错误 */
	public static final Integer ROUTING_RECORD_STATUS_ERROR = 130004;
	
	/** 支付返回状态 : 分账请求参数为空报错 */
	public static final Integer ROUTING_REQUEST_PARAMS_NULL = 130006;
	
	/** 支付返回状态 : 分账请求为空 */
	public static final Integer ROUTING_REQUEST_NULL = 130007;
	
	/** 支付返回状态 : 分账金额超限 */
	public static final Integer ROUTING_MONEY_OVER = 130009;
	
	/** 支付返回状态 : 分账信息不存在 */
	public static final Integer ROUTING_INFO_NOEXIST = 131001;
	
	/** 支付返回状态 : 分账信息重复 */
	public static final Integer ROUTING_INFO_REPEAT = 131002;
	
	/** 支付返回状态 : 分账信息错误 */
	public static final Integer ROUTING_INFO_ERROR = 131003;
	
	/** 支付返回状态 : 修改信息请求不存在 */
	public static final Integer UPDATEINFO_REQUEST_NOEXIST = 132001;
	
	/** 支付返回状态 : 修改信息请求重复 */
	public static final Integer UPDATEINFO_REQUEST_REPEAT = 132002;
	
	/** 支付返回状态 : 更新分账记录失败 */
        public static final Integer UPDATE_ROUTING_RECORD_FAIL = 132005;
        
        /** 支付返回状态 : 更新分账信息失败 */
        public static final Integer UPDATE_ROUTING_INFO_FAIL = 132003;
        
        /** 支付返回状态 : 批次号重复 */
        public static final Integer BATCH_NUM_REPEAT = 160002;
        
        /** 支付返回状态 : 账户余额不足 */
        public static final Integer ACCOUNT_BALANCE_LACK = 160008;
        
        /** 支付返回状态 : 更新转账失败 */
        public static final Integer UPDATE_TRANSFER_FAIL = 162005;
        
        /** 支付返回状态 : 代理商不存在 */
        public static final Integer AGENTS_MIDDLEMAN_NOEXIST = 173001;
	
        /** 支付返回状态 : 代理商冻结 */
        public static final Integer AGENTS_MIDDLEMAN_BLOCKING = 173004;
        
        /** 支付返回状态 : 商户不存在 */
        public static final Integer MERCHANT_NOEXIST = 174001;
        
        /** 支付返回状态 : 商户冻结 */
        public static final Integer MERCHANT_BLOCKING = 174004;
        
        /** 支付返回状态 : 分账方不存在 */
        public static final Integer ROUTING_NOEXIST = 175001;
        
        /** 支付返回状态 : 分账方重复 */
        public static final Integer ROUTING_REPEAT = 175002;
        
        /** 支付返回状态 : 分账方冻结 */
        public static final Integer ROUTING_BLOCKING = 175004;
        
        /** 支付返回状态 : 结算记录不存在 */
        public static final Integer SETTLEMENT_RECORD_NOEXIST = 191001;
        
        /** 支付返回状态 : 解绑失败 */
        public static final Integer UNWRAP_FAIL = 191002;
        
        /** 支付返回状态 : 结算记录超限 */
        public static final Integer SETTLEMENT_RECORD_OVER = 191003;
        
        /** 支付返回状态 : 绑卡请求号重复 */
        public static final Integer BINDCARD_REQUESTNUM_REPEAT = 200001;
        
        /** 支付返回状态 : 绑卡请求记录不存在 */
        public static final Integer BINDCARD_RECORD_NOEXIST = 200002;
        
        /** 支付返回状态 : 绑卡请求记录状态不合法 */
        public static final Integer BINDCARD_RECORD_STATUS_NOLEGAL = 200003;
        
        /** 支付返回状态 : 绑卡请求记录超时 */
        public static final Integer BINDCARD_RECORD_OVERTIME = 200004;
        
        /** 支付返回状态 : 短信验证码错误 */
        public static final Integer SMS_CHECKCODE_ERROR = 200005;
        
	
}
