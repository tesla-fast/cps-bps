package com.bpaas.bps.common.constants;

/**
 * 参数配置表的常量定义
 * 
 * 
 */
public interface CmparmConstants {
	
	public static final String OCR_COUNT_ID = "OCR_COUNT_ID";

	public static final String FACE_SCORE = "FACE_SCORE";
	/** 直销银行机构/核算机构 */
	public static final String RCB_BRANCODE = "RCB_BRANCODE";

	public static final String RECOMMEND_PAKG_NUM = "RECOMMEND_PAKG_NUM";

	/** 银联商户号 */
	public static final String ACP_MER_ID = "merId";

	/** 银联编码方式 */
	public static final String ENCODING = "utf-8";

	public static final String REQUEST_BACK_URL = "requestBackUrl";

	/** 请求超时时间 */
	public static final String ACP_CONNECTION_TIMEOUT = "connectionTimeout";

	/** 响应超时时间 */
	public static final String ACP_READ_TIMEOUT = "readTimeout";

	/** 后台通知地址 */
	public static final String ACP_BACK_URL = "backUrl";

	/** 银联在线版本号 */
	public static final String ACP_VERSION = "acpVersion";

	/** 银联文件传输类交易文件路径 */
	public static final String ACP_FILE_ROOT = "acpFileRoot";

	/** 银联应答码 '00'-成功 */
	public static final String ACP_RESP_CODE = "00";

	/** 商户类型 '0'-普通商户 */
	public static final String ACP_ACCESS_TYPE_GNR = "0";

	/** 商户类型 '1'-收单类商户; */
	public static final String ACP_ACCESS_TYPE_BILL = "1";

	/** 商户类型 '2'-平台类商户 */
	public static final String ACP_ACCESS_TYPE_PLAT = "2";

	/** 银联签名方式 */
	public static final String ACP_SIGN_METHOD = "signMethod";

	/** 网站SESSION失效时间(分钟) */
	public static final String SESSION_WEB_INVALID_MINUTE = "SESSION_WEB_INVALID_MINUTE";

	/** 手机APPSESSION失效时间(分钟) */
	public static final String SESSION_APP_INVALID_MINUTE = "SESSION_APP_INVALID_MINUTE";
	
	/**H5Token失效时间（分钟）*/
	public static final String TOKEN_APP_INVALID_MINUTE = "TOKEN_APP_INVALID_MINUTE";

	/** 单点登录控制 */
	public static final String SINGLE_LOGIN_FLAG = "SINGLE_LOGIN_FLAG";

	/** 单点登录控制 1:单点登录 2:多渠道协同登录 */
	public static final String SINGLE_LOGIN_FLAG_YES = "1";

	/** 登录密码日累计连续错误次数上限 */
	public static final String LOG_TOT_MAX_ERR = "LOG_TOT_MAX_ERR";
	/** 手势，指纹密码日累计连续错误次数上限 */
	public static final String GESTURE_DAY_MAX_ERR = "GESTURE_DAY_MAX_ERR";
	/** 登录密码每日连续错误次数上限 */
	public static final String LOG_DAY_MAX_ERR = "LOG_DAY_MAX_ERR";

	/** 登录密码锁定时效 */
	public static final String LOG_TEMP_HOUR = "LOG_TEMP_HOUR";

	/** 人脸登陆日累计连续错误次数上限 */
	public static final String LOG_FACE_TOT_MAX_ERR = "LOG_FACE_TOT_MAX_ERR";

	/** 人脸登陆每日连续错误次数上限 */
	public static final String LOG_FACE_DAY_MAX_ERR = "LOG_FACE_DAY_MAX_ERR";

	/** 人脸登陆锁定时效 */
	public static final String LOG_FACE_TEMP_HOUR = "LOG_FACE_TEMP_HOUR";

	/** 交易密码日累计连续错误次数上限 */
	public static final String TRADE_TOT_MAX_ERR = "TRADE_TOT_MAX_ERR";

	/** 查询密码日累计连续错误次数上限 */
	public static final String QUERY_TOT_MAX_ERR = "QUERY_TOT_MAX_ERR";

	/** 支付密码每日连续错误次数上限 */
	public static final String TRADE_DAY_MAX_ERR = "TRADE_DAY_MAX_ERR";

	/** 查询密码每日连续错误次数上限 */
	public static final String QUERY_DAY_MAX_ERR = "QUERY_DAY_MAX_ERR";

	/** 支付密码临时锁定时效 */
	public static final String TRADE_TEMP_HOUR = "TRADE_TEMP_HOUR";

	/** 支付密码临时锁定时效 */
	public static final String QUERY_TEMP_HOUR = "QUERY_TEMP_HOUR";

	/** 交易前转换 */
	public static final String TRANS_TYPE_BEFORE = "IN";

	/** 交易后转换 */
	public static final String TRANS_TYPE_AFTER = "OUT";

	/** 登录错误需要验证验证码次数 */
	public static final String LOGIN_VERIFY_TIMES = "LOGIN_VERIFY_TIMES";

	/** 日终清分赎回文件本地路径 */
	public static final String AMOUNT_CLEARING_ROOT = "AMOUNT_CLEARING_ROOT";

	/** 差错文件本地路径 */
	public static final String DIFF_TRADE_ADJUST_ROOT = "DIFF_TRADE_ADJUST_ROOT";

