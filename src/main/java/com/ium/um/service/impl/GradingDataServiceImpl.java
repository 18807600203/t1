package com.ium.um.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ium.um.mapper.GradingDataMapper;
import com.ium.um.service.GradingDataService;

@Service
@Transactional
public class GradingDataServiceImpl implements GradingDataService{

	@Autowired
	GradingDataMapper gdMapper;
	
	
	/**
	 * {@link com.ium.um.mapper.GradingDataMapper#doGrading(String, String)}
	 */
	@Override
	public void doGrading(String chassisNos, String steps) {
		
		gdMapper.doGrading(chassisNos, steps);
	}

	
}
