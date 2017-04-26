package com.ium.um.core.rule;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ium.um.Application;

@RunWith(SpringJUnit4ClassRunner.class)  
@SpringBootTest(classes=Application.class)// 指定spring-boot的启动类
public class CreateBaseFolderTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		
		CreateBaseFolder f = new CreateBaseFolder();
		
	}

}
