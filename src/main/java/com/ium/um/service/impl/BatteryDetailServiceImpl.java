package com.ium.um.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ium.um.domain.battery.BatteryDetail;
import com.ium.um.mapper.BatteryDetailMapper;
import com.ium.um.service.BatteryDetailService;


@Transactional
public class BatteryDetailServiceImpl implements BatteryDetailService{

	
	BatteryDetailMapper bdMapper;
	
	/**
	 * {@link com.ium.um.mapper.BatteryDetailMapper#find(String, String, boolean)}
	 */
	@Override
	public List<BatteryDetail> find(String itemStr, String vauleStr, boolean isLimit) {
		
		return bdMapper.find(itemStr, vauleStr, isLimit);
	}

}
