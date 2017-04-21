package com.ium.um.controller;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ium.um.Application;
import com.ium.um.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)  
@SpringBootTest(classes=Application.class)// 指定spring-boot的启动类  
@PropertySource("classpath:appconf.properties")
@ConfigurationProperties(prefix = "my" )
public class IndexControllerTest {

	@Autowired
    private AppConfig appConfig;
	
	@Test
    public void likeName() throws SQLException {
        
		String a = appConfig.getChassisNum();
		System.out.println(a);
		assertTrue(a.equals("15"));
    }
}
