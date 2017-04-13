package com.ium.um.service;

import java.util.List;

import com.ium.um.domain.FormationData;

public interface IFormationDataService {
	
	List<FormationData> findByID(String id);
}
