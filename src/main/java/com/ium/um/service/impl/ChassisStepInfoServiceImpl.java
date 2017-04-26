package com.ium.um.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ium.um.core.beanUtil.JsonUtils;
import com.ium.um.domain.step.ChassisStepInfo;
import com.ium.um.mapper.ChassisStepInfoMapper;
import com.ium.um.service.ChassisStepInfoService;


@Transactional
public class ChassisStepInfoServiceImpl implements ChassisStepInfoService{

	
	ChassisStepInfoMapper csiMapper;
	
	/**
	 * {@link com.ium.um.mapper.ChassisStepInfoMapper#updateChassisStepInfo(String, String, boolean, String, String)}
	 */
	@Override
	public Object updateChassisStepInfo(ChassisStepInfo csi, boolean isSetNull, String timeSign, String genId) {
		
		String no = csi.getNo();
		String jsonStr = JsonUtils.toJsonString(csi);
		
		return csiMapper.updateChassisStepInfo(no, jsonStr, isSetNull, timeSign, genId);
	}

	
	/**
	 * {@link com.ium.um.mapper.ChassisStepInfoMapper#finChassisStepByNo(String)}
	 */
	@Override
	public String findChassisStepByNo(String no) {
		
		return csiMapper.findChassisStepByNo(no);
	}

	
	/**
	 * {@link com.ium.um.mapper.ChassisStepInfoMapper#findAllChassisStepWithNotNull()}
	 */
	@Override
	public List<String> findAllChassisStepWithNotNull() {
		
		return csiMapper.findAllChassisStepWithNotNull();
	}

}
