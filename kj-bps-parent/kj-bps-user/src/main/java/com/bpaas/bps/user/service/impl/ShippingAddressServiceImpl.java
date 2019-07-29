package com.bpaas.bps.user.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bpaas.bps.common.api.CommonResult;
import com.bpaas.bps.user.mapper.UsrShippingAddressMapper;
import com.bpaas.bps.user.po.UsrShippingAddressPo;
import com.bpaas.bps.user.service.ShippingAddressService;

@Service("shippingAddressService")
public class ShippingAddressServiceImpl implements ShippingAddressService {
	private static final Logger logger = LoggerFactory.getLogger(ShippingAddressServiceImpl.class);

	@Autowired
	private UsrShippingAddressMapper usrShippingAddressMapper;

	@Override
	public CommonResult<JSONObject> addAddress(Map<String, Object> reqData) {
		try {
			String userId = reqData.get("userId").toString();
			String shippingUserName = (String) reqData.get("shippingUserName");
			String contactMobile = (String) reqData.get("contactMobile");
			String address = (String) reqData.get("address");
			String city = (String) reqData.get("city");
			String state = (String) reqData.get("state");
			String zipcode = (String) reqData.get("zipCode");
			String country = (String) reqData.get("country");
			String defaultFlag = (String) reqData.get("defaultFlag");

			/* 查询用户是否存在默认地址,存在则更新成非默认 */
			UsrShippingAddressPo uShippingAddressTempPo = new UsrShippingAddressPo();
			uShippingAddressTempPo.setUserId(userId);
			List<UsrShippingAddressPo> list = usrShippingAddressMapper.selectList(uShippingAddressTempPo);

			if (list != null && list.size() > 0) {
				for (UsrShippingAddressPo usAddressPo : list) {
					String defaultFlagTemp = usAddressPo.getDefaultFlag();
					if ("1".equals(defaultFlagTemp) && "1".equals(defaultFlag)) {
						int id = usAddressPo.getShippingAddressId();
						UsrShippingAddressPo uShippingAddressPo2 = new UsrShippingAddressPo();
						uShippingAddressPo2.setUserId(userId);
						uShippingAddressPo2.setShippingUserName(usAddressPo.getShippingUserName());
						uShippingAddressPo2.setContactMobile(usAddressPo.getContactMobile());
						uShippingAddressPo2.setAddress(usAddressPo.getAddress());
						uShippingAddressPo2.setCity(usAddressPo.getCity());
						uShippingAddressPo2.setState(usAddressPo.getState());
						uShippingAddressPo2.setZipcode(usAddressPo.getZipcode());
						uShippingAddressPo2.setCountry(usAddressPo.getCountry());
						uShippingAddressPo2.setDefaultFlag("0");
						uShippingAddressPo2.setShippingAddressId(id);
						usrShippingAddressMapper.update(uShippingAddressPo2);
					}
				}
			}
			UsrShippingAddressPo uShippingAddressPo = new UsrShippingAddressPo();
			uShippingAddressPo.setUserId(userId);
			uShippingAddressPo.setShippingUserName(shippingUserName);
			uShippingAddressPo.setContactMobile(contactMobile);
			uShippingAddressPo.setAddress(address);
			uShippingAddressPo.setCity(city);
			uShippingAddressPo.setState(state);
			uShippingAddressPo.setZipcode(zipcode);
			uShippingAddressPo.setCountry(country);
			uShippingAddressPo.setDefaultFlag(defaultFlag);
			usrShippingAddressMapper.insert(uShippingAddressPo);
		} catch (Exception e) {
			logger.debug("收货地址添加失败: {}", e);
			return CommonResult.failed("收货地址添加失败");
		}
		return CommonResult.success(null, "收货地址添加成功");
	}

