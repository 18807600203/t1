package com.ium.um.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ium.um.domain.formation.FormationData;

@Mapper
public interface FormationDataMapper {

	/**
	 * 以ID查找化成信息
	 * @param id
	 * @return u,i,t
	 */
	@Select("select u, i, t from p_find_formation_info(#{arg0}) as t1(u text, i text, t timestamp without time zone)")
	List<FormationData> findByID(@Param("arg0") String id);
	
}
