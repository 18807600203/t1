package com.ium.um.core.beanUtil;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;



/**
 * json 工具类
 */
public class JsonUtils {

	private static final ObjectMapper objectMapper;
	
	static {  
        objectMapper = new ObjectMapper();  
        //去掉默认的时间戳格式  
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);  
        //设置为中国上海时区  
        objectMapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));  
        objectMapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);  
        //空值不序列化  
        objectMapper.setSerializationInclusion(Include.NON_NULL);  
        //反序列化时，属性不存在的兼容处理  
        objectMapper.getDeserializationConfig().withoutFeatures(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);  
        //序列化时，日期的统一格式  
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));  
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);  
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);  
        //单引号处理  
        objectMapper.configure(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);  
    } 

	/**
	 * Object to json
	 * @param object 对象
	 * @return String
	 */
	public static String toJson(Object object) {
		try {
			return objectMapper.writeValueAsString(object);
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}

	/**
	 * json to pojo
	 * @param jsonString json String
	 * @param classType 对象类
	 * @return
	 */
	public static <T> T parseJson(String jsonString, Class<T> classType) {
		try {
			return objectMapper.readValue(jsonString, classType);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
