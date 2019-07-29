package com.bpaas.bps.base.controller;

import com.bpaas.bps.base.service.GnrParmService;
import com.bpaas.bps.base.service.SequenceService;
import com.bpaas.bps.common.utils.SecurityPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: haowen.wang
 * @Date: 2019/5/21
 * @Description:
 * @version: 1.0
 */
@RestController
public class BaseController {

    @Autowired
    private SequenceService sequenceService;
    
    @Autowired
    private GnrParmService gnrParmService;

    /**
     * 功能描述: 生成UserId
     * @param:
     * @return:
     * @auther: haowen.wang
     * @date:
     */
    @RequestMapping(value = "/generateUserId", method = RequestMethod.POST)
    public String generateUserId() {
        String userId = sequenceService.generateUserId();
        return  userId;
    }

    /**
     * 功能描述: 密码加密
     * @param:
     * @return:
     * @auther: haowen.wang
     * @date:
     */
    @RequestMapping(value = "/decryPwd", method = RequestMethod.POST)
    public String decryPwd(@RequestBody String pwd) {
        String password = SecurityPassword.decryPassword(pwd);
        return  password;
    }
    
    /**
     * 功能描述: 获取参数值
     * @param:
     * @return:
     * @auther: Jason
     * @date:
     */
    @RequestMapping(value = "/getParmValue", method = RequestMethod.POST)
    public String getParmValue(@RequestBody String parmId) {
        return gnrParmService.getParmValue(parmId);
    }
    
    /**
     * 功能描述: 生成通用积分账号
     * @param:
     * @return:
     * @auther: Jason
     * @date:
     */
    @RequestMapping(value = "/generatePotAcctMainNo", method = RequestMethod.POST)
    public String generatePotAcctMainNo() {
        return sequenceService.generatePotAcctMainNo();
    }
    
    /**
     * 功能描述: 生成成长积分账号
     * @param:
     * @return:
     * @auther: Jason
     * @date:
     */
    @RequestMapping(value = "/generatePotAcctGrowNo", method = RequestMethod.POST)
    public String generatePotAcctGrowNo() {
        return sequenceService.generatePotAcctGrowNo();
    }
}
