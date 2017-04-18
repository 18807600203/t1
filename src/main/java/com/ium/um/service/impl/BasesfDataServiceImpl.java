package com.ium.um.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ium.um.domain.BasesfData;
import com.ium.um.mapper.BasesfDataMapper;
import com.ium.um.service.IBasesfDataService;

@Service
@Transactional
public class BasesfDataServiceImpl implements IBasesfDataService{

	@Autowired
	BasesfDataMapper bdMapper;
	
	/**
	 * {@link com.ium.um.mapper.BasesfDataMapper#addBatch(List, String)}
	 */
	@Override
	public int addBatch(List<Long> idList, String genid) {
		
		return bdMapper.addBatch(idList, genid);
	}

	/**
	 * {@link com.ium.um.mapper.BasesfDataMapper#findById(Long)}
	 */
	@Override
	public BasesfData findById(Long id) {
		
		return bdMapper.findById(id);
	}

}
