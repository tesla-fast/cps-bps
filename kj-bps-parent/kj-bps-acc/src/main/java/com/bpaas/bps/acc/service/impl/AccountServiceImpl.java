package com.bpaas.bps.acc.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bpaas.bps.acc.feign.BaseFeignClient;
import com.bpaas.bps.acc.mapper.AccEBookMapper;
import com.bpaas.bps.acc.mapper.PotBookMapper;
import com.bpaas.bps.acc.po.AccEBookPo;
import com.bpaas.bps.acc.po.PotBookPo;
import com.bpaas.bps.acc.service.AccountService;
import com.bpaas.bps.common.constants.Constants_acc;
import com.bpaas.bps.common.constants.Constants_pot;
import com.bpaas.bps.common.utils.DateUtil;
import com.bpaas.bps.common.utils.InitData;
import com.bpaas.bps.common.utils.UUIDGenerator;

@Service("accountService")
public class AccountServiceImpl implements AccountService<Map<String, Object>> {
	private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
	
	@Autowired
	private AccEBookMapper accEBookMapper;
	@Autowired
	private PotBookMapper potBookMapper;
	@Autowired
	private BaseFeignClient baseFeignClient;

	@Override
	public Map<String, Object> regOneAccount(Map<String, Object> cache) throws Exception {
		try {
			AccEBookPo accEBookPo = new AccEBookPo();
			accEBookPo.setId(UUIDGenerator.randomUUID());
			accEBookPo.setUserId((String) cache.get("userId"));
			accEBookPo.seteCardNo((String) cache.get("mobile"));
			accEBookPo.seteAcctOrg("61000000");
			accEBookPo.seteAcctStat(Constants_acc.E_ACCT_STAT_0);
			accEBookPo.setFrzStat(Constants_acc.FRZ_STAT_0);
			accEBookPo.seteAcctCertLevel(Constants_acc.E_ACCT_CERT_LEVEL_01);
			accEBookPo.setCreateTime(DateUtil.getCurrentTime());
			int num = accEBookMapper.insert(accEBookPo);
			if (num != 1) {
				logger.error("创建一账通账户信息失败，mobile: {}", cache.get("mobile"));
				throw new RuntimeException("创建一账通账户信息失败");
			} else {
				cache.put("eCardNo", accEBookPo.geteCardNo());
			}
		} catch (RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		} catch (Exception e) {
			logger.error("创建一账通账户信息异常：{}", e);
			throw new RuntimeException("创建一账通账户信息异常");
		}
		return cache;
	}

	@Override
	public Map<String, Object> updOneAccount(Map<String, Object> cache) throws Exception {
		InitData.success(cache);
		try {
			if (Constants_acc.USER_CERT_LEVEL_02.equals((String) cache.get("acctCertLevel"))) {
				AccEBookPo accEBookPoVal = new AccEBookPo();
				accEBookPoVal.seteAcctCertLevel(Constants_acc.USER_CERT_LEVEL_02);
				AccEBookPo accEBookPoCon = new AccEBookPo();
				accEBookPoCon.setUserId((String) cache.get("userId"));
				accEBookPoCon.seteCardNo((String) cache.get("eCardNo"));
				int num = accEBookMapper.updateByEntity(accEBookPoVal, accEBookPoCon);
				if (num != 1) {
					logger.error("更新一账通账户信息失败，userId: {}", cache.get("userId"));
					throw new RuntimeException("更新一账通账户信息失败");
				}
			} else {
				throw new RuntimeException("调用方上送用户认证级别非法");
			}
		} catch (RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		} catch (Exception e) {
			logger.error("更新一账通账户信息异常：{}", e);
			throw new RuntimeException("更新一账通账户信息异常");
		}
		return cache;
	}

	@Override
	public Map<String, Object> integralAcctOpen(Map<String, Object> cache) throws Exception {
		String userId = (String) cache.get("userId"); 	// 获取userID
		String cardNo = (String) cache.get("eCardNo"); 	// 设置一账通账号
		Date newDate = DateUtil.getCurrentTime(); 		// 获取系统时间
		try {
			PotBookPo potBookPo = new PotBookPo();
			potBookPo.setUserId(userId);
			potBookPo.setPotAcctType(Constants_pot.ACCT_TYPE_NORMAL);
			List<PotBookPo> lista = potBookMapper.selectList(potBookPo);			// 通用积分账户检查
			if (null == lista || lista.size() == 0) {
				potBookPo.setId(UUIDGenerator.randomUUID());
				potBookPo.setPotAcctStat(Constants_pot.ACCT_STAT_NORMAL); 			// 正常
				potBookPo.setOpenDate(newDate); 									// 开户时间
				potBookPo.setDatelastmaint(newDate);
				potBookPo.setPotAcctType(Constants_pot.ACCT_TYPE_NORMAL); 			// 0：通用积分账户
				potBookPo.setPotAcctName(Constants_pot.ACCT_TYPE_NORMAL_DESC);
				potBookPo.setPotAcctNo(baseFeignClient.generatePotAcctMainNo()); 	// 通用积分账号
				potBookPo.setPotAcctBal(BigDecimal.ZERO); 							// 积分余额 设置默认0
				potBookPo.seteCardNo(cardNo); 										// 设置一账通账号
				int a = potBookMapper.insert(potBookPo);
				if (a != 1) {
					throw new RuntimeException("创建通用积分账户失败");
				}
			}
		} catch (RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		} catch (Exception e) {
			logger.error("创建通用积分账户异常：{}", e);
			throw new RuntimeException("创建通用积分账户异常");
		}

		try {
			PotBookPo potBookPo1 = new PotBookPo();
			potBookPo1.setUserId(userId);
			potBookPo1.setPotAcctType(Constants_pot.ACCT_TYPE_GROW);
			List<PotBookPo> listb = potBookMapper.selectList(potBookPo1);			// 成长积分账户检查
			if (null == listb || listb.size() == 0) {
				potBookPo1.setId(UUIDGenerator.randomUUID());
				potBookPo1.setPotAcctStat(Constants_pot.ACCT_STAT_NORMAL); 			// 正常
				potBookPo1.setOpenDate(newDate); 									// 开户时间
				potBookPo1.setDatelastmaint(newDate);
				potBookPo1.setPotAcctType(Constants_pot.ACCT_TYPE_GROW); 			// 0：成长积分账户
				potBookPo1.setPotAcctName(Constants_pot.ACCT_TYPE_GROW_DESC);
				potBookPo1.setPotAcctNo(baseFeignClient.generatePotAcctGrowNo()); 	// 成长积分账户
				potBookPo1.setPotAcctBal(BigDecimal.ZERO); 							// 积分余额 设置默认0
				potBookPo1.seteCardNo(cardNo); 										// 设置一账通账号
				int a = potBookMapper.insert(potBookPo1);
				if (a != 1) {
					throw new RuntimeException("创建成长积分账户失败");
				}
			}
		} catch (RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		} catch (Exception e) {
			logger.error("创建成长积分账户异常：{}", e);
			throw new RuntimeException("创建成长积分账户异常");
		}
		return cache;
	}

}
