package com.ium.um.service.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ium.um.Application;

@RunWith(SpringJUnit4ClassRunner.class)  
@SpringBootTest(classes=Application.class)// 指定spring-boot的启动类
public class GradingDataServiceImplTest {

	@Autowired
	GradingDataServiceImpl gdImpl;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		
		gdImpl.doGrading("1,3", "1,3");
	}

}
