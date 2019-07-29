package com.bpaas.bps.user.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bpaas.bps.common.api.CommonResult;
import com.bpaas.bps.common.constants.CmparmConstants;
import com.bpaas.bps.common.constants.Constants_gnr;
import com.bpaas.bps.common.constants.Constants_user;
import com.bpaas.bps.common.utils.DateUtil;
import com.bpaas.bps.common.utils.SecurityPassword;
import com.bpaas.bps.user.feign.BaseFeignClient;
import com.bpaas.bps.user.feign.UserCommonFeignClient;
import com.bpaas.bps.user.mapper.UsrLockBookMapper;
import com.bpaas.bps.user.mapper.UsrPwdListMapper;
import com.bpaas.bps.user.mapper.UsrRegInfoMapper;
import com.bpaas.bps.user.po.UsrLockBookPo;
import com.bpaas.bps.user.po.UsrPwdListPo;
import com.bpaas.bps.user.po.UsrRegInfoPo;
import com.bpaas.bps.user.service.PwdManagerService;

@Service("pwdManagerService")
public class PwdManagerServiceImpl implements PwdManagerService {
	private static final Logger logger = LoggerFactory.getLogger(PwdManagerServiceImpl.class);

	@Autowired
	private UsrRegInfoMapper usrRegInfoMapper;
	@Autowired
	private UserCommonFeignClient userCommonFeignClient;
	@Autowired
	private UsrLockBookMapper usrLockBookMapper;
	@Autowired
	private UsrPwdListMapper usrPwdListMapper;
	@Autowired
	private BaseFeignClient feignClient;

	@Override
	public CommonResult<Object> loginPwdMge(Map<String, Object> reqData) {
		String userId = (String) reqData.get("userId");
		String operFlag = reqData.get("operFlag").toString();
		String hisPwd = (String) reqData.get("hisPwd");
		String setPwd = reqData.get("setPwd").toString();
		try {
			reqData = userCommonFeignClient.regInfoQuery(reqData);
		} catch (Exception e) {
			return CommonResult.failed(e.getMessage());
		}
		userId = (String) reqData.get("userId");
		UsrRegInfoPo poCon = new UsrRegInfoPo();
		poCon.setUserId(userId);
		UsrRegInfoPo po = usrRegInfoMapper.selectOne(poCon);
		UsrRegInfoPo poVal = new UsrRegInfoPo();
		String newPwd = SecurityPassword.decryPassword(setPwd);
		if (Constants_user.USER_PWD_OPER_FLAG_0.equals(operFlag)) {
			boolean verify = SecurityPassword.verify(hisPwd, po.getLoginPwd());
			if (!verify) {
				return CommonResult.failed("原登录密码不正确");
			} else {
				poVal.setLoginPwd(newPwd);
				poVal.setLastLogpwdModifytime(DateUtil.getCurrentTime());
			}
		} else if (Constants_user.USER_PWD_OPER_FLAG_1.equals(operFlag)) {
			poVal.setLoginPwd(newPwd);
			poVal.setLastLogpwdModifytime(DateUtil.getCurrentTime());
		} else {
			return CommonResult.failed("操作类型非法");
		}
		int num = usrRegInfoMapper.update(poVal, poCon);
		if (num != 1) {
			return CommonResult.failed("密码处理失败");
		}
		return CommonResult.success(null, "密码处理成功");
	}

