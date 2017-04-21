package com.ium.um.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.ium.um.domain.FormationData;
import com.ium.um.domain.FormationInfo;
import com.ium.um.mapper.FormationInfoMapper;
import com.ium.um.service.FormationInfoService;

@Service
@Transactional
//@CacheConfig(cacheNames = "UI_Cache")
public class FormationInfoServiceImpl implements FormationInfoService{
	
	@Autowired
	FormationInfoMapper fiMapper;
	
	/**
	 * {@link com.ium.um.mapper.FormationInfoMapper#findByID(String)}
	 */
	@Override
	public List<FormationInfo> findByID(String baseid) {
		
		return fiMapper.findByID(baseid);
	}

	/**
	 * {@link com.ium.um.mapper.FormationInfoMapper#findByIDLimit(String, int, int)}
	 */
	@Override
	public List<FormationInfo> findByIDLimit(String baseid, int limitNum, int offsetNum) {
		
		return fiMapper.findByIDLimit(baseid, limitNum, offsetNum);
	}

	/**
	 * {@link com.ium.um.mapper.FormationInfoMapper#add(Long, String, String)}
	 */
	@Override
	@CachePut(value = "UI_Cache", key = "#fd.getPosition()")
	public FormationData add(long baseid, FormationData fd, String instime) {
		
		String jsonStr = JSON.toJSONString(fd);
		fiMapper.add(baseid, jsonStr, instime);
		return fd;
	}

}
