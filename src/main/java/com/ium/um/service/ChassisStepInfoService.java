package com.ium.um.service;

import java.util.List;

import com.ium.um.domain.step.ChassisStepInfo;

public interface ChassisStepInfoService {

	/**
	 * 更新机框的配置文件并写入历史配置文件表
	 * @param no 机框号
	 * @param jsonStr 机框配置对象的Json String
	 * @param isSetNull 是否置空
	 * @param timeSign 时间戳
	 * @param genId 生成的ID
	 * @return 返回一个null的OBject
	 */
	Object updateChassisStepInfo(ChassisStepInfo csi, boolean isSetNull, String timeSign, String genId);
	
	/**
	 * 查询对应机框的噢诶之文件
	 * @param no 机框号
	 * @return
	 */
	String findChassisStepByNo(String no);
	
	/**
	 * 查询所有不为空的机框配置文件
	 * @return
	 */
	List<String> findAllChassisStepWithNotNull();
}
