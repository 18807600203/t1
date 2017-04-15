package com.ium.um.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ium.um.Application;
import com.ium.um.domain.BatteryInfo;

@RunWith(SpringJUnit4ClassRunner.class)  
@SpringBootTest(classes=Application.class)// 指定spring-boot的启动类
public class BatteryInfoServiceImplTest {

	@Autowired
	BatteryInfoServiceImpl biImpl;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {

		List<BatteryInfo> biList = new ArrayList<>();
		BatteryInfo bi1 = new BatteryInfo();
		bi1.setChassis("10");
		bi1.setChannel("01");
		bi1.setModule("1");
		
		BatteryInfo bi2 = new BatteryInfo();
		bi2.setChassis("10");
		bi2.setChannel("02");
		bi2.setModule("1");
		
		biList.add(bi1);
		biList.add(bi2);
		
		int a = biImpl.insertBatch(biList);
		assertThat(a).isEqualTo(2);
	}

}
