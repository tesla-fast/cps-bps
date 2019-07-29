package com.bpaas.bps.common.constants;

/**
 * 数据库对应的常量
 * 
 * @author haowen.wang
 * 
 */
public interface Constants_pot {

    /** 积分账户类型,通用积分账户-0 */
    public static final String ACCT_TYPE_NORMAL = "0";
    /** 积分账户类型,专项积分账户-1 */
    public static final String ACCT_TYPE_SPECIAL = "1";

    /** 积分账户类型,成长积分账户-2 */
    public static final String ACCT_TYPE_GROW = "2";

    /** 渠道代码门户 -01 */
    public static final String CHNL_ID_WEB = "01";

    /** 渠道代码APP-02 */
    public static final String CHNL_ID_APP = "02";

    public static final String ACCT_TYPE_NORMAL_DESC = "通用积分主账户";
    public static final String ACCT_TYPE_GROW_DESC = "成长积分主账户";

    public static final String POT_DESC = "积分账户";

    /** 积分账户账号前缀,通用积分类型：331 */
    public static final String ACCTNO_TYPE_PREFIX = "331";
    /** 积分账户账号前缀,专项积分类型：332 */
    public static final String ACCTNO_TYPE_SPE_PREFIX = "332";

    /** 积分账户状态,正常-0 */
    public static final String ACCT_STAT_NORMAL = "0";
    /** 积分账户状态-双向冻结（不收不付）,1 */
    public static final String ACCT_STAT_TWO_WAY_FREEZE = "1";
    /** 积分账户状态-借方冻结（只收不付） ,2 */
    public static final String ACCT_STAT_ONLY_ACCEP = "2";
    /** 积分账户状态-贷方冻结（只付不收） ,3 */
    public static final String ACCT_STAT_ONLY_PAY = "3";
    /** 积分账户状态-已注销, 4 */
    public static final String ACCT_STAT_LOGOUT = "4";
    /** 积分账户状态-待激活 , 5 */
    public static final String ACCT_STAT_TO_ACTIVATE = "5";
    /** 积分账户状态-停用 , 6 */
    public static final String ACCT_STAT_DISABLE = "6";

    /** 积分计划状态状态,正常-0 */
    public static final String POT_PLAN_STAT_NORMAL = "0";
    /** 手续费收取方式，内扣：0 */
    public static final String GETTYPE_INTERIOR = "0";
    /** 手续费收取方式，外扣：1 */
    public static final String GETTYPE_WITHOUT = "1";
    /** 手续费计算方式，单笔固定：1 */
    public static final String GETTYPE_SINFIXED = "1";
    /** 手续费计算方式，单笔固定+按交易金额比例收取：2 */
    public static final String GETTYPE_SINFIXEDANDRATE = "2";
    /** 手续费计算方式，按交易金额比例收取：3 */
    public static final String GETTYPE_RATE = "3";
    /** 手续费分润方式，按金额比例：1 */
    public static final String SPLITTYPE_RATE = "1";
    /** 手续费分润方式，按固定金额：2 */
    public static final String SPLITTYPE_FIXED = "2";
    /** 0000表示不分润 */
    public static final String SPLITTYPE = "0000";
    /** 分润类型 应收：0 */
    public static final String SPLITTYPE_IN = "0";
    /** 分润类型 应付：1 */
    public static final String SPLITTYPE_PAY = "1";
    /** 积分可用状态，已使用：1 */
    public static final String USE_STAT_DISABLED = "1";
    /** 积分可用状态，未使用：0 */
    public static final String USE_STAT_AVAILABLE = "0";
    /** 积分流水更新交易状态 正常：N */
    public static final String TRANSTATUS_NORMAL = "N";
    /** 交易状态，C-系统抹账（原交易流水中记录） */
    public static final String TRANSTATUS_REV_C = "C";
    /** 积分流水更新交易状态 失败：2 */
    public static final String TRANSTATUS_FAIL = "2";
    /** 入账标识 失败：1 */
    public static final String IN_ACC_FAIL = "1";
    /** 入账标识 成功：0 */
    public static final String IN_ACC_SUCCESS = "0";
    /** 积分消耗产生交易类型 通用：0 */
    public static final String CO_GE_TRANTYPE_MAIN = "0";
    /** 交易冲正标志，0-未冲正 */
    public static final String REV_FLAG_NO = "0";
    /** 交易冲正标志，1-冲正 */
    public static final String REV_FLAG_YES = "1";
    /** 积分可用状态，1-借（余额减少） */
    public static final String DCFLAG_D = "1";
    /** 积分可用状态， 2-贷（余额增加） */
    public static final String DCFLAG_C = "2";

    public static final String TRANS_SYNC_FLAG_Y = "2";

