package com.bpaas.bps.user.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bpaas.bps.common.api.CommonResult;
import com.bpaas.bps.common.constants.Constants_user;
import com.bpaas.bps.common.utils.StringUtil;
import com.bpaas.bps.common.utils.UUIDGenerator;
import com.bpaas.bps.user.feign.UserCommonFeignClient;
import com.bpaas.bps.user.mapper.UsrBaseInfoMapper;
import com.bpaas.bps.user.mapper.UsrMobileMapInfoMapper;
import com.bpaas.bps.user.mapper.UsrRegInfoMapper;
import com.bpaas.bps.user.po.UsrBaseInfoPo;
import com.bpaas.bps.user.po.UsrMobileMapInfoPo;
import com.bpaas.bps.user.po.UsrRegInfoPo;
import com.bpaas.bps.user.service.PwdManagerService;
import com.bpaas.bps.user.service.UserLoginService;

@Service("userLoginService")
public class UserLoginServiceImpl implements UserLoginService {
	private static final Logger logger = LoggerFactory.getLogger(UserLoginServiceImpl.class);
	
	@Autowired
	private UserCommonFeignClient userCommonFeignClient;
	@Autowired
	private PwdManagerService pwdManagerService;
	@Autowired
	private UsrRegInfoMapper usrRegInfoMapper;
	@Autowired
	private UsrBaseInfoMapper usrBaseInfoMapper;
	@Autowired
	private UsrMobileMapInfoMapper usrMobileMapInfoMapper;
	
	@Override
	public CommonResult<Object> pwdLogin(Map<String, Object> reqData) {
		try {
			/*预登录、密码检查*/
			reqData = userCommonFeignClient.preLogin(reqData);
			reqData = pwdManagerService.pwdChecked(reqData);
			
			/*注册信息查询、基本信息查询、成功设置session*/
			reqData = userCommonFeignClient.regInfoQuery(reqData);
			reqData = userCommonFeignClient.baseInfoQuery(reqData);
			reqData = userCommonFeignClient.loginSuccSession(reqData);
			
		} catch (Exception e) {
			/*密码错误次数累计*/
			
			try {
				/*登录失败处理*/
				userCommonFeignClient.loginFailProcessor(reqData);
			} catch (Exception e1) {
				logger.error("loginFailProcessor--->{}", e1);
			}
			return CommonResult.failed(StringUtil.toString(e.getMessage()));
		} 
		
		try {
			/*更新登录时间*/
			userCommonFeignClient.updateLoginTime(reqData);
		} catch (Exception e) {
			logger.error("updateLoginTime--->{}", e);
		}
		
		return CommonResult.success(assembData(reqData), "登录成功");
	}

	
	@Override
	public CommonResult<Object> faceLogin(Map<String, Object> reqData) {
		String flag = reqData.get("flag").toString();
		String loginMobile = reqData.get("loginMobile").toString();
		
		if (Constants_user.USER_CHECK_FLAG_3.equals(flag)) {
			try {
				reqData = userCommonFeignClient.preLogin(reqData);
			} catch (Exception e) {
				return CommonResult.failed(StringUtil.toString(e.getMessage()));
			}
		}
		
		/*检查是否已经实名认证*/
		UsrRegInfoPo usrRegInfoPo = new UsrRegInfoPo();
		usrRegInfoPo.setMobile(loginMobile);
		UsrRegInfoPo regInfo = usrRegInfoMapper.selectOne(usrRegInfoPo);
		if (null == regInfo) {
			return CommonResult.failed("未查到此用户注册信息");
		}
		if (Constants_user.USER_CHECK_FLAG_3.equals(flag) && !Constants_user.ISREALNAMEAUTH_YES.equals(regInfo.getUserCertLevel())) {
			return CommonResult.failed("非实名认证用户，请先实名认证！");
		}
		
		/*查询用户头像信息*/
		UsrBaseInfoPo usrBaseInfoPo = new UsrBaseInfoPo();
		usrBaseInfoPo.setUserId(regInfo.getUserId());
		UsrBaseInfoPo baseInfo = usrBaseInfoMapper.selectOne(usrBaseInfoPo);
		if (null != baseInfo) {
			if (StringUtils.isBlank(baseInfo.getPicHead())) {
				return CommonResult.failed("用户头像信息不存在");
			} else {
				reqData.put("imgB", baseInfo.getPicHead());
			}
		} else {
			return CommonResult.failed("用户基本信息不存在");
		}
		
		try {
			/*调用云从人脸比对接口*/
			userCommonFeignClient.faceCompare(reqData);
			
			/*开启刷脸登录*/
			if (Constants_user.USER_CHECK_FLAG_3.equals(flag)) {
				reqData.put("userId", regInfo.getUserId());
				reqData.put("pwdFlag", Constants_user.PWD_FLAG_TRADE_PWD);
				pwdManagerService.setLoginPwd(reqData);
				return CommonResult.success(null, "开启成功");
			}
			
			/*绑定手机号码*/
			if (Constants_user.USER_CHECK_FLAG_1.equals(flag)) {
				UsrMobileMapInfoPo usrMobileMapInfoPo = new UsrMobileMapInfoPo();
				usrMobileMapInfoPo.setId(UUIDGenerator.randomUUID());
				usrMobileMapInfoPo.setMobile((String)reqData.get("mobile"));
				usrMobileMapInfoPo.setLoginMobile(loginMobile);
				usrMobileMapInfoPo.setUserId(regInfo.getUserId());
				usrMobileMapInfoPo.setStatus("0");
				usrMobileMapInfoMapper.insert(usrMobileMapInfoPo);
			}
			
			/*注册信息查询、基本信息查询、成功设置session*/
			reqData = userCommonFeignClient.regInfoQuery(reqData);
			reqData = userCommonFeignClient.baseInfoQuery(reqData);
			userCommonFeignClient.loginSuccSession(reqData);
			/*调用BBM接口*/
		} catch (Exception e) {
			/*密码错误次数累计*/
			
			try {
				/*登录失败处理*/
				userCommonFeignClient.loginFailProcessor(reqData);
			} catch (Exception e1) {
				logger.error("loginFailProcessor--->{}", e1);
			}
			return CommonResult.failed(StringUtil.toString(e.getMessage()));
		}
		
		try {
			/*更新登录时间*/
			userCommonFeignClient.updateLoginTime(reqData);
		} catch (Exception e) {
			logger.error("updateLoginTime--->{}", e);
		}
		
		return CommonResult.success(assembData(reqData), "登录成功");
	}

