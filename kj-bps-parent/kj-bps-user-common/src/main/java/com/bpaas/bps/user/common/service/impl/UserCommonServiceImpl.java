package com.bpaas.bps.user.common.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bpaas.bps.common.constants.CmparmConstants;
import com.bpaas.bps.common.constants.Constants_gnr;
import com.bpaas.bps.common.constants.Constants_user;
import com.bpaas.bps.common.utils.DateUtil;
import com.bpaas.bps.common.utils.InitData;
import com.bpaas.bps.common.utils.UUIDGenerator;
import com.bpaas.bps.user.common.feign.BaseFeignClient;
import com.bpaas.bps.user.common.mapper.UsrBaseInfoMapper;
import com.bpaas.bps.user.common.mapper.UsrChnlBaseInfoMapper;
import com.bpaas.bps.user.common.mapper.UsrLogListMapper;
import com.bpaas.bps.user.common.mapper.UsrRegInfoMapper;
import com.bpaas.bps.user.common.mapper.UsrWhiteMapper;
import com.bpaas.bps.user.common.po.UsrBaseInfoPo;
import com.bpaas.bps.user.common.po.UsrChnlBaseInfoPo;
import com.bpaas.bps.user.common.po.UsrLogListPo;
import com.bpaas.bps.user.common.po.UsrRegInfoPo;
import com.bpaas.bps.user.common.po.UsrWhitePo;
import com.bpaas.bps.user.common.service.UserCommonService;

@Service("userCommonService")
public class UserCommonServiceImpl implements UserCommonService<Map<String, Object>> {
	private static final Logger logger = LoggerFactory.getLogger(UserCommonServiceImpl.class);

	@Autowired
	private BaseFeignClient feignClient;
	@Autowired
	private UsrWhiteMapper usrWhiteMapper;
	@Autowired
	private UsrRegInfoMapper usrRegInfoMapper;
	@Autowired
	private UsrChnlBaseInfoMapper usrChnlBaseInfoMapper;
	@Autowired
	private UsrLogListMapper usrLogListMapper;
	@Autowired
	private UsrBaseInfoMapper usrBaseInfoMapper;

	@Override
	public Map<String, Object> whiteInfoQuery(Map<String, Object> cache) throws Exception{
		try {
			boolean whitelistFlag = false;
			String parmValue = feignClient.getParmValue("GET_WHITELIST_FLAG");
			if (parmValue != null) {
				whitelistFlag = Boolean.parseBoolean(parmValue);
			}
			if (!whitelistFlag) {
				return cache;
			}
			String mobile = (String) cache.get("mobile");
			UsrWhitePo usrWhitePo = new UsrWhitePo();
			usrWhitePo.setMobile(mobile);
			usrWhitePo = usrWhiteMapper.selectOne(usrWhitePo);
			if (usrWhitePo == null) {
				logger.info("手机号未在白名单中：{}", mobile);
				throw new RuntimeException("手机号未在白名单中：" + mobile);
			}
		} catch (RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		} catch (Exception e) {
			logger.error("检查用户白名单信息异常：{}", e);
			throw new RuntimeException("检查用户白名单信息异常");
		} 
		return cache;
	}

