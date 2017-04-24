package com.ium.um.service.impl;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ium.um.Application;
import com.ium.um.domain.formation.FormationData;

@RunWith(SpringJUnit4ClassRunner.class)  
@SpringBootTest(classes=Application.class)// 指定spring-boot的启动类  
public class FormationDataServiceImplTest {

	@Autowired
	FormationDataServiceImpl fimpl;
	


	@Test
	public void test() {
		List<FormationData> l = fimpl.findByID("601");
		System.out.println(l.size());
	}

}
