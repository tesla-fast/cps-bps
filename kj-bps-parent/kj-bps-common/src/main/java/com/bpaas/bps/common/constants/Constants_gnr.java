package com.bpaas.bps.common.constants;

/**
 * 数据库对应的常量
 * 
 * 
 */
public interface Constants_gnr {

	/** 渠道,全渠道-00 */
	public static final String CHNL_ID_ALL = "00";
	/** 渠道,门户网站-01 */
	public static final String CHNL_ID_WEB = "01";
	/** 渠道,手机-02 */
	public static final String CHNL_ID_APP = "02";
	/** 渠道,微信-03 */
	public static final String CHNL_ID_WEIXIN = "03";
	/** 渠道,电话银行-04 */
	public static final String CHNL_ID_PHONE = "04";
	/** 渠道,批量 - 05 */
	public static final String CHNL_ID_BATCH = "05";
	/** 渠道,极欧 - 11 */
	public static final String CHNL_ID_JIOU = "11";
	/** 渠道,中会支付 - 12 */
	public static final String CHNL_ID_ZHONHUIPAY = "12";
	/** 渠道,贷款 - 13 */
	public static final String CHNL_ID_CREDIT = "13";

	/** 渠道,门户网站-01 */
	public static final String CHNL_ID_WEB_ZN = "网站";
	/** 渠道,手机-02 */
	public static final String CHNL_ID_APP_ZN = "手机";
	/** 渠道,微信-03 */
	public static final String CHNL_ID_WEIXIN_ZN = "微信";
	/** 渠道,电话中心-04 */
	public static final String CHNL_ID_CALL_ZN = "电话中心";
	/** 渠道,批量-05 */
	public static final String CHNL_ID_BATCH_ZN = "批量";

	/** 渠道,极欧 - 11 */
	public static final String CHNL_ID_JIOU_ZN = "极欧";
	/** 渠道,中会支付 - 12 */
	public static final String CHNL_ID_ZHONHUIPAY_ZN = "中会支付";
	/** 渠道,贷款 - 13 */
	public static final String CHNL_ID_CREDIT_ZN = "贷款";

	/** 手机端轮播图默认类型-00 */
	public static final String DEFAULT_DEV_TYPE_APP = "00";
	/** PC端轮播图首页类型-01 */
	public static final String DEV_TYPE_WEB_WELCOM = "01";

	/** 服务状态,正常-0 */
	public static final String SERVICE_STAT_NORMAL = "0";

	/** 用户操作流水状态 ,交易成功-01 */
	public static final String OPERATE_STAT_SUCCESS = "01";
	/** 用户操作流水状态,交易失败-02 */
	public static final String OPERATE_STAT_FAIL = "02";

	/** 交易返回码,交易失败-9999999999 */
	public static final String RSP_CODE_FAIL = "9999999999";
	/** 交易返回码,交易失败-'交易失败' */
	public static final String RSP_CODE_FAIL_DESC = "交易失败";
	/** 交易返回码,交易成功-0000000000 */
	public static final String RSP_CODE_SUCCESS = "0000000000";
	/** 交易返回码,交易成功-'交易成功' */
	public static final String RSP_CODE_SUCCESS_DESC = "交易成功";

	/** 是否为产品类服务 */
	public static final String IS_PRODUCT_SERVICE_YES = "1";

	/** 版本状态 1:最新 */
	public static final String GNR_APP_STAT_NEW = "1";

	/** 版本状态-是否最新版本 0:否 */
	public static final String GNR_APP_ISLAST_NO = "0";
	/** 版本状态-是否最新版本 1:是 */
	public static final String GNR_APP_ISLAST_YES = "1";

	/** 短信状态 1：启用 */
	public static final String SMS_STAT_ENABLE = "1";

	/** 消息状态 1：启用 */
	public static final String NOTICE_STAT_ENABLE = "1";

	/** 短信/事件发送对象类型 1:本人 */
	public static final String SEND_OBJ_MYSELF = "1";
	/** 短信/事件发送对象类型 2:关系人 */
	public static final String SEND_OBJ_RALATIONSHIP = "2";

