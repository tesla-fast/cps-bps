package com.bpaas.bps.acc.mapper;

import java.util.List;

import com.bpaas.bps.acc.po.PotBookPo;

public interface PotBookMapper {
	
	public int insert(PotBookPo potBookPo);
	
	public int update(PotBookPo potBookVal, PotBookPo potBookCon);
	
	public int delete(PotBookPo potBookPo);
	
	public PotBookPo selectOne(PotBookPo potBookPo);
	
	public List<PotBookPo> selectList(PotBookPo potBookPo);

}
