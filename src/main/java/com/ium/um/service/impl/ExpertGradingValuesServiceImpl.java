package com.ium.um.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ium.um.domain.ExpertGradingValues;
import com.ium.um.mapper.ExpertGradingValuesMapper;
import com.ium.um.service.ExpertGradingValuesService;

@Service
@Transactional
public class ExpertGradingValuesServiceImpl implements ExpertGradingValuesService{

	
	@Autowired
	ExpertGradingValuesMapper egvMapper;

	/**
	 * {@link com.ium.um.mapper.ExpertGradingValues#findAll(String, String, String, String, String, String)}
	 */
	@Override
	public List<ExpertGradingValues> findAll(String chassises, String ustep, String maxcsteps, String minordifcsteps,
			String istep, String ufeatures) {
		
		return egvMapper.findAll(chassises, ustep, maxcsteps, minordifcsteps, istep, ufeatures);
	}


	


}
