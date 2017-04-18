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
import com.ium.um.domain.BasesfData;

@RunWith(SpringJUnit4ClassRunner.class)  
@SpringBootTest(classes=Application.class)// 指定spring-boot的启动类
public class BasesfDataServiceImplTest {

	@Autowired
	BasesfDataServiceImpl bdImpl;
	
	@Before
	public void setUp() throws Exception {
	}

	//@Test
	public void addBatchtest() {
		
		List<Long> idList = new ArrayList<>();
		idList.add(1L);
		idList.add(2L);
		
		int a = bdImpl.addBatch(idList, "816548924566274048"); //history表的genid 819811702672457728
		assertThat(a).isEqualTo(2);
	}
	
	@Test
	public void findByIdtest(){
		
		
		BasesfData bd = bdImpl.findById(5760L);
		System.out.println(bd);
	}
	
	

}
