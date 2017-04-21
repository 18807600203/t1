package com.ium.um.service;


public interface GradingDataService {

	/**
	 * 分容算法
	 * @param chassisNos
	 * @param steps
	 */
	void doGrading(String chassisNos, String steps);
}
