package com.ium.um.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import com.ium.um.domain.FormationData;

@Mapper
public interface FormationDataMapper {

	@Select("select u, i, t from p_find_formation_info(#{arg0}) as t1(u text, i text, t timestamp without time zone)")
	List<FormationData> findByID(@Param("arg0") String id);
	
}