	@Override
	public Map<String, Object> preLogin(Map<String, Object> cache) throws Exception{
		String chnlId = (String) cache.get("channelId");
		String platForm = (String) cache.get("platForm");
		String userId = (String) cache.get("userId");
		String mobile = (String) cache.get("mobile");
		String flag = (String) cache.get("flag");
		if (Constants_user.USER_CHECK_FLAG_1.equals(flag) || Constants_user.USER_CHECK_FLAG_2.equals(flag)) {
			mobile = (String) cache.get("loginMobile");
		}
		String loginDevice = (String) cache.get("loginDevice");
		logger.debug("userId[" + userId + "],手机号[" + mobile + "]本次登陆 设备[" + loginDevice + "]");

		UsrRegInfoPo usrRegInfoPo = new UsrRegInfoPo();
		usrRegInfoPo.setMobile(mobile);
		usrRegInfoPo.setUserId(userId);
		usrRegInfoPo.setUserStat(Constants_user.USER_STAT_NORMAL);
		usrRegInfoPo = usrRegInfoMapper.selectOne(usrRegInfoPo);
		if (usrRegInfoPo != null) {
			userId = usrRegInfoPo.getUserId();
			// 最后一次登录时间
			Date lastLoginTime = usrRegInfoPo.getLastLoginTime();// 最后一次 成功登录时间
			logger.info("ChnlId: {}", chnlId);
			UsrChnlBaseInfoPo usrChnlBaseInfoWhere = new UsrChnlBaseInfoPo();
			usrChnlBaseInfoWhere.setUserId(userId);
			usrChnlBaseInfoWhere.setRegChnlId(chnlId);
			usrChnlBaseInfoWhere = usrChnlBaseInfoMapper.selectOne(usrChnlBaseInfoWhere);
			if (usrChnlBaseInfoWhere == null) {
				// 登记渠道信息表
				UsrChnlBaseInfoPo usrChnlBaseInfoPo = new UsrChnlBaseInfoPo();
				usrChnlBaseInfoPo.setId(UUIDGenerator.randomUUID());
				usrChnlBaseInfoPo.setUserId(userId);
				usrChnlBaseInfoPo.setRegChnlId(chnlId);
				usrChnlBaseInfoPo.setRegTime(new Date());
				usrChnlBaseInfoMapper.insert(usrChnlBaseInfoPo);
				logger.info("插入渠道信息表UsrChnlBaseInfoPo成功!");
			}
			logger.debug("用户注册表中lastLoginTime最后登陆时间：" + lastLoginTime);
			if (null != lastLoginTime) {
				logger.debug("用户注册表中lastLoginTime最后登陆时间：" + DateUtil.format(lastLoginTime, "yyyy-MM-dd HH:mm:ss"));
				// 注册时
				UsrLogListPo usrLogList = new UsrLogListPo();
				List<UsrLogListPo> userLogList = new ArrayList<UsrLogListPo>();
				usrLogList.setUserId(userId);
				usrLogList.setLoginTime(lastLoginTime);
				userLogList = usrLogListMapper.selectList(usrLogList);
				UsrLogListPo ull = userLogList.get(0);
				cache.put("loginDevice", ull.getLoginDevice());
				cache.put("loginTime", ull.getLoginTime());
				logger.debug("UsrLogListPo id[" + ull.getUserId() + "]最后登陆时间["
						+ DateUtil.format(ull.getLoginTime(), "yyyy-MM-dd HH:mm:ss") + "]，登录设备[" + ull.getLoginDevice()
						+ "]");
			}
			String sessionId = UUID.randomUUID().toString().replaceAll("-", "");
			String isMutiplueLogin = isMutiplueLogin(userId, chnlId, sessionId);
			// 插入信息到用户登录日志信息表
			UsrLogListPo usrLogListPo = new UsrLogListPo();
			usrLogListPo.setId(UUIDGenerator.randomUUID());
			usrLogListPo.setUserId(userId);
			usrLogListPo.setChnlId(chnlId);
			usrLogListPo.setLoginMode("1");
			usrLogListPo.setIsMutiplueLogin(isMutiplueLogin);
			usrLogListPo.setSessionId(sessionId);
			usrLogListPo.setPlatform(platForm);
			usrLogListPo.setLoginTime(DateUtil.getCurrentTime());
			usrLogListPo.setLogoutTime(DateUtil.getCurrentTime());
			usrLogListPo.setAddrGetFlag(Constants_user.ADDR_GET_FLAG_NO);
			usrLogListPo.setLoginStat(Constants_user.LOGIN_STAT_SUCCESS);
			usrLogListPo.setLoginDevice(loginDevice);
			usrLogListMapper.insert(usrLogListPo);

			cache.put("sessionId", sessionId);
			cache.put("userId", userId);
			cache.put("userStat", Constants_user.USER_STAT_NORMAL);
			cache.put("mobile", mobile);
		} else {
			cache.put("sessionId", UUID.randomUUID().toString().replaceAll("-", ""));
			cache.put("regflag", "0");
		}
		return cache;
	}

