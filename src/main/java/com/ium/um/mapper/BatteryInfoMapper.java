package com.ium.um.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import com.ium.um.domain.BatteryInfo;

@Mapper
public interface  BatteryInfoMapper {

	@Select("select * from base where id = #{id}")
	BatteryInfo findById( Long id);
	
	@Select("select * from base where no = #{no}")
	BatteryInfo findByNo( String no);
	
	@Select("call p_find_battery_detail(?, ?, ?)")
	@Options(statementType = StatementType.CALLABLE )
	List<Object> findBatteryDetail(String itemStr, String valueStr, boolean isLimit);
		
	@Select("select * from base order by id asc")
	List<BatteryInfo> getAll();
	
	@Insert("insert into base(chassis, channel, module) values( #{0}, #(1), #{2})")
	boolean insert(String chassis, String channel, String module);
}