	public JSONObject assembData(Map<String, Object> reqData) {
		/*组装数据，统一返回给调用方*/
		Map<String, Object> rspData = new HashMap<String, Object>();
		rspData.put("userId", reqData.get("userId"));
		rspData.put("certType", reqData.get("certType"));
		rspData.put("certNo", reqData.get("certNo"));
		rspData.put("certName", reqData.get("certName"));
		rspData.put("sex", reqData.get("sex"));
		rspData.put("age", reqData.get("age"));
		rspData.put("eduBg", reqData.get("eduBg"));
		rspData.put("empUnitName", reqData.get("empUnitName"));
		rspData.put("contactName", reqData.get("contactName"));
		rspData.put("birthday", reqData.get("birthday"));
		rspData.put("contactRelation", reqData.get("contactRelation"));
		rspData.put("contactPhone", reqData.get("contactPhone"));
		rspData.put("marriage", reqData.get("marriage"));
		rspData.put("userStat", reqData.get("userStat"));
		rspData.put("mobile", reqData.get("mobile"));
		rspData.put("userCertLevel", reqData.get("userCertLevel"));
		rspData.put("userValueLevel", reqData.get("userValueLevel"));
		rspData.put("lastLoginTime", reqData.get("lastLoginTime"));
		rspData.put("userName", reqData.get("userName"));
		rspData.put("userNickName", reqData.get("userNickName"));
		rspData.put("headPic", reqData.get("headPic"));
		rspData.put("email", reqData.get("email"));
		rspData.put("ifNoModPwd", reqData.get("ifNoModPwd"));
		rspData.put("sessionId", reqData.get("sessionId"));
		rspData.put("openAcctFlag", reqData.get("openAcctFlag"));
		rspData.put("openMobileBankFlag", reqData.get("openMobileBankFlag"));
		rspData.put("verifyCodeFlag", reqData.get("verifyCodeFlag"));
		rspData.put("verifyKey", reqData.get("verifyKey"));
		rspData.put("ifCallPwd", reqData.get("ifCallPwd"));
		rspData.put("loginDevice", reqData.get("loginDevice"));
		return JSONObject.parseObject(JSONObject.toJSONString(rspData));
	}
	
}
