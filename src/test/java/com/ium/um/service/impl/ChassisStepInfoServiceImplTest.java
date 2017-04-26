package com.ium.um.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.ium.um.Application;
import com.ium.um.core.beanUtil.JsonUtils;
import com.ium.um.domain.step.ChassisStepInfo;
import com.ium.um.domain.step.SafeValueData;
import com.ium.um.domain.step.StepFromToData;
import com.ium.um.domain.step.TableValueData;

public class ChassisStepInfoServiceImplTest {

	
	ChassisStepInfoServiceImpl csiImpl;
	
	@Before
	public void setUp() throws Exception {
	}

	//@Test
	public void inserttest() {
		
		List<TableValueData> l = new ArrayList<TableValueData>();
		TableValueData tvd = new TableValueData();
		tvd.setI(500);
		l.add(tvd);
		
		StepFromToData t = new StepFromToData();
		t.setFrom(1);
		t.setTo(2);	
		
		SafeValueData s = new SafeValueData();
		s.setLoopCount(123);
		s.setcThreshold(500);
		
		
		ChassisStepInfo csi = new ChassisStepInfo();
		csi.setNo("2");
		csi.setSafeValueData(s);
		csi.setStepFromToData(t);
		csi.setTableValueData(l);
		
		
		csiImpl.updateChassisStepInfo(csi, false, "1234", "421");
	}

	//@Test
	public void findChassisStepByNotest(){
		
		String jsonStr = csiImpl.findChassisStepByNo("2");
		ChassisStepInfo csi = JsonUtils.parseJson(jsonStr, ChassisStepInfo.class);
		
		assertThat(csi.getTableValueData().get(0).getI()).isEqualTo(500);		
	}
	
	@Test
	public void findAllChassisStepWithNotNulltest(){
		
		List<String> l = csiImpl.findAllChassisStepWithNotNull();
		assertThat(l.size()).isEqualTo(1);
	}
}
