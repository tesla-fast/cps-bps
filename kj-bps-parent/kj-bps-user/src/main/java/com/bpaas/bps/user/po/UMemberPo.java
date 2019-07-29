package com.bpaas.bps.user.po;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @Author: haowen.wang
 * @Date: 2019/5/31
 * @Description:
 * @version: 1.0
 */
public class UMemberPo {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "userid")
    private String userId;

    @ApiModelProperty(value = "会员等级id")
    private Long memberLevelId;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "登录密码")
    private String loginPwd;

    @ApiModelProperty(value = "最后一次登录密码修改时间")
    private Date lastLogpwdModifytime;

    @ApiModelProperty(value = "交易密码")
    private String tradePwd;

    @ApiModelProperty(value = "最后一次交易密码修改时间")
    private Date lastTradepwdModifytime;

    @ApiModelProperty(value = "手势密码")
    private String gasturePwd;

    @ApiModelProperty(value = "最后一次手势密码修改时间")
    private Date lastGasturepwdModifytime;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "身份证号码")
    private String idno;

    @ApiModelProperty(value = "帐号启用状态: 0->禁用；1->启用")
    private Integer status;

    @ApiModelProperty(value = "注册时间")
    private Date createTime;

    @ApiModelProperty(value = "注册渠道")
    private String regChlId;

    @ApiModelProperty(value = "头像")
    private String icon;

    @ApiModelProperty(value = "性别：0->未知；1->男；2->女")
    private Integer gender;

    @ApiModelProperty(value = "生日")
    private Date birthday;

    @ApiModelProperty(value = "所住城市")
    private String city;

    @ApiModelProperty(value = "职业")
    private String job;

    @ApiModelProperty(value = "个性签名")
    private String personalizedSignature;

    @ApiModelProperty(value = "用户来源")
    private Integer sourceType;

    @ApiModelProperty(value = "是否已实名认证: 100->是；101->否；默认值为101")
    private Short isrealnameauth;

    @ApiModelProperty(value = "积分")
    private Integer integration;

    @ApiModelProperty(value = "成长值")
    private Integer growth;

    @ApiModelProperty(value = "剩余抽奖次数")
    private Integer luckeyCount;

    @ApiModelProperty(value = "历史积分数量")
    private Integer historyIntegration;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Long getMemberLevelId() {
        return memberLevelId;
    }

    public void setMemberLevelId(Long memberLevelId) {
        this.memberLevelId = memberLevelId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd == null ? null : loginPwd.trim();
    }

    public Date getLastLogpwdModifytime() {
        return lastLogpwdModifytime;
    }

    public void setLastLogpwdModifytime(Date lastLogpwdModifytime) {
        this.lastLogpwdModifytime = lastLogpwdModifytime;
    }

    public String getTradePwd() {
        return tradePwd;
    }

    public void setTradePwd(String tradePwd) {
        this.tradePwd = tradePwd == null ? null : tradePwd.trim();
    }

    public Date getLastTradepwdModifytime() {
        return lastTradepwdModifytime;
    }

    public void setLastTradepwdModifytime(Date lastTradepwdModifytime) {
        this.lastTradepwdModifytime = lastTradepwdModifytime;
    }

    public String getGasturePwd() {
        return gasturePwd;
    }

    public void setGasturePwd(String gasturePwd) {
        this.gasturePwd = gasturePwd == null ? null : gasturePwd.trim();
    }

    public Date getLastGasturepwdModifytime() {
        return lastGasturepwdModifytime;
    }

    public void setLastGasturepwdModifytime(Date lastGasturepwdModifytime) {
        this.lastGasturepwdModifytime = lastGasturepwdModifytime;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno == null ? null : idno.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRegChlId() {
        return regChlId;
    }

    public void setRegChlId(String regChlId) {
        this.regChlId = regChlId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public String getPersonalizedSignature() {
        return personalizedSignature;
    }

    public void setPersonalizedSignature(String personalizedSignature) {
        this.personalizedSignature = personalizedSignature == null ? null : personalizedSignature.trim();
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public Short getIsrealnameauth() {
        return isrealnameauth;
    }

    public void setIsrealnameauth(Short isrealnameauth) {
        this.isrealnameauth = isrealnameauth;
    }

    public Integer getIntegration() {
        return integration;
    }

    public void setIntegration(Integer integration) {
        this.integration = integration;
    }

    public Integer getGrowth() {
        return growth;
    }

    public void setGrowth(Integer growth) {
        this.growth = growth;
    }

    public Integer getLuckeyCount() {
        return luckeyCount;
    }

    public void setLuckeyCount(Integer luckeyCount) {
        this.luckeyCount = luckeyCount;
    }

    public Integer getHistoryIntegration() {
        return historyIntegration;
    }

    public void setHistoryIntegration(Integer historyIntegration) {
        this.historyIntegration = historyIntegration;
    }
}
