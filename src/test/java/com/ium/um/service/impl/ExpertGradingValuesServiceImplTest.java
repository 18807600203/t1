package com.ium.um.service.impl;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.ium.um.Application;
import com.ium.um.domain.grading.ExpertGradingValues;

public class ExpertGradingValuesServiceImplTest {

	
	ExpertGradingValuesServiceImpl egvImpl;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void ExpertGradingValuesServiceImpltest() {
		
		List<ExpertGradingValues> l = new ArrayList<>();
		l = egvImpl.findAll("1,2", "1", "1,3", "1,3", "1", "3.8,3.717,3.64");
		int a = l.size();
		
		assertThat(a).isEqualTo(9);
	}

}
