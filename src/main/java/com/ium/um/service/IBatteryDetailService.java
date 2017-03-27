package com.ium.um.service;

import java.util.List;

import com.ium.um.domain.BatteryDetail;

public interface IBatteryDetailService {

	List<BatteryDetail> find(String itemStr, String valueStr, boolean isLimit);
}
