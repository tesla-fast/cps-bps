package com.bpaas.bps.user.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bpaas.bps.common.api.CommonResult;
import com.bpaas.bps.common.constants.Constants_user;
import com.bpaas.bps.common.utils.DateUtil;
import com.bpaas.bps.common.utils.StringUtil;
import com.bpaas.bps.common.utils.UUIDGenerator;
import com.bpaas.bps.user.feign.AccountFeignClient;
import com.bpaas.bps.user.feign.BaseFeignClient;
import com.bpaas.bps.user.feign.UserCommonFeignClient;
import com.bpaas.bps.user.mapper.UsrBaseInfoMapper;
import com.bpaas.bps.user.mapper.UsrMobileMapInfoMapper;
import com.bpaas.bps.user.mapper.UsrRegInfoMapper;
import com.bpaas.bps.user.po.UsrBaseInfoPo;
import com.bpaas.bps.user.po.UsrMobileMapInfoPo;
import com.bpaas.bps.user.po.UsrRegInfoPo;
import com.bpaas.bps.user.service.UserRegService;

@Service("userRegService")
public class UserRegServiceImpl implements UserRegService {
	private static final Logger logger = LoggerFactory.getLogger(UserRegServiceImpl.class);
	
	@Autowired
	private UsrRegInfoMapper usrRegInfoMapper;
	@Autowired
	private UsrBaseInfoMapper usrBaseInfoMapper;
	@Autowired
	private UsrMobileMapInfoMapper usrMobileMapInfoMapper;
	@Autowired
	private BaseFeignClient feignClient;
	@Autowired
	private UserCommonFeignClient userCommonFeignClient;
	@Autowired
	private AccountFeignClient accountFeignClient;
	
