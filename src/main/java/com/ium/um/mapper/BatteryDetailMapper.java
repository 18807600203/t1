package com.ium.um.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ium.um.domain.BatteryDetail;

@Mapper
public interface BatteryDetailMapper {

	@Select("select * from  p_find_battery_detail(#{arg0}, #{arg1}, #{arg2})")
	List<BatteryDetail> find(@Param("arg0") String itemStr, @Param("arg1") String valueStr, @Param("arg2") boolean isLimit);
}
