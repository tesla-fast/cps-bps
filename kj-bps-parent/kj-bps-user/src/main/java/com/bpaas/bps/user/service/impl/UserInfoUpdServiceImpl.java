package com.bpaas.bps.user.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bpaas.bps.common.api.CommonResult;
import com.bpaas.bps.common.constants.Constants_user;
import com.bpaas.bps.common.utils.DateUtil;
import com.bpaas.bps.user.feign.BaseFeignClient;
import com.bpaas.bps.user.mapper.UsrBaseInfoMapper;
import com.bpaas.bps.user.mapper.UsrRegInfoMapper;
import com.bpaas.bps.user.po.UsrBaseInfoPo;
import com.bpaas.bps.user.po.UsrRegInfoPo;
import com.bpaas.bps.user.service.UserInfoUpdService;

@Service("userInfoUpdService")
public class UserInfoUpdServiceImpl implements UserInfoUpdService {
	private static final Logger logger = LoggerFactory.getLogger(UserInfoUpdServiceImpl.class);
	
	@Autowired
	private UsrBaseInfoMapper usrBaseInfoMapper;
	@Autowired
	private UsrRegInfoMapper usrRegInfoMapper;
	@Autowired
	private BaseFeignClient feignClient;
	
	@Override
	public CommonResult<Object> infoUpdate(Map<String, Object> reqData) {
		Map<String, Object> rspData = null;
		String userId = reqData.get("userId").toString();
		String updFlag = reqData.get("updFlag").toString();
		
		UsrRegInfoPo usrRegInfoPoCon = new UsrRegInfoPo();
		usrRegInfoPoCon.setUserId(userId);
		UsrRegInfoPo usrRegInfoPoVal = new UsrRegInfoPo();
		boolean flag = false;
		
		if (Constants_user.USER_UPD_FLAG_1.equals(updFlag)) {
			/**校验身份证号是否已经做过实名认证*/
			String certNo = (String)reqData.get("certNo");
			String mobile = (String)reqData.get("mobile");
			String userName = (String)reqData.get("userName");
			String userCertLevel = (String)reqData.get("userCertLevel");
			String userLockFlag = (String)reqData.get("userLockFlag");
			UsrBaseInfoPo usrBaseInfoPo = new UsrBaseInfoPo();
			usrBaseInfoPo.setCertNo(certNo);
			Integer count = usrBaseInfoMapper.count(usrBaseInfoPo);
			if (count > 0) {
				throw new RuntimeException("已实名认证通过");
			}
			usrRegInfoPoVal.setMobile(mobile);
			usrRegInfoPoVal.setUserName(userName);
			usrRegInfoPoVal.setUserCertLevel(userCertLevel);
			usrRegInfoPoVal.setUserLockFlag(userLockFlag);
			flag = true;
		} else {
			if (StringUtils.isNotBlank((String)reqData.get("userNickName"))) {
				usrRegInfoPoVal.setUserNickName((String)reqData.get("userNickName"));
				flag = true;
			}
			String imgFlag = (String)reqData.get("imgFlag");
			String imgHead = (String)reqData.get("imgHead");
			String imgType = (String)reqData.get("imgType");
			logger.debug("用户头像来源：imgFlag: {} ", imgFlag);
			if (Constants_user.USER_IMG_FLAG_0.equals(imgFlag)) {
				usrRegInfoPoVal.setHeadPic(imgHead);
				flag = true;
			} else if (Constants_user.USER_IMG_FLAG_1.equals(imgFlag)) {
				if (StringUtils.isNotBlank(imgHead) && StringUtils.isNotBlank(imgType)) {
					String param = feignClient.getParmValue("SET_CUSTOMS_HEADPIC");
					String[] parmValue = param.split("-");
					String fileName = userId.concat("-").concat(UUID.randomUUID().toString().replace("-", "")).concat(".").concat(imgType);
					saveHeadPic(imgHead, parmValue[1].concat(File.separator + fileName));
					usrRegInfoPoVal.setHeadPic(parmValue[0].concat(fileName));
					rspData = new HashMap<String, Object>();
					rspData.put("headPicPath", parmValue[0].concat(fileName));
					flag = true;
				}
			}
		}
		
		if (flag) {
			usrRegInfoMapper.update(usrRegInfoPoVal, usrRegInfoPoCon);
		}
		
		UsrBaseInfoPo usrBaseInfoPoCon = new UsrBaseInfoPo();
		usrBaseInfoPoCon.setUserId(userId);
		Integer count = usrBaseInfoMapper.count(usrBaseInfoPoCon);
		UsrBaseInfoPo usrBaseInfoPo = new UsrBaseInfoPo();
		if (0 == count) {
			usrBaseInfoPo.setUserId(userId);
			copyData(usrBaseInfoPo, reqData);
			usrBaseInfoMapper.insert(usrBaseInfoPo);
		} else {
			copyData(usrBaseInfoPo, reqData);
			usrBaseInfoMapper.update(usrBaseInfoPo, usrBaseInfoPoCon);
		}
		
		return CommonResult.success(JSONObject.parseObject(JSONObject.toJSONString(rspData)), "登录成功");
	}

	
	public void copyData(UsrBaseInfoPo usrBaseInfoPo, Map<String, Object> reqData) {
		usrBaseInfoPo.setCertType((String)reqData.get("certType"));
		usrBaseInfoPo.setCertNo((String)reqData.get("CertNo"));
		usrBaseInfoPo.setCertName((String)reqData.get("CertName"));
		usrBaseInfoPo.setCertExpFlag((String)reqData.get("CertExpFlag"));
		usrBaseInfoPo.setCertExpBegin(DateUtil.parse((String)reqData.get("CertExpBegin"), "yyyy-MM-dd"));
		usrBaseInfoPo.setCertExpEnd(DateUtil.parse((String)reqData.get("CertExpEnd"), "yyyy-MM-dd"));
		usrBaseInfoPo.setSex((String)reqData.get("Sex"));
		usrBaseInfoPo.setBirthday(DateUtil.parse((String)reqData.get("Birthday"), "yyyy-MM-dd"));
		usrBaseInfoPo.setCountry((String)reqData.get("Country"));
		usrBaseInfoPo.setNation((String)reqData.get("Nation"));
		usrBaseInfoPo.setBackground((String)reqData.get("Background"));
		usrBaseInfoPo.setReligion((String)reqData.get("Religion"));
		usrBaseInfoPo.setMarriage((String)reqData.get("Marriage"));
		usrBaseInfoPo.setEduBg((String)reqData.get("EduBg"));
		usrBaseInfoPo.setJob((String)reqData.get("Job"));
		usrBaseInfoPo.setEmail((String)reqData.get("Email"));
		usrBaseInfoPo.setQq((String)reqData.get("Qq"));
		usrBaseInfoPo.setWeixin((String)reqData.get("Weixin"));
		usrBaseInfoPo.setLastUpdateTime(DateUtil.getCurrentTime());
		usrBaseInfoPo.setPostCode((String)reqData.get("PostCode"));
		usrBaseInfoPo.setIsFund((String)reqData.get("IsFund"));
		usrBaseInfoPo.setPicHead((String)reqData.get("PicHead"));
		usrBaseInfoPo.setPicCertFront((String)reqData.get("PicCertFront"));
		usrBaseInfoPo.setPicCertBack((String)reqData.get("PicCertBack"));
	}
	
	
	/**
	 * 保存用户头像信息
	 * @param dto
	 * @param fileName
	 */
	public void saveHeadPic(String imgHead, String fileName) {
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try {
			fos = new FileOutputStream(new File(fileName));
			bos = new BufferedOutputStream(fos);
			bos.write(Base64.decodeBase64(imgHead));
			bos.flush();
		} catch (FileNotFoundException e) {
			logger.error("保存用户头像信息，发现未找到文件：{}", e);
		} catch (IOException e) {
			logger.error("保存用户头像信息失败：{}", e);
		} finally {
			try {
				if (null != bos) {
					bos.close();
				}
				if (null != fos) {
					fos.close();
				}
			} catch (IOException e) {
				logger.error("保存用户头像信息，关闭流失败：{}", e);
			}
		}
	}
	
}
