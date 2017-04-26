package com.ium.um.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ium.um.domain.grading.GradingData;
import com.ium.um.mapper.GradingDataMapper;
import com.ium.um.service.GradingDataService;


@Transactional
public class GradingDataServiceImpl implements GradingDataService{

	
	GradingDataMapper gdMapper;
		
	/**
	 * {@link com.ium.um.mapper.GradingDataMapper#doGrading(String, String)}
	 * 数据库中是无返回值的,但mybatis要求有返回值,所以返在本层中返回0
	 */
	@Override
	public Object doGrading(String chassisNos, String steps) {
		
		 gdMapper.doGrading(chassisNos, steps);
		 return 0;
	}

	/**
	 * {@link com.ium.um.mapper.GradingDataMapper#getGradingData()}
	 * 必须是执行了doGrading方法
	 */
	@Override
	public List<GradingData> getGradingData() {
		
		return gdMapper.getGradingData();
	}

	/**
	 * {@link com.ium.um.mapper.GradingDataMapper#addNormalGradClassResult(List, String, String)}
	 */
	@Override
	public int addNormalGradClassResult(List<Long> idList, String classItem, String timeSign) {
		
		return gdMapper.addNormalGradClassResult(idList, classItem, timeSign);
	}

	/**
	 * {@link com.ium.um.mapper.GradingDataMapper#addAdvGradClassResult(List, String, String, String)}
	 */
	@Override
	public int addAdvGradClassResult(List<Long> idList, String classItem, String timeSign, String gradCondition) {
		
		return gdMapper.addAdvGradClassResult(idList, classItem, timeSign, gradCondition);
	}

	
}
