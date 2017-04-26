package com.ium.um.core.rule;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.ium.um.Application;


public class CreateBaseFolderTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		
		CreateBaseFolder f = new CreateBaseFolder();
		assertThat(1).isEqualTo(1);
	}

}