	@Override
	public CommonResult<Object> loginPwdClose(Map<String, Object> reqData) {
		String userId = reqData.get("userId").toString();
		String pwdFlag = reqData.get("pwdFlag").toString();
		String openFlag = reqData.get("openFlag").toString();
		UsrRegInfoPo usrRegInfoPo = new UsrRegInfoPo();
		usrRegInfoPo.setUserId(userId);
		usrRegInfoPo = usrRegInfoMapper.selectOne(usrRegInfoPo);
		if (null == usrRegInfoPo) {
			return CommonResult.failed("用户注册信息不存在");
		}
		UsrRegInfoPo usrRegInfoVal = new UsrRegInfoPo();
		if (Constants_user.USER_PWD_FLAG_N.equals(openFlag)) {
			if (Constants_user.PWD_FLAG_GESTURE_PWD.equals(pwdFlag)) {
				usrRegInfoVal.setGasturePwdFlag(Constants_user.USER_PWD_FLAG_N);
			} else if (Constants_user.PWD_FLAG_FINGERPRINT_PWD.equals(pwdFlag)) {
				usrRegInfoVal.setFingerprintPwdFlag(Constants_user.USER_PWD_FLAG_N);
			} else if (Constants_user.PWD_FLAG_FACE_PWD.equals(pwdFlag)) {
				usrRegInfoVal.setFacePwdFlag(Constants_user.USER_PWD_FLAG_N);
			} else {
				logger.debug("BUSINESS: 渠道上传的密码标识错误：{}", pwdFlag);
				return CommonResult.failed("密码标识非法");
			}
		}
		int num = usrRegInfoMapper.update(usrRegInfoVal, usrRegInfoPo);
		if (num != 1) {
			return CommonResult.failed("操作失败");
		}
		return CommonResult.success(null, "操作成功");
	}

	@Override
	public Map<String, Object> pwdChecked(Map<String, Object> reqData) throws Exception {
		String userId = reqData.get("userId").toString();
		String loginPwd = reqData.get("loginPwd").toString();
		String chnlId = (String) reqData.get("channelId");
		String sessionId = (String) reqData.get("sessionId");
		sessionReset(chnlId, userId, sessionId);
		String pwdFlag = reqData.get("pwdFlag").toString();
		Date sysTime = DateUtil.getCurrentTime();

		String hostChkFlag = "0";// 用于标识交易密码在那里进行校验 0金融超市进行校验 1核心进行校验
		Date sysDate = DateUtil.parse(DateUtil.format(new Date(), "yyyy/MM/dd"), "yyyy/MM/dd");

		UsrRegInfoPo usrRegInfo = new UsrRegInfoPo();
		usrRegInfo.setUserId(userId);
		usrRegInfo.setUserStat(Constants_user.USR_STAT_NORMAL);
		usrRegInfo = usrRegInfoMapper.selectOne(usrRegInfo);
		if (usrRegInfo == null) {
			throw new RuntimeException("用户不存在");
		}
		UsrLockBookPo usrLockBookPo = new UsrLockBookPo();
		if (Constants_user.PWD_FLAG_LOGIN_PWD.equals(pwdFlag)) {
			if (Constants_user.USER_LOCK_FLAG_NORMAL
					.equals(StringUtils.substring(usrRegInfo.getUserLockFlag(), 0, 1))) {
				boolean verify = SecurityPassword.verify(loginPwd, usrRegInfo.getLoginPwd());
				if (!verify) {
					errLogPwdDeal(userId, sysDate);
				}
			} else {
				usrLockBookPo.setLockFlag(Constants_user.LOCK_FLAG_LOCK);
				usrLockBookPo.setLockFunction(pwdFlag);
				usrLockBookPo.setUserId(userId);
				usrLockBookPo = usrLockBookMapper.selectOne(usrLockBookPo);
				if (usrLockBookPo != null) {
					String lockMode = usrLockBookPo.getLockMode();
					if (!Constants_user.LOCK_WAY_ADMIN.equals(usrLockBookPo.getLockWay())) {
						if (Constants_user.LOCK_MODE_TEMPORARY_LOCK.equals(lockMode)) {
							Date lockTime = usrLockBookPo.getLockTime();
							int partLockHour = usrLockBookPo.getPartLockHour();
							lockTime = DateUtil.add(lockTime, Calendar.HOUR, partLockHour);
							if (sysTime.compareTo(lockTime) < 0) {
								long times = DateUtil.betweenTimes(lockTime, sysTime);
								String lastTimesDesc = new StringBuffer(String.valueOf(times / 3600)).append("小时")
										.append(times / 60 - times / 3600 * 60).append("分钟").append(times % 60)
										.append("秒").toString();
								clearLogPwdTimes(userId, null);
								throw new RuntimeException("登录已被锁定，[" + lastTimesDesc + "]后再试");
							} else {
								if (loginPwd.equals(usrRegInfo.getLoginPwd())) {
									clearLogPwdTimes(userId, null);
								} else {
									errLogPwdDeal(userId, sysDate);
								}
							}
						} else {
							throw new RuntimeException("登录密码已被锁定，请重置登录密码");
						}
					} else {
						throw new RuntimeException("您已经被系统锁定， 请联系客服");
					}
				}
			}
		} else if (Constants_user.PWD_FLAG_GESTURE_PWD.equals(pwdFlag)) {// 手势密码登陆
			if (Constants_user.USER_LOCK_FLAG_NORMAL
					.equals(StringUtils.substring(usrRegInfo.getUserLockFlag(), 0, 1))) {
				if (!loginPwd.equals(usrRegInfo.getGasturePwd())) {
					errGesturePwdDeal(userId, sysDate);
					throw new RuntimeException("手势密码错误");
				}
			} else {
				throw new RuntimeException("手势密码失效，请使用密码登录");
			}
		}
		reqData.put("pwdCheckFlag", Constants_user.PWD_CHECK_FLAG);
		reqData.put("pwdFlag", pwdFlag);
		reqData.put("hostChkFlag", hostChkFlag);
		if (Constants_user.PWD_FLAG_LOGIN_PWD.equals(pwdFlag)) {
			clearLogPwdTimes(userId, null);
		}
		logger.debug("------------------------end" + pwdFlag + "--------------------------------");
		return reqData;
	}

