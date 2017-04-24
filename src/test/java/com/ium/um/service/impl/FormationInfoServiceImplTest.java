package com.ium.um.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ium.um.Application;
import com.ium.um.domain.formation.FormationData;
import com.ium.um.domain.formation.FormationInfo;


@RunWith(SpringJUnit4ClassRunner.class)  
@SpringBootTest(classes=Application.class)// 指定spring-boot的启动类
public class FormationInfoServiceImplTest {

	@Autowired
	FormationInfoServiceImpl fiImpl;
	@Autowired 
	CacheManager cache;
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void test() {
		
		List<FormationInfo> l2 = fiImpl.findByID("601");
		Cache UI_Cache = cache.getCache("UI_Cache");
		List<FormationInfo> l = (List<FormationInfo>) UI_Cache.get("601").get();
		assertThat(l).isEqualTo(l2);
				
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
		
		fiImpl.add(7040L, fd, "2017-04-21");
		Cache UI_Cache = cache.getCache("UI_Cache");
		FormationData fd2 = (FormationData) UI_Cache.get("1_01_1").get();
		assertThat(fd2).isEqualTo(fd);
		
	}

}
