package com.ium.um.service;

import java.util.List;

import com.ium.um.domain.sfile.BasesfData;

public interface BasesfDataService {

	/**
	 * 插入basesf表的配置文件关联信息
	 * @param idList
	 * @param genid
	 * @return
	 */
	int addBatch(List<Long> idList, String genid);
	
	/**
	 * 以ID查询分容配置文件
	 * @param id
	 * @return
	 */
	BasesfData findById(Long id);
}
