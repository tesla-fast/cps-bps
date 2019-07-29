package com.bpaas.bps.acc.mapper;

import java.util.List;

import com.bpaas.bps.acc.po.AccEBookPo;

public interface AccEBookMapper {

	public int insert(AccEBookPo accEBookPo);
	
	public int updateByEntity(AccEBookPo accEBookVal, AccEBookPo accEBookCon);
	
	public AccEBookPo selectOne(AccEBookPo accEBookPo);
	
	public List<AccEBookPo> selectList(AccEBookPo accEBookPo);
	
}