	/**
	 * 手势密码错误处理方式
	 * 
	 * @param userId
	 * @param sysDate
	 * @param pwdCheckDto
	 */
	private void errGesturePwdDeal(String userId, Date sysDate) throws Exception {
		long GestureDayErr = 1;
		UsrPwdListPo usrPwdListPo = new UsrPwdListPo();
		usrPwdListPo.setUserId(userId);
		usrPwdListPo.setCountDate(sysDate);
		usrPwdListPo = usrPwdListMapper.selectOne(usrPwdListPo);
		long logDayMaxErr = Long.parseLong(feignClient.getParmValue(CmparmConstants.GESTURE_DAY_MAX_ERR));
		long logDayRemainderErr = logDayMaxErr - GestureDayErr;
		if (usrPwdListPo != null) {
			GestureDayErr = usrPwdListPo.getGestureDayErr() + 1;
			logDayRemainderErr = logDayMaxErr - GestureDayErr;
		}
		if (logDayRemainderErr > 0) {
			throw new RuntimeException("用户手势登录密码错误,您还有[" + logDayRemainderErr + "]次机会");
		} else {
			throw new RuntimeException("手势密码失效，请使用密码登录");
		}
	}

	private void errLogPwdDeal(String userId, Date sysDate) throws Exception {
		long logDayErr = 1;
		UsrPwdListPo usrPwdListPo = new UsrPwdListPo();
		usrPwdListPo.setUserId(userId);
		usrPwdListPo.setCountDate(sysDate);
		usrPwdListPo = usrPwdListMapper.selectOne(usrPwdListPo);
		long logDayMaxErr = Long.parseLong(feignClient.getParmValue(CmparmConstants.LOG_DAY_MAX_ERR));
		long logDayRemainderErr = logDayMaxErr - logDayErr;
		if (usrPwdListPo != null) {
			logDayErr = usrPwdListPo.getLogDayErr() + 1;
			logDayRemainderErr = logDayMaxErr - logDayErr;
			if (logDayRemainderErr == 0) {
				long logTotErr = usrPwdListPo.getLogTotErr() + 1;
				long logTotMaxErr = Long.parseLong(feignClient.getParmValue(CmparmConstants.LOG_TOT_MAX_ERR));
				if (logTotErr == logTotMaxErr) {
					throw new RuntimeException("密码已被锁定，请重置登录密码");
				}
			}
		}
		if (logDayRemainderErr > 0) {
			throw new RuntimeException("账号或密码错误，,您还有[" + logDayRemainderErr + "]次机会");
		} else {
			throw new RuntimeException("登录密码已被锁定，[{"
					+ Long.parseLong(feignClient.getParmValue(CmparmConstants.LOG_TEMP_HOUR)) + "}]小时后再试");
		}
	}