	/** 短信验证码事件编号 */
	public static final String EVENT_NO_SMSNO = "00000000000000000000";

	/** 营销短信事件编码 */
	public static final String EVENT_NO_MRK_SMSNO = "00000000000000000035";

	/** 是否金融交易 */
	public static final String AMT_FLAG_YES = "1";

	/** 启动屏默认停留时间 */
	public static final String DEFAULT_PAUSE_SEC = "2";

	/** 消息是否已读 1:已读 */
	public static final String IS_NOTICE_READ_YES = "1";
	/** 消息是否已读 0:未读 */
	public static final String IS_NOTICE_READ_NO = "0";

	/** 树枝节点 */
	public static final String MENU_INFO_LEAF = "0";

	/** 顶级地区代码 （查询所有省） */
	public static final String AREA_CODE_TOP = "000000";

	/** 短信通道号 01：亿阳信通 */
	public static final String SMS_SEND_NO_YIYANGXINTONG = "01";

	/** 消息发送方类型 1：直销银行系统 */
	public static final String NOTICE_SEND_TYPE_SYS = "1";

	/** 过期强制更新标志 0：否 */
	public static final String FORCE_UPD_FLAG_NO = "0";

	/** 短信验证码标志 1：验证 */
	public static final String SMS_CODE_VERIFY_FLAG_YES = "1";
	/** TOKEN校验标志 1：验证 */
	public static final String VALIDATE_TOKEN_FLAG = "1";

	/** 交易通用处理标志 0：不处理 1：处理 */
	public static final String TRANS_PROCESS_FLAG_NO = "0";

	/** 交易检查标志 不检查 */
	public static final String TRANS_CHECK_FLAG_UNCHECK = "0000000000000000000000000000000";

	/** 消息级别 00：一般 */
	public static final String GNR_NOTICE_MESSAGR_LEVEL_GANERY = "00";
	/** 消息级别 01：重要 */
	public static final String GNR_NOTICE_MESSAGR_LEVEL_IMPORTANT = "01";
	/** 消息级别 02：紧急 */
	public static final String GNR_NOTICE_MESSAGR_LEVEL_AGENT = "02";

	/** 主密钥 */
	public static final String KEY_TYPE_MAIN = "0";
	/** 直销银行登录密码工作密钥 */
	public static final String KEY_TYPE_ZMK = "1";
	/** 直销银行渠道加密RSA公钥 */
	public static final String KEY_TYPE_RSAPUBLICK = "2";
	/** 直销银行渠道加密RSA私钥 */
	public static final String KEY_TYPE_RSAPRIVATE = "3";

	/** 密钥是否可用 1:是 */
	public static final String KEY_IF_USAGE_YES = "1";

	/** 登陆渠道开关状态 0：开启 */
	public static final String CHNL_SWTICH_OPEN = "0";
	/** 登陆渠道开关状态 1：关闭 */
	public static final String CHNL_SWTICH_CLOSE = "1";
	/** 轮播图生效状态 1：待生效 */
	public static final String MRK_VIEWPICINFO_EFFSTATUS_A = "1";

	/** 用户注册标识：0已注册 */
	public static final String IS_REG_YES = "0";
	/** 用户注册标识：1未注册 */
	public static final String IS_REG_NO = "1";

	/** 是否绑定标识：1已绑定 */
	public static final String IS_BIND_YES = "1";
	/** 是否绑定标识：0未绑定 */
	public static final String IS_BIND_NO = "0";

	/** 短信发送状态 ：0：未发送 */
	public static final String SMS_SEND_STAT_UNSENT = "0";
	/** 短信发送状态 ：1：发送成功 */
	public static final String SMS_SEND_STAT_SUCCESS = "1";
	/** 短信发送状态 ：2 发送失败 */
	public static final String SMS_SEND_STAT_FAIL = "2";
	/**交易码*/
	String TRANS_CODE = "transCode";

}