	/**
	 * 获取单点登录状态
	 * 
	 * @param userId
	 * @param chnlId
	 * @param sessionId
	 * @return
	 */
	private String isMutiplueLogin(String userId, String chnlId, String sessionId) throws Exception {
		String isMutiplueLogin = Constants_user.IS_MUTIPLUE_LOGIN_NO;
		// 判断多渠道登录的协同登录状态
		/*
		 * if (Constants_gnr.CHNL_ID_APP.equals(chnlId)) { String sessionWeb =
		 * cacheClient.get(CacheConstants.SESSION_WEB.concat(userId)); if
		 * (StringUtils.isNotBlank(sessionWeb)) { isMutiplueLogin =
		 * Constants_user.IS_MUTIPLUE_LOGIN_YES; } } else if
		 * (Constants_gnr.CHNL_ID_WEB.equals(chnlId)) { String sessionApp =
		 * cacheClient.get(CacheConstants.SESSION_APP.concat(userId)); if
		 * (StringUtils.isNotBlank(sessionApp)) { isMutiplueLogin =
		 * Constants_user.IS_MUTIPLUE_LOGIN_YES; } }
		 */
		return isMutiplueLogin;
	}

	@Override
	public Map<String, Object> regInfoQuery(Map<String, Object> cache) {
		String userId = (String) cache.get("userId");
		String mobile = (String) cache.get("mobile");
		String certNo = (String) cache.get("certNo");
		String userName = (String) cache.get("userName");
		logger.debug("userId[" + userId + "],mobile[" + mobile + "],certNo[" + certNo + "],userName[" + userName + "],");
		UsrRegInfoPo usrRegInfoPo = null;
		if (StringUtils.isNotBlank(userId)) {// 根据用户ID查询
			usrRegInfoPo = new UsrRegInfoPo();
			usrRegInfoPo.setUserId(userId);
			usrRegInfoPo.setUserStat(Constants_user.USER_STAT_NORMAL);
		} else {
			if (StringUtils.isNotBlank(mobile)) {// 根据手机号查询
				usrRegInfoPo = new UsrRegInfoPo();
				usrRegInfoPo.setMobile(mobile);
				usrRegInfoPo.setUserStat(Constants_user.USER_STAT_NORMAL);
			} else if (StringUtils.isNotBlank(certNo)) {// 根据证件号查询用户基本信息表获取到用户ID并反查用户注册信息表信息
				UsrBaseInfoPo usrBaseInfoPo = new UsrBaseInfoPo();
				certNo = StringUtils.upperCase(certNo);
				usrBaseInfoPo.setCertNo(certNo);
				usrBaseInfoPo.setCertType(Constants_user.CERT_TYPE_CERT);
				usrBaseInfoPo = usrBaseInfoMapper.selectOne(usrBaseInfoPo);
				if (null == usrBaseInfoPo) {
					logger.debug(" certNo[" + certNo + "]，certType[01] ---》 UsrBaseInfoPo =null ");
					InitData.fail(cache, "未查到用户基本信息");
				}
				userId = usrBaseInfoPo.getUserId();
				usrRegInfoPo = new UsrRegInfoPo();
				usrRegInfoPo.setUserId(userId);
				usrRegInfoPo.setUserStat(Constants_user.USER_STAT_NORMAL);
			} else if (StringUtils.isNotBlank(userName)) {// 根据用户名查询
				usrRegInfoPo = new UsrRegInfoPo();
				usrRegInfoPo.setUserName(userName);
				usrRegInfoPo.setUserStat(Constants_user.USER_STAT_NORMAL);
			}
		}
		usrRegInfoPo = usrRegInfoMapper.selectOne(usrRegInfoPo);
		if (usrRegInfoPo != null) {
			cache.put("userId", usrRegInfoPo.getUserId());
			cache.put("userStat", usrRegInfoPo.getUserStat());
			cache.put("userCertLevel", usrRegInfoPo.getUserCertLevel());
			cache.put("userValueLevel", usrRegInfoPo.getUserValueLevel());
			cache.put("userName", usrRegInfoPo.getUserName());
			cache.put("userNickName", usrRegInfoPo.getUserNickName());
			cache.put("headPic", usrRegInfoPo.getHeadPic());
			cache.put("regTime", usrRegInfoPo.getRegTime());
			cache.put("userCertLevel", usrRegInfoPo.getUserCertLevel());
			Date lastLoginTime = usrRegInfoPo.getLastLoginTime();
			if (lastLoginTime != null) {
				cache.put("lastLoginTime", DateUtil.format(usrRegInfoPo.getLastLoginTime(), "yyyy-MM-dd HH:mm:ss"));
			}
			Date nowDate = DateUtil.getCurrentTime();
			Date date = usrRegInfoPo.getLastLogpwdModifytime();
			// 判断用户是否需要提醒修改密码
			if (null != date) {
				int result = DateUtil.betweenDays(nowDate, date);
				if (result > 30) {
					cache.put("ifNoModPwd", Constants_user.IF_NO_MOD_PWD_YES);
				} else {
					cache.put("ifNoModPwd", Constants_user.IF_NO_MOD_PWD_NO);
				}
			} else {
				cache.put("ifNoModPwd", Constants_user.IF_NO_MOD_PWD_NO);
			}
		}
		return cache;
	}

