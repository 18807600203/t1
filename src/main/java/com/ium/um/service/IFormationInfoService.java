package com.ium.um.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ium.um.domain.FormationData;
import com.ium.um.domain.FormationInfo;

public interface IFormationInfoService {

	List<FormationInfo> findByID(String baseid);
	
	List<FormationInfo> findByIDLimit(String baseid, int limitNum, int offsetNum);
	
	Object add(long baseid, FormationData fd, String instime);
}
