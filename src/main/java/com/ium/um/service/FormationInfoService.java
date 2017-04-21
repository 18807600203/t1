package com.ium.um.service;

import java.util.List;
import com.ium.um.domain.FormationData;
import com.ium.um.domain.FormationInfo;

public interface FormationInfoService {

	/**
	 * 根据ID查询全部信息
	 * @param baseid
	 * @return
	 */
	List<FormationInfo> findByID(String baseid);
	
	/**
	 * 根据ID查询分页信息
	 * @param baseid
	 * @param limitNum
	 * @param offsetNum
	 * @return
	 */
	List<FormationInfo> findByIDLimit(String baseid, int limitNum, int offsetNum);
	
	/**
	 * 添加化成信息
	 * @param baseid
	 * @param fd
	 * @param instime
	 * @return
	 */
	FormationData add(long baseid, FormationData fd, String instime);
}
