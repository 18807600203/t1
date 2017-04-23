package com.ium.um.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.google.protobuf.InvalidProtocolBufferException;
import com.ium.um.domain.ChassisStepProto.*;




public class ChassisStepDataTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws InvalidProtocolBufferException {
		
		ChassisStepInfo.Builder builder =  ChassisStepInfo.newBuilder();
		StepInfoData.Builder builder2 = StepInfoData.newBuilder();
		builder2.setFilePath("test");
		builder2.addTableValueInfo(0, TableValueInfo.newBuilder().setI(500));
		builder2.addTableValueInfo(1, TableValueInfo.newBuilder().setMaxU(4200));
		builder2.setGradValueInfo( GradValueInfo.newBuilder().setFinalILoop(1));
		builder.setNo(123);
		builder.setStepInfoData(builder2);
		byte[] buf = builder.build().toByteArray();
		System.out.println(buf.length);
		
		ChassisStepInfo tb = ChassisStepInfo.parseFrom(buf);  
        System.out.println( tb.getStepInfoData());  
        System.out.println( tb.getNo());  
        TableValueInfo bd = tb.getStepInfoData().getTableValueInfoList().get(0);
        int a = bd.getI();
        System.out.println(a);
        
	}

}