	/** 生成对账文件本地路径 */
	public static final String CREATE_CHECK_FILE_ROOT = "CREATE_CHECK_FILE_ROOT";

	/** 日终调用程序开关 */
	public static final String HX_KG = "HX_KG";

	/** 日终调用程序开关 1:调用该方法 */
	public static final String HX_KG_K = "1";

	/** 日终调用程序开关 0：忽略该刚方法 */
	public static final String HX_KG_G = "0";

	/** 图形验证码失效时间 */
	public static final String VALIDATE_CODE_TIMEOUT = "VALIDATE_CODE_TIMEOUT";

	/** 对账日期 */
	public static final String CHK_DATE_SET = "chkDateSet";

	/** 通道号 */
	public static final String ROUTE_CODE = "rountCode";

	/** 付款通道号 */
	public static final String PAYER_ROUTE_CODE = "payerRouteCode";

	/** 图片上传路径 ***/
	public static final String IMG_UPLOAD_PATH = "IMG_UPLOAD_PATH";

	/** 图片服务器域名 ***/
	public static final String IMG_DOMAIN_NAME = "IMG_DOMAIN_NAME";

	/** 优惠活动HTML文件上传路径 ***/
	public static final String HTML_UPLOAD_PATH = "HTML_UPLOAD_PATH";

	/** HTML文件域名 ***/
	public static final String HTML_DOMAIN_NAME = "HTML_DOMAIN_NAME";

	/** 定期宝 产品代码 ***/
	public static final String PRRODUCT_CODE_SPELWD = "PRRODUCT_CODE_SPELWD";

	/** 活期宝 产品代码 ***/
	public static final String PRRODUCT_CODE_INTELLIGENT = "PRRODUCT_CODE_INTELLIGENT";

	/** 红包==有效期开始日和有效期截止日相差天数 ***/
	public static final String START_XCDAYS_END = "START_XCDAYS_END";

	/** 红包==验签KEY值 ***/
	public static final String CHECK_SIGN_VALUE = "CHECK_SIGN_VALUE";

	/** 直销银行商户代码 **/
	public static final String UPAY_MER_NO = "UPAY_MER_NO";

	/** 短信发送频率（天） **/
	public static final String SMS_FREQUENCY = "SMS_FREQUENCY";
	
	/**客户经理编号修改时间间隔**/
	public static final String USR_CUSTOMER_INTERVAL_DAYS = "USR_CUSTOMER_INTERVAL_DAYS";

	// *******************同盾接口常量配置******************************
	/** 同盾交易代码token */
	public static final String GATEWAY_TONGDUN_TOKEN = "token";
	/** 同盾交易代码 贷款事件 */
	public static final String GATEWAY_TONGDUN_LOAN = "loan";
	/** 同盾交易代码 登录事件 */
	public static final String GATEWAY_TONGDUN_LOGIN = "login";
	/** 同盾交易代码 注册事件 */
	public static final String GATEWAY_TONGDUN_REG = "reg";
	/** 同盾风险决策交易码 */
	public static final String GATEWAY_TONGDUN_RISK = "tongdunRisk";
	/** 同盾详情获取交易码 */
	public static final String GATEWAY_TONGDUN_DETAIL = "tongdunDetail";

	/** 同盾决策响应结果 */
	public static final String GATEWAY_TONGDUN_RISK_RESPONSE = "tongdunRiskResponse";
	/** 同盾详情响应结果 */
	public static final String GATEWAY_TONGDUN_DETAIL_RESPONSE = "tongdunDetailResponse";
	/** 同盾决策响应分数 */
	public static final String GATEWAY_TONGDUN_FINAL_SCORE = "final_score";
	/** 同盾决策最终判断 */
	public static final String GATEWAY_TONGDUN_FINAL_DECISION = "final_decision";
	/** 同盾决策最终判断-拒绝 */
	public static final String GATEWAY_TONGDUN_REJECT = "Reject";
	/** 同盾详情流水序列号 */
	public static final String SEQ_ID = "seq_id";
	/* 提交是否成功 */
	public static final String GATEWAY_TONGDUN_SUCCESS = "success";
	/* success为false的情况下对应错误码,详见错误代码表 */
	public static final String GATEWAY_TONGDUN_REASON_CODE = "reason_code";
	/* 策略集名称 */
	public static final String GATEWAY_TONGDUN_POLICY_SET_NAME = "policy_set_name";
	/* 耗费时间 */
	public static final String GATEWAY_TONGDUN_POLICY_SPEND_TIME = "spend_time";
	/* 注册事件 */
	public static final String GATEWAY_TONGDUN_EVENT_REGISTER = "register";
	/* 登录事件 */
	public static final String GATEWAY_TONGDUN_EVENT_LOGIN = "login";
	/* 绑卡事件 */
	public static final String GATEWAY_TONGDUN_EVENT_BINDING = "binding";
	/* 提现事件 */
	public static final String GATEWAY_TONGDUN_EVENT_WITHDRAW = "withdraw";
	/* 充值事件 */
	public static final String GATEWAY_TONGDUN_EVENT_RECHARGE = "recharge";
	/* 借款事件 */
	public static final String GATEWAY_TONGDUN_EVENT_LOAN = "loan";
	/* 短信==可以输错总次数 */
	public static final String SMS_WRONG_NUM = "SMS_WRONG_NUM";
	/* 短信==需要限制短信发送场景 */
	public static final String SMS_SEND_SITUATION = "SMS_SEND_SITUATION";
}