	@Override
	public Map<String, Object> loginSuccSession(Map<String, Object> cache) {
		String userId = (String)cache.get("userId");
        String chnlId = (String)cache.get("chnlId");
        String sessionId = (String)cache.get("sessionId");
        logger.debug("userId[" + userId + "],chnlId[" + chnlId + "],sessionId[" + sessionId + "]");
        String singleLoginFlag = feignClient.getParmValue(CmparmConstants.SINGLE_LOGIN_FLAG);
        // 非多渠道登录，失效全部渠道session
        if (CmparmConstants.SINGLE_LOGIN_FLAG_YES.equals(singleLoginFlag)) {
        	/*cacheClient.delete(CacheConstants.SESSION_APP.concat(userId));
        	cacheClient.delete(CacheConstants.SESSION_WEB.concat(userId));*/
        }
        // 产生session
        if (Constants_gnr.CHNL_ID_APP.equals(chnlId) || Constants_gnr.CHNL_ID_ZHONHUIPAY.equals(chnlId)) {
            /*int sessionValidMinute =  Integer.valueOf(DipperParm.getParmByKey(CmparmConstants.SESSION_APP_INVALID_MINUTE).toString());
            logger.debug("cache key[" + CacheConstants.SESSION_APP.concat(userId) + "]  ");
            cacheClient.set(CacheConstants.SESSION_APP.concat(userId), sessionId, sessionValidMinute * 60);*/
        } else if (Constants_gnr.CHNL_ID_WEB.equals(chnlId)) {
           /* int sessionValidMinute = Integer.valueOf(DipperParm.getParmByKey(CmparmConstants.SESSION_WEB_INVALID_MINUTE).toString());
            logger.debug("cache key[" + CacheConstants.SESSION_WEB.concat(userId) + "]  ");
            cacheClient.set(CacheConstants.SESSION_WEB.concat(userId), sessionId, sessionValidMinute * 60);*/
        }
		return cache;
	}

	@Override
	public Map<String, Object> updateLoginTime(Map<String, Object> cache) throws Exception {
		String userId = (String)cache.get("userId");
        UsrRegInfoPo usrRegInfoPo = new UsrRegInfoPo();
        usrRegInfoPo.setLastLoginTime(DateUtil.getCurrentTime());
        usrRegInfoPo.setLastUpdateTime(new Date());
        UsrRegInfoPo usrRegInfoWherePo = new UsrRegInfoPo();
        usrRegInfoWherePo.setUserId(userId);
        usrRegInfoMapper.update(usrRegInfoPo, usrRegInfoWherePo);
		return cache;
	}

