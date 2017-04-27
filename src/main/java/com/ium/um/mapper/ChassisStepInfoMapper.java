package com.ium.um.mapper;

import java.util.List;


public interface ChassisStepInfoMapper {

	/**
	 * 更新机框的配置文件并写入历史配置文件表
	 * @param no 机框号
	 * @param jsonStr 机框配置对象的Json String
	 * @param isSetNull 是否置空
	 * @param timeSign 时间戳
	 * @param genId 生成的ID
	 * @return 返回一个null的OBject
	 */
//	@Select("select * from  p_set_sfile(#{arg0}, #{arg1}, #{arg2}, #{arg3}, #{arg4})")
//	Object updateChassisStepInfo( @Param("arg0")String no, @Param("arg1")String jsonStr, @Param("arg2")boolean isSetNull, 
//			@Param("arg3")String timeSign, @Param("arg4")String genId);
//	
//
//	/**
//	 * 查询对应机框的噢诶之文件
//	 * @param no 机框号
//	 * @return
//	 */
//	@Select("select sfile::text from projsf where no = #{no}")
//	String findChassisStepByNo(@Param("no")String no);
//	
//	
//	/**
//	 * 查询所有不为空的机框配置文件
//	 * @return
//	 */
//	@Select("select sfile::text from projsf where no is not null")
//	List<String> findAllChassisStepWithNotNull();
}

