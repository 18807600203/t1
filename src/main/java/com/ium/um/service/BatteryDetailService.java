package com.ium.um.service;

import java.util.List;

import com.ium.um.domain.BatteryDetail;

public interface BatteryDetailService {

	/**
	 * 查询电池的相关信息
	 * @param itemStr
	 * @param valueStr
	 * @param isLimit
	 * @return
	 */
	List<BatteryDetail> find(String itemStr, String valueStr, boolean isLimit);
}
