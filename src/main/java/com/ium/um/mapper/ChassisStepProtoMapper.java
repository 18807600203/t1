package com.ium.um.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ChassisStepProtoMapper {

	@Select("select p__set_sfile( #{arg0}, #{arg1}, #{arg2}, #{arg3}, #{arg4} )")
	Object updateChassisStepInfo( @Param("arg0")int no, @Param("arg1")String jsonStr, @Param("arg2")boolean isSetNull, 
			@Param("arg3")String timeSign, @Param("arg4")String genId);
}
