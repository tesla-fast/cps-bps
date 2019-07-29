package com.bpaas.bps.user.service;

import com.bpaas.bps.common.api.CommonResult;
import com.bpaas.bps.user.po.UMemberPo;

/**
 * @Author: haowen.wang
 * @Date: 2019/5/31
 * @Description:
 * @version: 1.0
 */
public interface UMemberService {

    public UMemberPo getMember (UMemberPo uMemberPo);

    public CommonResult registerMember (UMemberPo uMemberPo);
}
