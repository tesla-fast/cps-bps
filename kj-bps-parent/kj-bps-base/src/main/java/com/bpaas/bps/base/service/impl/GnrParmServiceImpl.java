package com.bpaas.bps.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bpaas.bps.base.mapper.GnrParmMapper;
import com.bpaas.bps.base.po.gnr.GnrParmPo;
import com.bpaas.bps.base.service.GnrParmService;

@Service("gnrParmService")
public class GnrParmServiceImpl implements GnrParmService {

	@Autowired
    private GnrParmMapper gnrParmMapper;
	 
	@Override
	public String getParmValue(String parmId) {
		GnrParmPo gnrParmPo = new GnrParmPo();
		gnrParmPo.setParmId(parmId);
		GnrParmPo selectOne = gnrParmMapper.selectOne(gnrParmPo);
		return selectOne.getParmValue();
	}
	
}
