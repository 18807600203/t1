package com.ium.um.dao;

import java.util.List;

import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.annotatoin.Sql;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.ium.um.domain.BatteryInfo;

public interface BatteryInfoDao extends BaseMapper<BatteryInfo>{

	
	
	@Sql(value=" select * from base where id = ? ")
	public BatteryInfo findById(Long id);
	
	
}