    /** 入账标志 ，0:已入账 */
    public static final String IN_FLAG_SUCCESS = "0";
    /** 交易状态 ，1:交易成功 */
    public static final String POT_TRANS_STAT_TRUE = "1";
    /** 计划状态状态 ，0：生效 */
    public static final String PLAN_STAT_NORMAL = "0";
    /** 计划状态状态 ，1：失效 */
    public static final String PLAN_STAT_DISAVAILABLE = "1";
    /** 计划状态状态 ，2：删除 */
    public static final String PLAN_STAT_DELETE = "2";
    /** 交易是否支持 当日是否重复产生积分 ，Y：支持 */
    public static final String CURDAY_REPEATYN_Y = "Y";
    /** 交易是否支持 当日是否重复产生积分 ，N：不支持 */
    public static final String CURDAY_REPEATYN_N = "N";
    /** 交易是否支持 是否重复产生积分 ，N：不支持 */
    public static final String REPEATYN_N = "N";
    /** 是否单笔交易 ，Y：是 */
    public static final String SINGLE_TRANSYN_Y = "Y";
    /** 是否单笔交易 ，N：否 */
    public static final String SINGLE_TRANSYN_N = "N";
    /** 该积分返还标志 ，0：否 */
    public static final String POINTS_RETURN_FLAG_FALSE = "0";
    /** 积分返还标志 ，1：是 */
    public static final String POINTS_RETURN_FLAG_TRUE = "1";

    /** 链接分享类型 ，EVNT：活动 */
    public static final String SHARE_TYPE_EVNT = "EVNT";

    /** 奖励积分方式,按固定值-0 */
    public static final String POT_PLAN_COUNT_FIX = "0";
    /** 奖励积分方式,按比例-1 */
    public static final String POT_PLAN_COUNT_RATE = "1";
    /** 奖励积分方式,按固定值乘以连续次数-2 */
    public static final String POT_PLAN_COUNT_ENC = "2";
    /** 特殊日类型 ，无限制 */
    public static final String POT_PLAN_COUNT_SPECIALDAY_ALL = "000";
    /** 特殊日类型 ，生日 */
    public static final String POT_PLAN_COUNT_SPECIALDAY_BIRTH = "001";
    /** 积分有效期类型 ，月 */
    public static final String POT_PLAN_COUNT_AVAILABLE_TYPE_MONTH = "00";
    /** 积分有效期类型 ，季度 */
    public static final String POT_PLAN_COUNT_AVAILABLE_TYPE_QUARTER = "01";
    /** 积分有效期类型 ，半年 */
    public static final String POT_PLAN_COUNT_AVAILABLE_TYPE_HALFYEAR = "02";
    /** 积分有效期类型 ，季度 */
    public static final String POT_PLAN_COUNT_AVAILABLE_TYPE_YEAR = "03";
    /** 积分返还方式 ，联机-0 */
    public static final String POT_PLAN_LIST_RETURN_WAY_ONLINE = "0";
    /** 积分返还方式 ，批量-1 */
    public static final String POT_PLAN_LIST_RETURN_WAY_BATCH = "1";
    /** 积分计划查询属性优先级组合 属性名-区域代码 */
    public static final String POT_PLAN_ATTR_RIGHT_CITYCODE = "04";
    /** 积分计划查询属性优先级组合 属性名-区域代码-默认值 */
    public static final String POT_PLAN_ATTR_RIGHT_CITYCODE_DEFAULTVALUE = "000000";
    /** 积分计划查询属性优先级组合 属性名-机构号 */
    public static final String POT_PLAN_ATTR_RIGHT_BRC = "02";
    /** 积分计划查询属性优先级组合 属性名-机构号-默认值 */
    public static final String POT_PLAN_ATTR_RIGHT_BRC_DEFAULTVALUE = "000000000000";
    /** 积分计划查询属性优先级组合 属性名-渠道ID */
    public static final String POT_PLAN_ATTR_RIGHT_CHNLID = "01";
    /** 积分计划查询属性优先级组合 属性名-渠道ID-默认值 */
    public static final String POT_PLAN_ATTR_RIGHT_CHNLID_DEFAULTVALUE = "00";
    /** 积分计划查询属性优先级组合 属性名-交易码 */
    public static final String POT_PLAN_ATTR_RIGHT_TRANSCODE = "05";
    /** 积分计划查询属性优先级组合 属性名-交易码-默认值 */
    public static final String POT_PLAN_ATTR_RIGHT_TRANSCODE_DEFAULTVALUE = "00000000000000000";
    /** 积分计划查询属性优先级组合 属性名-行为码 */
    public static final String POT_PLAN_ATTR_RIGHT_ACTCODE = "03";
    /** 积分计划查询属性优先级组合 属性名-行为码-默认值 */
    public static final String POT_PLAN_ATTR_RIGHT_ACTCODE_DEFAULTVALUE = "000000000000";
    /** 通用积分等价现价值参数 */
    public static final String SYSPARECASHNAME = "potMainCode123456";
    /** 交易积分类型 通用10 */
    public static final String POTTYPE_GENPOT = "10";
    /** 交易积分类型 专项01 */
    public static final String POTTYPE_SPEPOT = "01";
    /** 交易积分类型 通用积分和专项积分11 */
    public static final String POTTYPE_GEN_SPEPOOT = "11";
    /** 入账标志0-成功 */
    public static final String INFLAG_TRUE = "0";
    /** 入账标志 1-失败 */
    public static final String INFLAG_FALSE = "1";
    /** 在途生效状态 1：已生效 */
    public static final String ACTIVESTAT_TRUE = "1";
    /** 在途生效状态0：待生效（在途） */
    public static final String ACTIVESTAT_FALSE = "0";

