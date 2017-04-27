package com.ium.um.service.impl;

import java.util.List;


import com.ium.um.domain.formation.FormationData;
import com.ium.um.mapper.FormationDataMapper;
import com.ium.um.service.FormationDataService;


public class FormationDataServiceImpl implements FormationDataService{

	
	FormationDataMapper fdMapper;

	/**
	 * {@link com.ium.um.mapper.FormationDataMapper#findByID(String)}
	 */
	@Override
	public List<FormationData> findByID(String id) {
		
		//return fdMapper.findByID(id);
		return null;
	}

}
