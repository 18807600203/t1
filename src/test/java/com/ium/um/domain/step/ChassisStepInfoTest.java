package com.ium.um.domain.step;

import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;


import org.junit.Before;
import org.junit.Test;

import io.protostuff.JsonIOUtil;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.runtime.RuntimeSchema;

import com.ium.um.core.beanUtil.JsonUtils;


public class ChassisStepInfoTest {

	private RuntimeSchema<ChassisStepInfo> schema1 = RuntimeSchema.createFrom(ChassisStepInfo.class);
	
	@Before
	public void setUp() throws Exception {
	}

	
	
	@Test
	public void test() throws Exception {
		
		
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
		
		System.out.println(csi);
		System.out.println("原始json数据 " + JsonUtils.toJsonString(csi));
		byte[] array = ProtostuffIOUtil.toByteArray(csi, schema1, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
		System.out.println("序列化数据为"+array);
		System.out.println("------序列化结束------");
		// 反序列化
		ChassisStepInfo csi2 = schema1.newMessage();
		ProtostuffIOUtil.mergeFrom(array, csi2, schema1);		
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();//向OutPutStream中写入，如 message.writeTo(baos);  
		JsonIOUtil.writeTo(baos, csi2, schema1, false, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));		
		String str = baos.toString();  
		
		System.out.println("反序列化后的数据为："+csi2);
		System.out.println("json："+ str);
		System.out.println("123");
		
		//文件以byte[]存储
		//读取
		ChassisStepInfo csi3 = schema1.newMessage();	
		File f=new File("F:\\abc.txt");
		FileInputStream fos  = new FileInputStream(f);
		ProtostuffIOUtil.mergeFrom(fos, csi3, schema1, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
		System.out.println(csi3);
		
//		 File f=new File("F:\\abc.txt");
//		 FileOutputStream fos  = new FileOutputStream(f);
//	      // fos.write(baos.toByteArray()); //以json形式存储
//		 fos.write(array);//已二进制存储        
	     fos.close();  
		
		
		ChassisStepInfo csi4 = JsonUtils.parseJson(str, ChassisStepInfo.class);
	     
	     System.out.println("json2pojo: " + csi4);
	     
	     
		assertEquals( csi.getSafeValueData(), csi2.getSafeValueData());
		assertEquals( csi.getSafeValueData(), csi4.getSafeValueData());
	}

}
