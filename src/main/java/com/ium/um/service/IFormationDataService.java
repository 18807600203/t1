package com.ium.um.service;

import java.util.List;
import com.ium.um.domain.FormationData;

public interface IFormationDataService {
	
	/**
	 * 以ID查找化成信息
	 * @param id
	 * @return
	 */
	List<FormationData> findByID(String id);
	
}
