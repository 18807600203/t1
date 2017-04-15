package com.ium.um.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ium.um.domain.BatteryInfo;

public interface IBatteryInfoService {
		
	//boolean insert(String chassis, String channel, String module);
	
	/**
	 * 批量添加电池信息
	 * @param biList
	 * @return
	 */
	int insertBatch(@Param("biList") List<BatteryInfo> biList);
}

