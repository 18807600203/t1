package com.ium.um.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ium.um.domain.BatteryInfo;

@Mapper
public interface  BatteryInfoMapper {

	@Select("select * from base where id = #{id}")
	BatteryInfo findById( Long id);
	
	
}
