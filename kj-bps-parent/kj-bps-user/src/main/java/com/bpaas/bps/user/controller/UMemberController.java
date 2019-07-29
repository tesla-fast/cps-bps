package com.bpaas.bps.user.controller;

import com.bpaas.bps.common.api.CommonResult;
import com.bpaas.bps.user.po.UMemberPo;
import com.bpaas.bps.user.service.UMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: haowen.wang
 * @Date: 2019/5/31
 * @Description:
 * @version: 1.0
 */
@RestController
@Api("测试集成Swagger")
public class UMemberController {

    private Logger logger = LoggerFactory.getLogger(UMemberController.class);

    @Autowired
    private UMemberService uMemberService;

    /**
     * 功能描述: 会员注册
     * @param:
     * @return:
     * @author:
     * @date:
     */
    @ApiOperation(value = "会员注册", notes = "会员注册")
    @ApiImplicitParam(name = "UMemberPo", value = "会员注册po", required = true, dataType = "UMemberPo")
    @RequestMapping(value = "/registerMember", method = RequestMethod.POST)
    public CommonResult registerMember(@RequestBody UMemberPo uMemberPo) {
            String phone = uMemberPo.getPhone();
            String reg_chi_id = uMemberPo.getRegChlId();

            if (StringUtils.isBlank(phone)) {
                return CommonResult.failed("手机号不能为空");
            }
            if (StringUtils.isBlank(reg_chi_id)) {
                return CommonResult.failed("渠道号不能为空");
            }
            return uMemberService.registerMember(uMemberPo);
//        /** 查询是否已有该用户 **/
//        UMemberPo memberPo = uMemberService.getMember(uMemberPo);
//        if (memberPo != null) {
//            return CommonResult.failed("该用户已经存在");
//        } else {
//            /** 加密后的密码 **/
//            loginPwd = feignClient.decryPwd(loginPwd);
//
//            /** 声明式调用后生成的userId **/
//            String userId = feignClient.generateUserId();
//
//            uMemberPo.setUserId(userId);
//            uMemberPo.setMemberLevelId(Long.parseLong(Constants_user.MEMBER_LEVEL_ID_NOMAL));
//            uMemberPo.setUsername(uMemberPo.getUsername());
//            uMemberPo.setLoginPwd(loginPwd);
//            uMemberPo.setPhone(uMemberPo.getPhone());
//            uMemberPo.setIdno(uMemberPo.getIdno());
//            uMemberPo.setStatus(Integer.parseInt(Constants_user.MEMBER_STAT_NORMAL));
//            uMemberPo.setCreateTime(new Date());
//            uMemberPo.setRegChlId(reg_chi_id);
//            uMemberPo.setSourceType(uMemberPo.getSourceType());
//            uMemberPo.setIsrealnameauth(Short.parseShort(Constants_user.ISREALNAMEAUTH_NO));
//
//            uMemberService.registerMember(uMemberPo);
//            return CommonResult.success(null,"会员注册成功");
//        }
    }
}
