package com.ium.um.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ium.um.domain.FormationData;
import com.ium.um.mapper.FormationDataMapper;
import com.ium.um.service.IFormationDataService;

@Service
@Transactional
public class FormationDataServiceImpl implements IFormationDataService{

	@Autowired
	FormationDataMapper fdMapper;

	/**
	 * {@link com.ium.um.mapper.FormationDataMapper#findByID(String)}
	 */
	@Override
	public List<FormationData> findByID(String id) {
		
		return fdMapper.findByID(id);
	}

}
