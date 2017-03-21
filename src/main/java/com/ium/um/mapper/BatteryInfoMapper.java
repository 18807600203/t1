package com.ium.um.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ium.um.domain.BatteryInfo;

@Mapper
public interface  BatteryInfoMapper {

	@Select("select * from base where id = #{id}")
	BatteryInfo findById( Long id);
	
	@Select("select * from base order by id asc")
	List<BatteryInfo> getAll();
	
	@Insert("insert into base(chassis, channel, module) values( #{0}, #(1), #{2})")
	boolean insert(String chassis, String channel, String module);
}
