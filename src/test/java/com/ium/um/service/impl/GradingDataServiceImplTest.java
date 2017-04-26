package com.ium.um.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ium.um.Application;
import com.ium.um.domain.grading.GradingData;

public class GradingDataServiceImplTest {

	 private final Logger logger = LoggerFactory.getLogger(this.getClass());  
	
	GradingDataServiceImpl gdImpl;
	
	@Before
	public void setUp() throws Exception {
		
		
	}

	//@Test
	public void doGradingTest() {
		
		gdImpl.doGrading("1,3", "1,3");
	}
	
	@Test
	public void getGradingDatatest(){
		
		List<GradingData> l = gdImpl.getGradingData();
		logger.warn("count:" + l.size());
		logger.error("count:" + l.size());
		logger.info("count:" + l.size());
		logger.trace("count:" + l.size());
		
	}
	
	//@Test
	public void addNormalGradClassResultTest(){
		
		List<Long> idList = new ArrayList<>();
		idList.add(601L);
		idList.add(602L);
		String classItem = "100-200";
		String timesign = "1484215034658";
		
		int a = gdImpl.addNormalGradClassResult(idList, classItem, timesign);
		logger.debug(a+"");
	}
	
	//@Test
	public void addAdvGradClassResultTest(){
		
		List<Long> idList = new ArrayList<>();
		idList.add(601L);
		idList.add(602L);
		String classItem = "100-200";
		String timeSign = "1484215034658";
		String gradCondition = "{}";
		
		int a = gdImpl.addAdvGradClassResult(idList, classItem, timeSign, gradCondition);
		logger.debug(a+"");
	}
}
