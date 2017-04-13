package com.ium.um.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ium.um.domain.FormationInfo;
import com.ium.um.mapper.FormationInfoMapper;
import com.ium.um.service.IFormationInfoService;

@Service
@Transactional
public class FormationInfoServiceImpl implements IFormationInfoService{

	@Autowired
	FormationInfoMapper fiMapper;
	
	@Override
	public List<FormationInfo> findByID(String baseid) {
		
		return fiMapper.findByID(baseid);
	}

	@Override
	public List<FormationInfo> findByIDLimit(String baseid, int limitNum, int offsetNum) {
		
		return fiMapper.findByIDLimit(baseid, limitNum, offsetNum);
	}

	@Override
	public Object add(long baseid, String jsonStr, String instime) {
		
		return fiMapper.add(baseid, jsonStr, instime);
	}

}
