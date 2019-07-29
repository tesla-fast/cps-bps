package com.bpaas.bps.acc.po;

public class AccElistPo{

    /**
     * 交易时间       db_column: TRANS_TIME 
     */ 	
	private java.util.Date transTime;
    /**
     * 交易流水号       db_column: TRANS_SEQ 
     */ 	
	private java.lang.String transSeq;
    /**
     * 交易代码       db_column: TRANS_CODE 
     */ 	
	private java.lang.String transCode;
    /**
     * 交易渠道       db_column: CHNL_ID 
     */ 	
	private java.lang.String chnlId;
    /**
     * 渠道时间       db_column: CHNL_TIME 
     */ 	
	private java.util.Date chnlTime;
    /**
     * 渠道流水号       db_column: CHNL_SEQ 
     */ 	
	private java.lang.String chnlSeq;
    /**
     * 用户号       db_column: USER_ID 
     */ 	
	private java.lang.String userId;
    /**
     * 电子账户卡号       db_column: E_CARD_NO 
     */ 	
	private java.lang.String ecardNo;
    /**
     * 对应的核心活期存款账号       db_column: E_ACCT_NO 
     */ 	
	private java.lang.String eacctNo;
    /**
     * 对方账户类型       db_column: REL_ACCT_TYPE 
     */ 	
	private java.lang.String relAcctType;
    /**
     * 对方账户机构代码       db_column: REL_ACCT_BRC 
     */ 	
	private java.lang.String relAcctBrc;
    /**
     * 对方账户       db_column: REL_ACCT 
     */ 	
	private java.lang.String relAcct;
    /**
     * 对方户名       db_column: REL_NAME 
     */ 	
	private java.lang.String relName;
    /**
     * 交易状态       db_column: TRANS_STAT 
     */ 	
	private java.lang.String transStat;
    /**
     * 交易币种       db_column: CCY 
     */ 	
	private java.lang.String ccy;
    /**
     * 交易金额       db_column: TRANS_AMT 
     */ 	
	private java.math.BigDecimal transAmt;
    /**
     * 手续费       db_column: CUST_FEE 
     */ 	
	private java.math.BigDecimal custFee;
    /**
     * 账户余额       db_column: ACCT_BAL 
     */ 	
	private java.math.BigDecimal acctBal;
    /**
     * 借贷标志       db_column: DC_FLAG 
     */ 	
	private java.lang.String dcFlag;
    /**
     * 摘要码       db_column: MEMO_CODE 
     */ 	
	private java.lang.String memoCode;
    /**
     * 摘要信息       db_column: MEMO_MSG 
     */ 	
	private java.lang.String memoMsg;
    /**
     * 备用字段1       db_column: REMARK1 
     */ 	
	private java.lang.String remark1;
    /**
     * 备用字段2       db_column: REMARK2 
     */ 	
	private java.lang.String remark2;
    /**
     * 引擎编号       db_column: CALL_NUM 
     */ 	
	private java.lang.Integer callNum;
    /**
     * 分录序号       db_column: SEQ 
     */ 	
	private java.lang.Integer seq;
	//columns END


	
	
	public java.util.Date getTransTime() {
		return this.transTime;
	}
	
	public void setTransTime(java.util.Date value) {
		this.transTime = value;
	}
	
	
	public java.lang.String getTransSeq() {
		return this.transSeq;
	}
	
	public void setTransSeq(java.lang.String value) {
		this.transSeq = value;
	}
	
	
	public java.lang.String getTransCode() {
		return this.transCode;
	}
	
	public void setTransCode(java.lang.String value) {
		this.transCode = value;
	}
	
	
	public java.lang.String getChnlId() {
		return this.chnlId;
	}
	
	public void setChnlId(java.lang.String value) {
		this.chnlId = value;
	}
	
	
	public java.util.Date getChnlTime() {
		return this.chnlTime;
	}
	
	public void setChnlTime(java.util.Date value) {
		this.chnlTime = value;
	}
	
	
	public java.lang.String getChnlSeq() {
		return this.chnlSeq;
	}
	
	public void setChnlSeq(java.lang.String value) {
		this.chnlSeq = value;
	}
	
	
	public java.lang.String getUserId() {
		return this.userId;
	}
	
	public void setUserId(java.lang.String value) {
		this.userId = value;
	}
	
	
	public java.lang.String getEcardNo() {
		return this.ecardNo;
	}
	
	public void setEcardNo(java.lang.String value) {
		this.ecardNo = value;
	}
	
	
	public java.lang.String getEacctNo() {
		return this.eacctNo;
	}
	
	public void setEacctNo(java.lang.String value) {
		this.eacctNo = value;
	}
	
	
	public java.lang.String getRelAcctType() {
		return this.relAcctType;
	}
	
	public void setRelAcctType(java.lang.String value) {
		this.relAcctType = value;
	}
	
	
	public java.lang.String getRelAcctBrc() {
		return this.relAcctBrc;
	}
	
	public void setRelAcctBrc(java.lang.String value) {
		this.relAcctBrc = value;
	}
	
	
	public java.lang.String getRelAcct() {
		return this.relAcct;
	}
	
	public void setRelAcct(java.lang.String value) {
		this.relAcct = value;
	}
	
	
	public java.lang.String getRelName() {
		return this.relName;
	}
	
	public void setRelName(java.lang.String value) {
		this.relName = value;
	}
	
	
	public java.lang.String getTransStat() {
		return this.transStat;
	}
	
	public void setTransStat(java.lang.String value) {
		this.transStat = value;
	}
	
	
	public java.lang.String getCcy() {
		return this.ccy;
	}
	
	public void setCcy(java.lang.String value) {
		this.ccy = value;
	}
	
	
	public java.math.BigDecimal getTransAmt() {
		return this.transAmt;
	}
	
	public void setTransAmt(java.math.BigDecimal value) {
		this.transAmt = value;
	}
	
	
	public java.math.BigDecimal getCustFee() {
		return this.custFee;
	}
	
	public void setCustFee(java.math.BigDecimal value) {
		this.custFee = value;
	}
	
	
	public java.math.BigDecimal getAcctBal() {
		return this.acctBal;
	}
	
	public void setAcctBal(java.math.BigDecimal value) {
		this.acctBal = value;
	}
	
	
	public java.lang.String getDcFlag() {
		return this.dcFlag;
	}
	
	public void setDcFlag(java.lang.String value) {
		this.dcFlag = value;
	}
	
	
	public java.lang.String getMemoCode() {
		return this.memoCode;
	}
	
	public void setMemoCode(java.lang.String value) {
		this.memoCode = value;
	}
	
	
	public java.lang.String getMemoMsg() {
		return this.memoMsg;
	}
	
	public void setMemoMsg(java.lang.String value) {
		this.memoMsg = value;
	}
	
	
	public java.lang.String getRemark1() {
		return this.remark1;
	}
	
	public void setRemark1(java.lang.String value) {
		this.remark1 = value;
	}
	
	
	public java.lang.String getRemark2() {
		return this.remark2;
	}
	
	public void setRemark2(java.lang.String value) {
		this.remark2 = value;
	}

	
	public java.lang.Integer getCallNum() {
		return callNum;
	}

	public void setCallNum(java.lang.Integer callNum) {
		this.callNum = callNum;
	}

	public java.lang.Integer getSeq() {
		return this.seq;
	}
	
	public void setSeq(java.lang.Integer value) {
		this.seq = value;
	}
	

	

}

