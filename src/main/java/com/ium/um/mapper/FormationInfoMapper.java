package com.ium.um.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import com.ium.um.domain.BatteryDetail;
import com.ium.um.domain.FormationInfo;

@Mapper
public interface FormationInfoMapper {

	/**
	 * 查询某个电池的所有化成信息(带参)
	 * @param baseid 电池的ID
	 * @return 电池化成信息FormationInfo
	 */
	@Select("select id, baseid, dat_fm, instime, p, c, step, status from formation where baseid = #{arg0}::bigint order by instime asc")
	List<FormationInfo> findByID(@Param("arg0")String baseid);
	
	/**
	 * 查询某个电池的分页化成信息(带参)
	 * @param baseid 电池的ID
	 * @param limitNum 分页大小
	 * @param offsetNum 起始位置
	 * @return 电池化成信息FormationInfo
	 */
	@Select("select id, baseid, dat_fm. instimr, p, c, step, status from formation where baseid - #{arg0}::bigint order by instimeasc "
			+"limit #{arg1} offset #{arg2}")
	List<FormationInfo> findByIDLimit(@Param("arg0")String baseid, @Param("arg1")int limitNum, @Param("arg2")int offsetNum);
	

	@Select("select * from  p_insert_formation(#{arg0}, #{arg1}, #{arg2})")
	Object add(@Param("arg0") Long baseid, @Param("arg1") String jsonStr, @Param("arg2") String instime);
}
