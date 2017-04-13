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
public class FormationInfoServiceImplTest {

	@Autowired
	FormationInfoServiceImpl fiImpl;
	
	
	@Test
	public void test() {
		fiImpl.findByID("640");

	}
	
	@Test
	public void test2(){
		fiImpl.add(7040L, "{}", "2017-04-11");
	}

}
