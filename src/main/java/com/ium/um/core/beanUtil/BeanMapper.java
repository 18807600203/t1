package com.ium.um.core.beanUtil;

import java.util.List;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.builtin.PassThroughConverter;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.TypeFactory;

/**
 * Bean 的复制工具
 */
public class BeanMapper {

	private static MapperFacade mapper;
	
	static{
		//如果src中属性为null,就不复制到dest
		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().mapNulls(false).build();
		//如果属性是Object,就知复制引用, 不复制值,可以避免循环复制
		mapperFactory.getConverterFactory().registerConverter(new PassThroughConverter(Object.class));
		mapper = mapperFactory.getMapperFacade();
	}
	
	/**
	 * 把src中的值复制到dest中
	 * @param src
	 * @param dest
	 */
	public void copy(Object src, Object dest){
		
		mapper.map(src, dest);
	}
	
	/**
	 * 指定复制的src和target的class
	 * @param src
	 * @param target
	 * @param srcClass
	 * @param targetClass
	 */
	public <S, D> void copy(S src, D target, Class<S> srcClass, Class<D> targetClass){
		
		mapper.map(src, target, TypeFactory.valueOf(srcClass), TypeFactory.valueOf(targetClass));
	}
	
	/**
	 * 复制list
	 * @param src
	 * @param clz
	 * @return
	 */
	public <S, D> List<D> copyList(List<S> src, Class<D> clz){
		return mapper.mapAsList(src, clz);
	}

}
