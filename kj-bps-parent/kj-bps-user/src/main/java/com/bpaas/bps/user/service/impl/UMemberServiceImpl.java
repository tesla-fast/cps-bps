package com.bpaas.bps.user.service.impl;

import com.bpaas.bps.common.api.CommonResult;
import com.bpaas.bps.common.constants.Constants_user;
import com.bpaas.bps.user.feign.BaseFeignClient;
import com.bpaas.bps.user.mapper.UMemberMapper;
import com.bpaas.bps.user.po.UMemberPo;
import com.bpaas.bps.user.service.UMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author: haowen.wang
 * @Date: 2019/5/31
 * @Description:
 * @version: 1.0
 */
@Service("umemberService")
public class UMemberServiceImpl implements UMemberService {

    @Autowired
    private UMemberMapper uMemberMapper;

    @Autowired
    private BaseFeignClient feignClient;

    @Override
    public UMemberPo getMember(UMemberPo uMemberPo) {
        return uMemberMapper.findMember(uMemberPo);
    }

    @Override
    public CommonResult registerMember(UMemberPo uMemberPo) {
        /** 查询是否已有该用户 **/
        UMemberPo memberPo = getMember(uMemberPo);

        if (memberPo != null) {
            return CommonResult.failed("该用户已经存在");
        } else {
            /** 加密后的密码 **/
            String loginPwd = feignClient.decryPwd(uMemberPo.getLoginPwd());

            /** 声明式调用后生成的userId **/
            String userId = feignClient.generateUserId();

            uMemberPo.setUserId(userId);
            uMemberPo.setMemberLevelId(Long.parseLong(Constants_user.MEMBER_LEVEL_ID_NOMAL));
            uMemberPo.setUsername(uMemberPo.getUsername());
            uMemberPo.setLoginPwd(loginPwd);
            uMemberPo.setPhone(uMemberPo.getPhone());
            uMemberPo.setIdno(uMemberPo.getIdno());
            uMemberPo.setStatus(Integer.parseInt(Constants_user.MEMBER_STAT_NORMAL));
            uMemberPo.setCreateTime(new Date());
            uMemberPo.setRegChlId(uMemberPo.getRegChlId());
            uMemberPo.setSourceType(uMemberPo.getSourceType());
            uMemberPo.setIsrealnameauth(Short.parseShort(Constants_user.ISREALNAMEAUTH_NO));
            uMemberMapper.insert(uMemberPo);
            return CommonResult.success(null,"会员注册成功");
        }

    }
}
