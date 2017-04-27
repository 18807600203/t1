package com.ium.um.service.impl;

import java.util.List;


import com.ium.um.core.beanUtil.JsonUtils;
import com.ium.um.domain.formation.FormationData;
import com.ium.um.domain.formation.FormationInfo;
import com.ium.um.mapper.FormationInfoMapper;
import com.ium.um.service.FormationInfoService;


//@CacheConfig(cacheNames = "UI_Cache")
public class FormationInfoServiceImpl implements FormationInfoService{
	
	
	FormationInfoMapper fiMapper;
	
	/**
	 * {@link com.ium.um.mapper.FormationInfoMapper#findByID(String)}
	 */
	@Override
	public List<FormationInfo> findByID(String baseid) {
		
		//return fiMapper.findByID(baseid);
		return null;
	}

	/**
	 * {@link com.ium.um.mapper.FormationInfoMapper#findByIDLimit(String, int, int)}
	 */
	@Override
	public List<FormationInfo> findByIDLimit(String baseid, int limitNum, int offsetNum) {
		
		//return fiMapper.findByIDLimit(baseid, limitNum, offsetNum);
		return null;
	}

	/**
	 * {@link com.ium.um.mapper.FormationInfoMapper#add(Long, String, String)}
	 */
	@Override
	//@CachePut(value = "UI_Cache", key = "#fd.getPosition()")
	public FormationData add(long baseid, FormationData fd, String instime) {
		
		//String jsonStr = JSON.toJSONString(fd);
		String jsonStr = JsonUtils.toJson(fd);
		//fiMapper.add(baseid, jsonStr, instime);
		return null;
		//return fd;
	}

}
