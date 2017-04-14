package com.ium.um.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ium.um.Application;
import com.ium.um.domain.FormationData;
import com.ium.um.domain.FormationInfo;


@RunWith(SpringJUnit4ClassRunner.class)  
@SpringBootTest(classes=Application.class)// 指定spring-boot的启动类
public class FormationInfoServiceImplTest {

	@Autowired
	FormationInfoServiceImpl fiImpl;

	@Autowired
    private Cache<String, String> cityCache;
	
	@Test
	public void test() {
		fiImpl.findByID("640");

	}
	
	@Test
	public void test2(){
		
		FormationData fd = new FormationData();
		fd.setPosition("1_01_1");
		fd.setC("0.5");
		fd.setStep("1");
		fd.setStatus("a0");
		fd.setU("4200");
		fd.setI("500");
		
		fiImpl.add(7040L, fd, "2017-04-16");
	}

}