	@Override
	public CommonResult<JSONObject> queryAddressByUser(Map<String, Object> reqData) {
		List<UsrShippingAddressPo> dtoList = new ArrayList<UsrShippingAddressPo>();

		String userId = reqData.get("userId").toString();
		String defaultFlag = (String) reqData.get("defaultFlag");

		UsrShippingAddressPo uShippingAddressPo = new UsrShippingAddressPo();
		uShippingAddressPo.setUserId(userId);
		uShippingAddressPo.setDefaultFlag(defaultFlag);
		List<UsrShippingAddressPo> uShippingAddressList = usrShippingAddressMapper.selectList(uShippingAddressPo);
		if (uShippingAddressList != null && uShippingAddressList.size() > 0) {
			UsrShippingAddressPo addressVo = null;
			if ("1".equals(defaultFlag)) {
				UsrShippingAddressPo usrShippingAddressPo = uShippingAddressList.get(0);
				addressVo = new UsrShippingAddressPo();
				addressVo.setShippingAddressId(usrShippingAddressPo.getShippingAddressId());
				addressVo.setUserId(userId);
				addressVo.setShippingUserName(usrShippingAddressPo.getShippingUserName());
				addressVo.setContactMobile(usrShippingAddressPo.getContactMobile());
				addressVo.setCountry(usrShippingAddressPo.getCountry());
				addressVo.setCity(usrShippingAddressPo.getCity());
				addressVo.setState(usrShippingAddressPo.getState());
				addressVo.setAddress(usrShippingAddressPo.getAddress());
				addressVo.setZipcode(usrShippingAddressPo.getZipcode());
				addressVo.setDefaultFlag(usrShippingAddressPo.getDefaultFlag());
				dtoList.add(addressVo);
			} else {
				for (UsrShippingAddressPo usrShippingAddressPo : uShippingAddressList) {
					addressVo = new UsrShippingAddressPo();
					addressVo.setShippingAddressId(usrShippingAddressPo.getShippingAddressId());
					addressVo.setUserId(userId);
					addressVo.setShippingUserName(usrShippingAddressPo.getShippingUserName());
					addressVo.setContactMobile(usrShippingAddressPo.getContactMobile());
					addressVo.setCountry(usrShippingAddressPo.getCountry());
					addressVo.setCity(usrShippingAddressPo.getCity());
					addressVo.setState(usrShippingAddressPo.getState());
					addressVo.setAddress(usrShippingAddressPo.getAddress());
					addressVo.setZipcode(usrShippingAddressPo.getZipcode());
					addressVo.setDefaultFlag(usrShippingAddressPo.getDefaultFlag());
					dtoList.add(addressVo);
				}
			}
		} else {
			if ("1".equals(defaultFlag)) {
				UsrShippingAddressPo uShippingAddressPo2 = new UsrShippingAddressPo();
				uShippingAddressPo2.setUserId(userId);
				List<UsrShippingAddressPo> uShippingAddressList2 = usrShippingAddressMapper
						.selectList(uShippingAddressPo2);
				if (uShippingAddressList2 != null && uShippingAddressList2.size() > 0) {
					UsrShippingAddressPo usrShippingAddressPo = uShippingAddressList2.get(0);
					UsrShippingAddressPo addressVo = new UsrShippingAddressPo();
					addressVo.setShippingAddressId(usrShippingAddressPo.getShippingAddressId());
					addressVo.setUserId(userId);
					addressVo.setShippingUserName(usrShippingAddressPo.getShippingUserName());
					addressVo.setContactMobile(usrShippingAddressPo.getContactMobile());
					addressVo.setCountry(usrShippingAddressPo.getCountry());
					addressVo.setCity(usrShippingAddressPo.getCity());
					addressVo.setState(usrShippingAddressPo.getState());
					addressVo.setAddress(usrShippingAddressPo.getAddress());
					addressVo.setZipcode(usrShippingAddressPo.getZipcode());
					addressVo.setDefaultFlag(usrShippingAddressPo.getDefaultFlag());
					dtoList.add(addressVo);
				}
			}
		}
		CommonResult<JSONObject> commonResult = null;
		if (dtoList.size() > 0) {
			commonResult = CommonResult.success(JSONObject.parseObject(JSONObject.toJSONString(dtoList)), "查询成功");
		} else {
			commonResult = CommonResult.failed("查询失败：未查到收货地址");
		}
		return commonResult;
	}

