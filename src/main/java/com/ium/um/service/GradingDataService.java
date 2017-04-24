package com.ium.um.service;

import java.util.List;

import com.ium.um.domain.grading.GradingData;

public interface GradingDataService {

	/**
	 * 分容算法
	 * @param chassisNos
	 * @param steps
	 * @return 数据库中是无返回值的,但mybatis要求有返回值,所以返回的object在业务层返回了0
	 */
	Object doGrading(String chassisNos, String steps);
	
	/**
	 * 获得分容后的临时表
	 * <br>必须执行了 doGrading的方法
	 * @return
	 */
	List<GradingData> getGradingData();
	
	/**
	 * 将基础分容结果写入分容信息表
	 * @param idList 存放分容后的ID
	 * @param classItem 分容类别 100maH-200maH
	 * @param timeSign 时间戳
	 * @return
	 */
	int addNormalGradClassResult(List<Long> idList, String classItem, String timeSign );
	
	/**
	 * 将高级分容结果写入分容信息表
	 * @param idList 存放分容后的ID
	 * @param classItem 分容类别 100maH-200maH
	 * @param timeSign 时间戳
	 * @param gradCondition 分容条件表格的json
	 * @return
	 */
	int addAdvGradClassResult(List<Long> idList,String classItem, String timeSign, String gradCondition);
}
