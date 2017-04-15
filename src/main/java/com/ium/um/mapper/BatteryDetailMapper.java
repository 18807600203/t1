package com.ium.um.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ium.um.domain.BatteryDetail;

@Mapper
public interface BatteryDetailMapper {

	/**
	 * 查询电池的相关信息
	 * @param itemStr 查询的项 id/no/postition
	 * @param valueStr 查询的值
	 * @param isLimit 是否只显示前10项
	 * @return id, no, chassis, channel, module, isformation, isgrad, ismatch, ismastop, sfile, sftimesign, groupclass, gradtimesign
	 */
	@Select("select * from  p_find_battery_detail(#{arg0}, #{arg1}, #{arg2})")
	List<BatteryDetail> find(@Param("arg0") String itemStr, @Param("arg1") String valueStr, @Param("arg2") boolean isLimit);
}
