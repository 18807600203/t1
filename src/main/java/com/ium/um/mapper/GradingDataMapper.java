package com.ium.um.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GradingDataMapper {

	/**
	 * 分容算法
	 * @param chassisNos 机框s
	 * @param steps 工步s
	 */
	@Select("select * from p_find_assign_chassis_avg_c( #{arg0}, #{arg1})")
	void doGrading(@Param("arg0")String chassisNos, @Param("arg1")String steps);
}