	@Override
	public CommonResult<Object> regCheck(Map<String, Object> reqData) {
		String mobile = reqData.get("mobile").toString();
		Map<String, Object> cache = new HashMap<String, Object>();
		/*手机号白名单检查*/
		try {
			cache.put("mobile", mobile);
			userCommonFeignClient.whiteInfoQuery(cache);
		} catch (Exception e) {
			return CommonResult.failed(StringUtil.toString(e.getMessage()));
		}
		cache.put("flag", Constants_user.USER_CHECK_FLAG_0);
		/*手机号码绑定查询*/
		UsrMobileMapInfoPo usrMobileMapInfoPo = new UsrMobileMapInfoPo();
		usrMobileMapInfoPo.setMobile(mobile);
		usrMobileMapInfoPo.setStatus("0");
		List<UsrMobileMapInfoPo> selectList = usrMobileMapInfoMapper.selectList(usrMobileMapInfoPo);
		if (null != selectList && selectList.size() > 0) {
			mobile = ((UsrMobileMapInfoPo) selectList.get(0)).getLoginMobile();
		}
		UsrRegInfoPo usrRegInfoPo = new UsrRegInfoPo();
		usrRegInfoPo.setMobile(mobile);
		List<UsrRegInfoPo> usrRegInfoList = usrRegInfoMapper.selectList(usrRegInfoPo);
		if (usrRegInfoList != null && usrRegInfoList.size() > 0) {
			usrRegInfoPo = (UsrRegInfoPo)usrRegInfoList.get(0);
			String userStat = usrRegInfoPo.getUserStat();
			if (Constants_user.USR_STAT_NORMAL.equals(userStat) || Constants_user.USR_STAT_WAIT.equals(userStat)) {
				/*返回给调用方的数据*/
				cache.put("flag", Constants_user.USER_CHECK_FLAG_2);
				cache.put("loginMobile", usrRegInfoPo.getMobile());
				cache.put("isLoginPwd", Constants_user.USER_PWD_FLAG_Y);
				cache.put("isGasturePwd", usrRegInfoPo.getGasturePwdFlag());
				cache.put("isFingerPrintPwd", usrRegInfoPo.getFingerprintPwdFlag());
				cache.put("facePwdFlag", usrRegInfoPo.getFacePwdFlag());
				UsrBaseInfoPo usrBaseInfoPo = new UsrBaseInfoPo();
				usrBaseInfoPo.setUserId(usrRegInfoPo.getUserId());
				UsrBaseInfoPo selectOne = usrBaseInfoMapper.selectOne(usrBaseInfoPo);
				if (null != selectOne) {
					if (!StringUtils.isBlank(selectOne.getPicHead())) {
						cache.put("picHead", selectOne.getPicHead());
					}
				}
			}
		}
		return CommonResult.success(JSONObject.parseObject(JSONObject.toJSONString(cache)), "检查成功");
	}
	
	
	@Override
	public CommonResult<Object> regInfoRecord(Map<String, Object> reqData) {
		String channelId = reqData.get("channelId").toString();
		String mobile = reqData.get("mobile").toString();
		String loginPwd = reqData.get("loginPwd").toString();
		Map<String, Object> cache = new HashMap<String, Object>();
		
		/*保存用户注册信息*/
		try {
			/*调用其他服务，对密码进行加密和生成用户编号*/
			loginPwd = feignClient.decryPwd(loginPwd);
			String userId = feignClient.generateUserId();
			
			Date sysDataTime = DateUtil.getCurrentTime();
			UsrRegInfoPo usrRegInfoPo = new UsrRegInfoPo();
			usrRegInfoPo.setId(UUIDGenerator.randomUUID());
			usrRegInfoPo.setMobile(mobile);
			usrRegInfoPo.setLoginPwd(loginPwd);
			usrRegInfoPo.setUserId(userId);
			usrRegInfoPo.setLastLogpwdModifytime(sysDataTime);
			usrRegInfoPo.setRegTime(sysDataTime);
			usrRegInfoPo.setRegChnlId(channelId);
			usrRegInfoPo.setUserValueLevel(Constants_user.ISREALNAMEAUTH_NO);
			usrRegInfoPo.setUserStat(Constants_user.USER_STAT_NORMAL);
			usrRegInfoPo.setUserLockFlag(Constants_user.USER_LOCK_FLAG);
			usrRegInfoPo.setBlacklistFlag(Constants_user.BLACK_LIST_FLAG_NO);
			usrRegInfoPo.setActiveTime(DateUtil.getCurrentTime());
			usrRegInfoPo.setActiveChnlId(channelId);
			usrRegInfoPo.setLastUpdateTime(sysDataTime);
			usrRegInfoPo.setIfCallPwd(Constants_user.IF_CALL_PWD_NO);
			usrRegInfoPo.setUserCertLevel("01");
			usrRegInfoPo.setGasturePwdFlag(Constants_user.USER_PWD_FLAG_N);
			usrRegInfoPo.setFingerprintPwdFlag(Constants_user.USER_PWD_FLAG_N);
			usrRegInfoPo.setFacePwdFlag(Constants_user.USER_PWD_FLAG_N);
			String parmValue = feignClient.getParmValue("USR_DEFUALT_HEADPIC");
			if (null != parmValue) {
				usrRegInfoPo.setHeadPic(parmValue);
			}
			int num = usrRegInfoMapper.insert(usrRegInfoPo);
			if (num != 1) {
				return CommonResult.failed("用户注册信息保存失败，请重新注册！");
			}
			cache.put("userId", userId);
		} catch (Exception e) {
			logger.error("用户注册信息保存异常：{}", e);
			return CommonResult.failed("用户注册信息保存异常，请重新注册！");
		}
		
		try {
			/*创建一账通和积分账户*/
			cache.put("mobile", mobile);
			cache = accountFeignClient.regOneAccount(cache);
			cache = accountFeignClient.integralAcctOpen(cache);

			/*预登录、注册信息查询、设置登录session*/
			cache.putAll(reqData);
			cache = userCommonFeignClient.preLogin(cache);
			cache = userCommonFeignClient.regInfoQuery(cache);
			cache = userCommonFeignClient.loginSuccSession(cache);
		} catch (Exception e) {
			try {
				userCommonFeignClient.loginFailProcessor(cache);
			} catch (Exception e1) {
				logger.error("loginFailProcessor--->{}", e1);
			}
			return CommonResult.failed(StringUtil.toString(e.getMessage()));
		}
		
		/*更新登录时间*/
		try {
			userCommonFeignClient.updateLoginTime(cache);
		} catch (Exception e) {
			logger.error("updateLoginTime--->{}", e);
		}
		
		/*组装数据，统一返回给调用方*/
		Map<String, Object> rspData = new HashMap<String, Object>();
		rspData.put("userId", cache.get("userId"));
		rspData.put("eCardNo", cache.get("eCardNo"));
		rspData.put("certType", cache.get("certType"));
		rspData.put("certNo", cache.get("certNo"));
		rspData.put("certName", cache.get("certName"));
		rspData.put("userStat", cache.get("userStat"));
		rspData.put("mobile", cache.get("mobile"));
		rspData.put("userCertLevel", cache.get("userCertLevel"));
		rspData.put("userValueLevel", cache.get("userValueLevel"));
		rspData.put("lastLoginTime", cache.get("lastLoginTime"));
		rspData.put("sessionId", cache.get("sessionId"));
		rspData.put("loginDevice", cache.get("loginDevice"));
		rspData.put("regTime", cache.get("regTime"));
		
		return CommonResult.success(JSONObject.parseObject(JSONObject.toJSONString(rspData)), "注册成功");
	}

}
