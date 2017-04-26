package com.ium.um.service.impl;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.ium.um.Application;
import com.ium.um.domain.formation.FormationData;

public class FormationDataServiceImplTest {

	
	FormationDataServiceImpl fimpl;
	


	@Test
	public void test() {
		List<FormationData> l = fimpl.findByID("601");
		System.out.println(l.size());
	}

}
