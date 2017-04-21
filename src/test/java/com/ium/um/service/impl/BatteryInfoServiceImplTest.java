package com.ium.um.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

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

/**
 * @author huang
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@SpringBootTest(classes=Application.class)// 指定spring-boot的启动类
public class BatteryInfoServiceImplTest {

	@Autowired
	BatteryInfoServiceImpl biImpl;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void insertBatchtest() {

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
		
		
		
//		int a = biImpl.insertBatch(biList);
//		assertThat(a).isEqualTo(2);
	}
	
	//@Test
	public void updateNoBatchtest() {

		List<BatteryInfo> biList = new ArrayList<>();
		BatteryInfo bi1 = new BatteryInfo();
		bi1.setId(1L);
		bi1.setNo("1");
		
		BatteryInfo bi2 = new BatteryInfo();
		bi2.setId(2L);
		bi2.setNo("2");
		
		biList.add(bi1);
		biList.add(bi2);
		
//		int a = biImpl.updateNoBatch(biList);
//		assertThat(a).isEqualTo(2);
	}
	
	//@Test
	public void updateNotest(){
			
		boolean b = biImpl.updateNo(3L, "test");
		assertThat(b).isEqualTo(true);
	}

	//@Test
	public void updateStatustest(){
		
		List<Long> idList = new ArrayList<>();
		idList.add(1L);
		idList.add(2L);
		idList.add(3L);
		biImpl.updateStatusBatch(idList);
	}
	
	//@Test
	public void updateIsMastopByChassisNotest(){
		
		int a = biImpl.updateIsMastopByChassisNo("1");
		System.out.println(a);
	}
	
	//@Test
	public void findByIdtest(){
		
		BatteryInfo bi = biImpl.findById(3L);
		assertThat(bi.getNo()).isEqualTo("test3");
	}
	
	//@Test
	public void findBatteryInfoInProc(){
		
		List<BatteryInfo> biList = biImpl.findBatteryInfoInProc();
		System.out.println(biList.size());
	}
	
	//@Test
	public void getMaxIdtest(){
		
		Long a = biImpl.getMaxId();
		System.out.println(a);
	}
	
	//@Test
	public void getLastIdtest(){
		
		Long a = biImpl.getLastId("1");
		System.out.println(a);
	}
		
}