    /** 积分交易状态 N正常 */
    public static final String POT_TRANS_STAT_NORMAL = "N";

    /** 积分交易流水响应信息 成功 */
    public static final String POT_TRANS_RSP_MSG_SUCCESS = "交易成功";
    /** 积分交易流水响应代码 成功 */
    public static final String POT_TRANS_RSP_CODE_SUCCESS = "0000000000";
    /** 积分交易流水响应信息 失败 */
    public static final String POT_TRANS_RSP_MSG_MANAGE = "处理中";
    /** 积分交易流水响应代码 处理中 */
    public static final String POT_TRANS_RSP_CODE_MANAGE = "0000000002";
    /** 积分交易流水响应信息 处理中 */
    public static final String POT_TRANS_RSP_MSG_FAIL = "失败";
    /** 积分交易流水响应代码 失败 */
    public static final String POT_TRANS_RSP_CODE_FAIL = "0000000001";
    /** 抹账标志 自动 A */
    public static final String CNAL_FLAG_A = "A";
    /** 抹账标志 手动 M */
    public static final String CNAL_FLAG_M = "M";
    /** 摘要码 */
    public static final String REMARK_CODE = "200";
    /** 批量 凭证类型-积分账号 */
    public static final String POT_BAT_VOUCH_TYPE_ACCT = "A";
    /** 批量 凭证类型-手机号 */
    public static final String POT_BAT_VOUCH_TYPE_PHONE = "B";
    /** 批量 凭证类型-登录名 */
    public static final String POT_BAT_VOUCH_TYPE_LOGINNAME = "C";
    /** 批量 凭证类型-客户号 */
    public static final String POT_BAT_VOUCH_TYPE_CUSNUMBER = "D";
    /** 积分可用状态 未使用 */
    public static final String POT_LIST_POT_USE_STAT_AVAILABLE = "0";
    /** 积分可用状态 已使用 */
    public static final String POT_LIST_POT_USE_STAT_DONE = "1";
    /** 积分可用状态 已失效 */
    public static final String POT_LIST_POT_USE_STAT_DISAVAILABLE = "2";
    /** 批量记录处理状态 未处理-0 */
    public static final String POT_BAT_DEAL_STAT_NOTSTART = "0";
    /** 批量记录处理状态 成功-1 */
    public static final String POT_BAT_DEAL_STAT_SUCCESS = "1";
    /** 批量记录处理状态 失败-2 */
    public static final String POT_BAT_DEAL_STAT_FAIL = "2";
    /** 批量入库 无效的用户ID-00000000000000 */
    public static final String POT_BAT_USER_ID_DISAVAILABLE = "00000000000000";
    /** 终端明细对账标志 0-未对账 */
    public static final String POT_CHANCHK_FLAG = "0";
    /** 用户认证等级4 */
    public static final Integer POT_USERCERTLEVEL = 4;
    /** 积分转让核心抹账失败 */
    public static final String RSPMSG_HOST_FAIL = "积分转让核心抹账失败";
    /** 批量积分交易入账标志 未入账-0 */
    public static final String POT_BAT_ACCT_IN_FLAG_NOTDONE = "0";
    /** 批量积分交易入账标志 已入账-1 */
    public static final String POT_BAT_ACCT_IN_FLAG_DONE = "1";
    /** 批量积分交易入账标志 部分入账-2 */
    public static final String POT_BAT_ACCT_IN_FLAG_PARTDONE = "2";
    /** 批量积分交易核算标志 未核算-0 */
    public static final String POT_BAT_ACCTING_FLAG_NOTDONE = "0";
    /** 批量积分交易核算标志 已核算-1 */
    public static final String POT_BAT_ACCTING_FLAG_DONE = "1";
    /** 积分批量调整方式 - 调增 0 */
    public static final String POT_BAT_ADJUTYPE_FLAG_ADD = "0";
    /** 积分批量调整方式 - 调减 1 */
    public static final String POT_BAT_ADJUTYPE_FLAG_SUBTRACT = "1";
    /** 撤消标志- 否0 */
    public static final String CANCEL_FLAG_NO = "0";
    /** 撤消标志- 是1 */
    public static final String CANCEL_FLAG_YES = "1";
    /** 批量记录处理结果代码 成功-000000 */
    public static final String POT_BAT_PROC_CODE_SUCCESS = "000000";
    /** 批量记录处理结果代码 失败成功-非000000 */
    public static final String POT_BAT_PROC_CODE_FAIL = "013999";
    /** 积分批量调整交易代码，17位 */
    public static final String POT_BAT_TRAN_CODE_ADJUST = "batch_AdjustPoint";
    /** 积分兑换电子现金 */
    public static final String POT_GENE_CODE_CASH = "CASH";

}
