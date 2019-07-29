package com.bpaas.bps.base.mapper;

import java.util.List;

import com.bpaas.bps.base.po.gnr.GnrParmPo;

public interface GnrParmMapper {

	int insert(GnrParmPo gnrParmPo);
	
	int update(GnrParmPo gnrParmPo);
	
	int updateByEntity(GnrParmPo gnrParmVal, GnrParmPo gnrParmCon);
	
	GnrParmPo selectOne(GnrParmPo gnrParmPo);
	
	List<GnrParmPo> selectList(GnrParmPo gnrParmPo);
	
}
