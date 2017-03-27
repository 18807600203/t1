package com.ium.um.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ium.um.domain.BatteryDetail;

@Mapper
public interface BatteryDetailMapper {

	@Select("select * from  p_find_battery_detail(#{itemStr}, #{valueStr}, #{isLimit})")
	List<BatteryDetail> find(@Param("itemStr") String itemStr, @Param("valueStr") String valueStr, @Param("isLimit") boolean isLimit);
}