	@Override
	public CommonResult<JSONObject> updateAddress(Map<String, Object> reqData) {
		String userId = reqData.get("userId").toString();
		String shippingUserName = (String) reqData.get("shippingUserName");
		String contactMobile = (String) reqData.get("contactMobile");
		String address = (String) reqData.get("address");
		String city = (String) reqData.get("city");
		String state = (String) reqData.get("state");
		String zipcode = (String) reqData.get("zipCode");
		String country = (String) reqData.get("country");
		String defaultFlag = (String) reqData.get("defaultFlag");
		int shippingAddressId = Integer.parseInt((String) reqData.get("ShippingAddressId"));

		/** 查询出已存在默认地址的记录 **/
		UsrShippingAddressPo uShippingAddressPo2 = new UsrShippingAddressPo();
		uShippingAddressPo2.setUserId(userId);
		uShippingAddressPo2.setDefaultFlag("1");
		uShippingAddressPo2 = usrShippingAddressMapper.selectOne(uShippingAddressPo2);

		UsrShippingAddressPo uShippingAddressPo = new UsrShippingAddressPo();
		uShippingAddressPo.setShippingAddressId(shippingAddressId);
		uShippingAddressPo.setUserId(userId);
		uShippingAddressPo.setShippingUserName(shippingUserName);
		uShippingAddressPo.setContactMobile(contactMobile);
		uShippingAddressPo.setCountry(country);
		uShippingAddressPo.setCity(city);
		uShippingAddressPo.setState(state);
		uShippingAddressPo.setAddress(address);
		uShippingAddressPo.setZipcode(zipcode);
		uShippingAddressPo.setDefaultFlag(defaultFlag);
		/**
		 * 如果地址默认记录为空,说明用户没有默认地址,则根据前端送的值直接更新地址信息;
		 * 否则将查询出默认地址的id和前端送的id比较,如果二者一致,说明修改的即是默认地址,则根据前端送的值直接更新地址信息;
		 * 如果不一致,说明修改的不是默认地址,则判断前端送的地址默认标志,如果为0,则原默认地址信息不变,根据前端送的值直接更新地址信息;如果为1,则先根据前端送的值直接更新信息,并且将原来查出的默认地址记录更新成非默认
		 **/
		if (uShippingAddressPo2 == null) {
			usrShippingAddressMapper.update(uShippingAddressPo);
		} else {
			int id = uShippingAddressPo2.getShippingAddressId();
			if (id == shippingAddressId) {
				usrShippingAddressMapper.update(uShippingAddressPo);
			} else {
				if ("0".equals(defaultFlag)) {
					usrShippingAddressMapper.update(uShippingAddressPo);
				} else {
					usrShippingAddressMapper.update(uShippingAddressPo);
					uShippingAddressPo2.setDefaultFlag("0");
					usrShippingAddressMapper.update(uShippingAddressPo2);
				}
			}
		}
		return null;
	}

	@Override
	public CommonResult<JSONObject> deleteAddress(Map<String, Object> reqData) {
		int shippingAddressId = Integer.parseInt((String) reqData.get("ShippingAddressId"));
		UsrShippingAddressPo uShippingAddressPo = new UsrShippingAddressPo();
		uShippingAddressPo.setShippingAddressId(shippingAddressId);
		int delete = usrShippingAddressMapper.delete(uShippingAddressPo);
		CommonResult<JSONObject> commonResult = null;
		if (delete == 1) {
			commonResult = CommonResult.success(null, "收货地址修改成功");
		} else {
			commonResult = CommonResult.failed("收货地址修改失败");
		}
		return commonResult;
	}

	@Override
	public CommonResult<JSONObject> queryAddressById(Map<String, Object> reqData) {
		CommonResult<JSONObject> commonResult = null;
		int shippingAddressId = Integer.parseInt((String) reqData.get("ShippingAddressId"));
		UsrShippingAddressPo uShippingAddressPo = new UsrShippingAddressPo();
		uShippingAddressPo.setShippingAddressId(shippingAddressId);
		uShippingAddressPo = usrShippingAddressMapper.selectOne(uShippingAddressPo);
		if (null != uShippingAddressPo) {
			UsrShippingAddressPo addressVo = new UsrShippingAddressPo();
			addressVo.setShippingAddressId(uShippingAddressPo.getShippingAddressId());
			addressVo.setUserId(uShippingAddressPo.getUserId());
			addressVo.setShippingUserName(uShippingAddressPo.getShippingUserName());
			addressVo.setContactMobile(uShippingAddressPo.getContactMobile());
			addressVo.setCountry(uShippingAddressPo.getCountry());
			addressVo.setCity(uShippingAddressPo.getCity());
			addressVo.setState(uShippingAddressPo.getState());
			addressVo.setAddress(uShippingAddressPo.getAddress());
			addressVo.setZipcode(uShippingAddressPo.getZipcode());
			addressVo.setDefaultFlag(uShippingAddressPo.getDefaultFlag());
			commonResult = CommonResult.success(JSONObject.parseObject(JSONObject.toJSONString(addressVo)), "查询成功");
		} else {
			commonResult = CommonResult.failed("查询失败：未查到收货地址");
		}
		return commonResult;
	}

}
