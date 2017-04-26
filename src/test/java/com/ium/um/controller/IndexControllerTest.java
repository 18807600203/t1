package com.ium.um.controller;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;


import com.ium.um.Application;
import com.ium.um.config.AppConfig;

public class IndexControllerTest {

	
    private AppConfig appConfig;
	
	@Test
    public void likeName() throws SQLException {
        
		String a = appConfig.getChassisNum();
		System.out.println(a);
		assertTrue(a.equals("15"));
    }
}
