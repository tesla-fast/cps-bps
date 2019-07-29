package com.bpaas.bps.acc.mapper;

import java.util.List;

import com.bpaas.bps.acc.po.AccElistPo;

public interface AccElistMapper {

	public int insert(AccElistPo accElistPo);
	
	public int update(AccElistPo accElistVal, AccElistPo accElistCon);
	
	public AccElistPo selectOne(AccElistPo accElistPo);
	
	public List<AccElistPo> selectList(AccElistPo accElistPo);
	
}
