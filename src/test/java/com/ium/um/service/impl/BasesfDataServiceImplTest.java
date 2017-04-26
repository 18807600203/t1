package com.ium.um.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ium.um.domain.sfile.BasesfData;

public class BasesfDataServiceImplTest {
	
	
	
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
		
	}
	
	@Test
	public void findByIdtest(){
		
		
		BasesfData bd = bdImpl.findById(5760L);
		System.out.println(bd);
	}
	
	

}