	/**
	 * 当为登录密码时，如果校验通过，判断本次会话用户是否有输入登录密码的错误次数，如果有则清空缓存
	 * 
	 * @param pwdCheckDto
	 */
	private void clearLogPwdTimes(String userId, String cacheKey) {
		if (StringUtils.isBlank(cacheKey)) {
			cacheKey = userId;
			/*
			 * if
			 * (!cacheClient.keyExists(CacheConstants.LOGIN_PWD_ERROR_TIMES.concat(cacheKey)
			 * )) { cacheClient.set(CacheConstants.LOGIN_PWD_ERROR_TIMES.concat(cacheKey),
			 * 1); }
			 */
		}
		/*
		 * if
		 * (cacheClient.keyExists(CacheConstants.LOGIN_PWD_ERROR_TIMES.concat(cacheKey))
		 * ) {
		 * cacheClient.delete(CacheConstants.LOGIN_PWD_ERROR_TIMES.concat(cacheKey)); }
		 */
	}

	/**
	 * 当交易成功后，重置session会话为默认会话时间
	 * 
	 * @param chnlId
	 * @param userId
	 * @param sessionId
	 */
	private void sessionReset(String chnlId, String userId, String sessionId) {
		if (Constants_gnr.CHNL_ID_APP.equals(chnlId)) {
			/*
			 * if (cacheClient.keyExists(CacheConstants.SESSION_APP.concat(userId))) { int
			 * sessionValidMinute =
			 * Integer.valueOf(feignClient.getParmValue(CmparmConstants.
			 * SESSION_APP_INVALID_MINUTE); cacheClient
			 * .set(CacheConstants.SESSION_APP.concat(userId), sessionId, sessionValidMinute
			 * * 60); }
			 */
		} else if (Constants_gnr.CHNL_ID_WEB.equals(chnlId)) {
			/*
			 * if (cacheClient.keyExists(CacheConstants.SESSION_WEB.concat(userId))) { int
			 * sessionValidMinute =
			 * Integer.valueOf(feignClient.getParmValue(CmparmConstants.
			 * SESSION_WEB_INVALID_MINUTE).toString());
			 * cacheClient.set(CacheConstants.SESSION_WEB.concat(userId), sessionId,
			 * sessionValidMinute * 60); }
			 */
		}
	}

	@Override
	public Map<String, Object> setLoginPwd(Map<String, Object> reqData) throws Exception {
		String userId = (String) reqData.get("userId");
		String pwdFlag = (String) reqData.get("pwdFlag");
		String setPwd = (String) reqData.get("setPwd");
		UsrRegInfoPo usrRegInfoCon = new UsrRegInfoPo();
		usrRegInfoCon.setUserId(userId);
		UsrRegInfoPo usrRegInfoVal = new UsrRegInfoPo();
		if (Constants_user.PWD_FLAG_LOGIN_PWD.equals(pwdFlag)) {
			String decryPassword = SecurityPassword.decryPassword(setPwd);
			usrRegInfoVal.setLoginPwd(decryPassword);
			usrRegInfoVal.setLastLogpwdModifytime(DateUtil.getCurrentTime());
		} else if (Constants_user.PWD_FLAG_GESTURE_PWD.equals(pwdFlag)) {
			usrRegInfoVal.setGasturePwdFlag(Constants_user.USER_PWD_FLAG_Y);
			usrRegInfoVal.setGasturePwd(setPwd);
			usrRegInfoVal.setLastGasturepwdModifytime(DateUtil.getCurrentTime());
		} else if (Constants_user.PWD_FLAG_FINGERPRINT_PWD.equals(pwdFlag)) {
			usrRegInfoVal.setFingerprintPwdFlag(Constants_user.USER_PWD_FLAG_Y);
			usrRegInfoVal.setFingerprintPwd(setPwd);
		} else if (Constants_user.PWD_FLAG_TRADE_PWD.equals(pwdFlag)) {
			usrRegInfoVal.setTradePwd(setPwd);
			usrRegInfoVal.setLastTradepwdModifytime(DateUtil.getCurrentTime());
		} else if (Constants_user.PWD_FLAG_FACE_PWD.equals(pwdFlag)) {
			usrRegInfoVal.setFacePwdFlag(Constants_user.USER_PWD_FLAG_Y);
		} else {
			throw new RuntimeException("参数pwdFlag值非法！");
		}
		usrRegInfoMapper.update(usrRegInfoVal, usrRegInfoCon);
		return reqData;
	}
	
}
