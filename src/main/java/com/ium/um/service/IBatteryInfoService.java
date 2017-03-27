package com.ium.um.service;

import java.util.List;
import com.ium.um.domain.BatteryInfo;

public interface IBatteryInfoService {

	BatteryInfo findById(Long id);
	
	BatteryInfo findByNo(String no);
		
	List<BatteryInfo> getAll();
	
	boolean insert(String chassis, String channel, String module);
}