	@Override
	public Map<String, Object> loginFailProcessor(Map<String, Object> cache) throws Exception {
		 // SESSIONID
        String sessionId = (String)cache.get("sessionId");
        // 错误信息
        String rspMsg = (String)cache.get("rspMsg");

        // 更新用户登录日志信息表
        UsrLogListPo usrLogListPo = new UsrLogListPo();
        usrLogListPo.setLoginStat(Constants_user.LOGIN_STAT_FAIL);
        usrLogListPo.setFailReason(rspMsg);
        UsrLogListPo usrLogListWherePo = new UsrLogListPo();
        usrLogListWherePo.setSessionId(sessionId);
        if(StringUtils.isNotBlank(sessionId)){
        	usrLogListMapper.update(usrLogListPo, usrLogListWherePo);
        }
        // 判断是否达到需要输入图形验证码验证条件，记录需要验证图形验证码标注
        String verifyCodeFlag = "0";
        String cacheKey = (String)cache.get("verifykey");
        if (StringUtils.isBlank(cacheKey)) {
            String userId = (String)cache.get("userId");
            cacheKey = userId;
            if (StringUtils.isBlank(cacheKey)) {
                return cache;
            }
        }

        // 系统设置的登录密码错误次数
//        int loginVerifyTimes =  Integer.parseInt(feignClient.getParmValue(CmparmConstants.LOGIN_VERIFY_TIMES));

        // 此会话的当前登录密码错误次数
//        int loginPwdErrorTimes = 1;
        /*if (cacheClient.keyExists(CacheConstants.LOGIN_PWD_ERROR_TIMES.concat(cacheKey))) {
            loginPwdErrorTimes += (int) cacheClient.get(CacheConstants.LOGIN_PWD_ERROR_TIMES.concat(cacheKey));
        }
        cacheClient.set(CacheConstants.LOGIN_PWD_ERROR_TIMES.concat(cacheKey), loginPwdErrorTimes, 30 * 60);
        if (loginVerifyTimes <= loginPwdErrorTimes) {
            cacheClient.set(CacheConstants.VERIFY_CODE.concat(cacheKey), "true", 30 * 60);
            verifyCodeFlag = CommunicationConstants.VERIFY_CODE_FLAG_YES;
        }*/
        cache.put("verifyCodeFlag", verifyCodeFlag);
		return cache;
	}

	@Override
	public Map<String, Object> baseInfoQuery(Map<String, Object> cache) throws Exception {
		try {
			String userId = cache.get("userId").toString();
			UsrBaseInfoPo usrBaseInfoPo = new UsrBaseInfoPo();
			usrBaseInfoPo.setUserId(userId);
			usrBaseInfoPo = usrBaseInfoMapper.selectOne(usrBaseInfoPo);
			if (usrBaseInfoPo != null) {
				cache.put("certType", usrBaseInfoPo.getCertType());
				cache.put("certNo", usrBaseInfoPo.getCertNo());
				cache.put("certName", usrBaseInfoPo.getCertName());
				cache.put("certExpFlag", usrBaseInfoPo.getCertExpFlag());
				cache.put("certExpBegin", usrBaseInfoPo.getCertExpBegin());
				cache.put("certExpEnd", usrBaseInfoPo.getCertExpEnd());
				cache.put("sex", usrBaseInfoPo.getSex());
				cache.put("birthday", usrBaseInfoPo.getBirthday());
				cache.put("country", usrBaseInfoPo.getCountry());
				cache.put("nation", usrBaseInfoPo.getNation());
				cache.put("background", usrBaseInfoPo.getBackground());
				cache.put("religion", usrBaseInfoPo.getReligion());
				cache.put("marriage", usrBaseInfoPo.getMarriage());
				cache.put("eduBg", usrBaseInfoPo.getEduBg());
				cache.put("job", usrBaseInfoPo.getJob());
				cache.put("email", usrBaseInfoPo.getEmail());
				cache.put("qq", usrBaseInfoPo.getQq());
				cache.put("weixin", usrBaseInfoPo.getWeixin());
				cache.put("postCode", usrBaseInfoPo.getPostCode());
				cache.put("isFund", usrBaseInfoPo.getIsFund());
				cache.put("picHead", usrBaseInfoPo.getPicHead());
				cache.put("picCertFront", usrBaseInfoPo.getPicCertFront());
				cache.put("picCertBack", usrBaseInfoPo.getPicCertBack());
			}
		} catch (Exception e) {
			logger.error("查询用户基本信息表异常：{}", e);
			throw new RuntimeException("查询用户基本信息表异常");
		}
		return cache;
	}

}
