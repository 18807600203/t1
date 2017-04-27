package com.ium.um.service.impl;

import java.util.List;



import com.ium.um.domain.grading.ExpertGradingValues;
import com.ium.um.mapper.ExpertGradingValuesMapper;
import com.ium.um.service.ExpertGradingValuesService;


public class ExpertGradingValuesServiceImpl implements ExpertGradingValuesService{

	
	
	ExpertGradingValuesMapper egvMapper;

	/**
	 * {@link com.ium.um.domain.grading.ExpertGradingValues#findAll(String, String, String, String, String, String)}
	 */
	@Override
	public List<ExpertGradingValues> findAll(String chassises, String ustep, String maxcsteps, String minordifcsteps,
			String istep, String ufeatures) {
		
		//return egvMapper.findAll(chassises, ustep, maxcsteps, minordifcsteps, istep, ufeatures);
		return null;
	}


	


}
