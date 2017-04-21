package com.ium.um.service;

import java.util.List;

import com.ium.um.domain.ExpertGradingValues;

public interface ExpertGradingValuesService {

	/**
	 * 高级分选的入口
	 * @param chassises 机框s
	 * @param ustep 电压分选工步
	 * @param maxcsteps 终止容量分选工步s
	 * @param minordifcsteps 最小容量或容量差分选工步
	 * @param istep 电流分选工步
	 * @param ufeatures 特征电压值
	 * @return
	 */
	List<ExpertGradingValues> findAll(String chassises, String ustep, String maxcsteps, String minordifcsteps,
			String istep, String ufeatures);
}
