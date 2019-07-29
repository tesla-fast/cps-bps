package com.bpaas.bps.user.mapper;

import com.bpaas.bps.user.po.UMemberPo;

/**
 * @Author: haowen.wang
 * @Date: 2019/5/31
 * @Description:
 * @version: 1.0
 */
public interface UMemberMapper {

    int insert(UMemberPo uMemberPo);

    UMemberPo findMember (UMemberPo uMemberPo);
}
