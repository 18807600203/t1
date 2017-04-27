package com.ium.um.service.impl;

import java.util.List;


import com.ium.um.domain.sfile.BasesfData;
import com.ium.um.mapper.BasesfDataMapper;
import com.ium.um.service.BasesfDataService;



public class BasesfDataServiceImpl implements BasesfDataService{

	
	BasesfDataMapper bdMapper;
	
	/**
	 * {@link com.ium.um.mapper.BasesfDataMapper#addBatch(List, String)}
	 */
	@Override
	public int addBatch(List<Long> idList, String genid) {
		
		//return bdMapper.addBatch(idList, genid);
		return 0;
	}

	/**
	 * {@link com.ium.um.mapper.BasesfDataMapper#findById(Long)}
	 */
	@Override
	public BasesfData findById(Long id) {
		
		//TODO 如果查询的结果集中大于1行数据库的话, springbooi则报警
		//return bdMapper.findById(id);
		return null;
	}

}
