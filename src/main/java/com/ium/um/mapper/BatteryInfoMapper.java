package com.ium.um.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import com.ium.um.domain.BatteryDetail;
import com.ium.um.domain.BatteryInfo;

@Mapper
public interface  BatteryInfoMapper {

	@Select("select * from base where id = #{id}")
	BatteryInfo findById(@Param("id")Long id);
	
	@Select("select * from base where no = #{no}")
	BatteryInfo findByNo(@Param("no") String no);
		
	@Select("select * from base order by id asc")
	List<BatteryInfo> getAll();
	
	@Insert("insert into base(chassis, channel, module) values( #{chassis}, #(channel), #{module})")
	boolean insert(@Param("chassis")String chassis, @Param("channel")String channel, @Param("module")String module);
	
}
