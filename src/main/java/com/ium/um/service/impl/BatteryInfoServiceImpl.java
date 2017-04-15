package com.ium.um.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ium.um.domain.BatteryInfo;
import com.ium.um.mapper.BatteryInfoMapper;
import com.ium.um.service.IBatteryInfoService;

@Service
@Transactional
public class BatteryInfoServiceImpl implements IBatteryInfoService{

	@Autowired
	BatteryInfoMapper biMapper;

	@Override
	public int insertBatch(List<BatteryInfo> biList) {
		
		return biMapper.insertBatch(biList);
	}



}
