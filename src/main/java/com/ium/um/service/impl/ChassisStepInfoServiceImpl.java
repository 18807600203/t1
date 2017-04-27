package com.ium.um.service.impl;

import java.util.List;
import com.ium.um.core.beanUtil.JsonUtils;
import com.ium.um.domain.step.ChassisStepInfo;
import com.ium.um.mapper.ChassisStepInfoMapper;
import com.ium.um.service.ChassisStepInfoService;



public class ChassisStepInfoServiceImpl implements ChassisStepInfoService{

	
	ChassisStepInfoMapper csiMapper;
	
	/**
	 * {@link com.ium.um.mapper.ChassisStepInfoMapper#updateChassisStepInfo(String, String, boolean, String, String)}
	 */
	@Override
	public Object updateChassisStepInfo(ChassisStepInfo csi, boolean isSetNull, String timeSign, String genId) {
		
		String no = csi.getNo();
		String jsonStr = JsonUtils.toJson(csi);
		
		//return csiMapper.updateChassisStepInfo(no, jsonStr, isSetNull, timeSign, genId);
		return null;
	}

	
	/**
	 * {@link com.ium.um.mapper.ChassisStepInfoMapper#finChassisStepByNo(String)}
	 */
	@Override
	public String findChassisStepByNo(String no) {
		
		//return csiMapper.findChassisStepByNo(no);
		return null;
	}

	
	/**
	 * {@link com.ium.um.mapper.ChassisStepInfoMapper#findAllChassisStepWithNotNull()}
	 */
	@Override
	public List<String> findAllChassisStepWithNotNull() {
		
		//return csiMapper.findAllChassisStepWithNotNull();
		return null;
	}

}
