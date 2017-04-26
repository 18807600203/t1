package com.ium.um.core.beanUtil;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;


/**
 * json 工具类
 */
public class JsonUtils {

	/**
	 * 构造器
	 * @return
	 */
	protected static ObjectMapper getObjectMapper() {

		ObjectMapper om = new ObjectMapper();
		return om;
	}

	/**
	 * Object to json
	 * @param object 对象
	 * @return String
	 */
	public static String toJsonString(Object object) {
		try {
			return getObjectMapper().writeValueAsString(object);
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
			return getObjectMapper().readValue(jsonString, classType);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
