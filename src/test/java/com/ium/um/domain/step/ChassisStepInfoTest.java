package com.ium.um.domain.step;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import com.ium.um.core.beanUtil.SerializationUtil;


public class ChassisStepInfoTest {

	private RuntimeSchema<ChassisStepInfo> schema1 = RuntimeSchema.createFrom(ChassisStepInfo.class);
	
	@Before
	public void setUp() throws Exception {
	}

	
	
	@Test
	public void test() {
		
		
	//	List<TableValueData> l = new ArrayList<TableValueData>();
//		TableValueData tvd = new TableValueData();
//		tvd.setI(500);
//		l.add(tvd);
		
		StepFromToData t = new StepFromToData();
		t.setFrom(1);
		t.setTo(2);	
		
		SafeValueData s = new SafeValueData();
		s.setLoopCount(123);
		s.setcThreshold(500);
		
		
		ChassisStepInfo csi = new ChassisStepInfo();
		csi.setNo(2);
		//csi.setSafeValueData(s);
		//csi.setStepFromToData(t);
		//csi.setTableValueData(l);
		
		System.out.println(csi);
		
		byte[] array = ProtostuffIOUtil.toByteArray(csi, schema1, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
//		System.out.println("序列化数据为"+array);
//		System.out.println("------序列化结束------");
//		// deser
//		ChassisStepInfo newMessage = schema1.newMessage();
//		ProtostuffIOUtil.mergeFrom(array, newMessage, schema1);
//		System.out.println("反序列化后的数据为："+newMessage);
	}

}
