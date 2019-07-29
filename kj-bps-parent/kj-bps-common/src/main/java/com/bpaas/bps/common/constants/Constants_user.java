package com.bpaas.bps.common.constants;

/**
 * @Author: haowen.wang
 * @Date: 2019/5/20
 * @Description: 用户常量
 * @version: 1.0
 */
public class Constants_user {

    /**
     * 会员等级 1:黄金会员
     */
    public static final String MEMBER_LEVEL_ID_GOLD = "1";

    /**
     * 会员等级 2:铂金会员
     */
    public static final String MEMBER_LEVEL_ID_PLATINUM = "2";

    /**
     * 会员等级 3:钻石会员
     */
    public static final String MEMBER_LEVEL_ID_DIAMOND = "3";

    /**
     * 会员等级 4:普通会员
     */
    public static final String MEMBER_LEVEL_ID_NOMAL = "4";

    /**
     * 账号启用状态 0:禁用
     */
    public static final String MEMBER_STAT_FORBIDDEN = "0";

    /**
     * 账号启用状态 1:启用
     */
    public static final String MEMBER_STAT_NORMAL = "1";

    /**
     * 是否已实名认证 100:是
     */
    public static final String ISREALNAMEAUTH_YES = "100";

    /**
     * 是否已实名认证 101:否
     */
    public static final String ISREALNAMEAUTH_NO = "101";


    /**
     * 用户价值等级默认值 01：初试牛刀
     */
    public static final String DEFAULT_USER_VALUE_LEVEL = "01";

    /**
     * 用户状态 0：正常
     */
    public static final String USER_STAT_NORMAL = "0";

    /**
     * 锁定标识 000000
     */
    public static final String USER_LOCK_FLAG = "000000";

    /**
     * 黑名单标志,0 正常
     */
    public static final String BLACK_LIST_FLAG_NO = "0";

    /**
     * 黑名单标志,1 黑名单
     */
    public static final String BLACK_LIST_FLAG_YES = "1";

    /**
     * 是否已设置密码0：否
     */
    public static final String IF_CALL_PWD_NO = "0";
    
    /**
     * 注册
     */
    public static final String USER_CHECK_FLAG_0 = "0";
    
    /**
     * 登录-kyc
     * */
    public static final String USER_CHECK_FLAG_1 = "1";
    
    /**
     * 登录-bps
     */
    public static final String USER_CHECK_FLAG_2 = "2";
    
    /**
     * 刷脸登录
     */
    public static final String USER_CHECK_FLAG_3 = "3";
    
    /** 
     * 用户状态,0 正常 
     * */
    public static final String USR_STAT_NORMAL = "0";
    
    /** 
     * 用户状态,1 待激活 
     */
    public static final String USR_STAT_WAIT = "1";
    
    /** 
     * 用户状态,9 注销 
     */
    public static final String USR_STAT_LOGOFF = "9";
    
    /**
     * 已设置的密码  Y
     */
    public static final String USER_PWD_FLAG_Y = "Y";
    
    /**
     * 未设置的密码  Y
     */
    public static final String USER_PWD_FLAG_N = "N";
    
    /** 地址状态标志 0：未获取 */
    public static final String ADDR_GET_FLAG_NO = "0";
    /** 地址状态标志 1：已获取 */
    public static final String ADDR_GET_FLAG_YES = "1";
    /** 地址状态标志 2：无法获取 */
    public static final String ADDR_GET_FLAG_UNCAN = "2";
    /** 登录状态 1：成功 */
    public static final String LOGIN_STAT_SUCCESS = "1";
    /** 登录状态 0：失败 */
    public static final String LOGIN_STAT_FAIL = "0";
    /** 是否单点登录 0:否 */
    public static final String IS_MUTIPLUE_LOGIN_NO = "0";
    /** 是否单点登录 1:是 */
    public static final String IS_MUTIPLUE_LOGIN_YES = "1";
    /** 是否需要修改密码 0：否 */
    public static final String IF_NO_MOD_PWD_NO = "0";
    /** 是否需要修改密码 1：是 */
    public static final String IF_NO_MOD_PWD_YES = "1";
    /** 证件类型 01：身份证 */
    public static final String CERT_TYPE_CERT = "I";
    /** 密码类型,1 登录密码 */
    public static final String PWD_FLAG_LOGIN_PWD = "1";
    /** 密码类型,2 交易密码 */
    public static final String PWD_FLAG_TRADE_PWD = "2";
    /** 密码类型,3 查询密码 */
    public static final String PWD_FLAG_QUERY_PWD = "3";
    /** 密码类型,4 人脸识别 */
    public static final String PWD_FLAG_FACE_PWD = "4";
    /** 密码类型,5 手势密码 */
    public static final String PWD_FLAG_GESTURE_PWD = "5";
    /** 密码类型,6 指纹密码 */
    public static final String PWD_FLAG_FINGERPRINT_PWD = "6";
    /** 锁定标志 0：正常 */
    public static final String USER_LOCK_FLAG_NORMAL = "0";
    /** 锁定标志 1：锁定 */
    public static final String USER_LOCK_FLAG_LOCK = "1";
    /** 锁定标志,1 锁定 */
    public static final String LOCK_FLAG_LOCK = "1";
    /** 锁定标志,2 解锁 */
    public static final String LOCK_FLAG_UNLOCK = "2";
    /** 锁定方式 1：日连续错误锁定 */
    public static final String LOCK_WAY_DAY_ERR = "1";
    /** 锁定方式 2：累计连续错误锁定 */
    public static final String LOCK_WAY_TOT_ERR = "2";
    /** 锁定方式 3：后台管理员锁定 */
    public static final String LOCK_WAY_ADMIN = "3";
    /** 锁定时效,1 临时锁定 */
    public static final String LOCK_MODE_TEMPORARY_LOCK = "1";
    /** 锁定时效,2 非临时锁定 */
    public static final String LOCK_MODE_UNTEMPORARY_LOCK = "2";
    /** 密码是否通过标识 P 通过 */
    public static final String PWD_CHECK_FLAG = "P";
    /**修改登录密码  0*/
    public static final String USER_PWD_OPER_FLAG_0 = "0";
    /**忘记登录密码  1*/
    public static final String USER_PWD_OPER_FLAG_1 = "1";
    /**实名认证*/
    public static final String USER_UPD_FLAG_1 = "1";
    /**完善客户资料信息*/
    public static final String USER_UPD_FLAG_2 = "2";
    /**系统预设头像 0*/
    public static final String USER_IMG_FLAG_0 = "0";
    /**用户自定义头像 1*/
    public static final String USER_IMG_FLAG_1 = "1";
}
