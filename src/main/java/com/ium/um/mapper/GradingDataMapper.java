package com.ium.um.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ium.um.domain.GradingData;

@Mapper
public interface GradingDataMapper {

	/**
	 * 分容算法
	 * @param chassisNos 机框s
	 * @param steps 工步s
	 * @return 数据库中是无返回值的,但mybatis要求有返回值,所以返回的object在业务层返回了0
	 */
	@Select("select * from p_find_assign_chassis_avg_c( #{arg0}, #{arg1})")
	Object doGrading(@Param("arg0")String chassisNos, @Param("arg1")String steps);
	
	/**
	 * 获得分容后的临时表
	 * <br>必须执行了 doGrading的方法
	 * @return
	 */
	@Select(" select id, baseid, location, cvalue from tmp_grading")
	List<GradingData> getGradingData();
	
	/**
	 * 将基础分容结果写入分容信息表
	 * @param idList 存放分容后的ID
	 * @param classItem 分容类别 100maH-200maH
	 * @param timeSign 时间戳
	 * @return
	 */
	@Insert({
        "<script>",
	        "insert into grading (baseid, groupclass, timesign)",
	        "values ",
	        "<foreach  collection='idList' item='id' index='index' separator=','>",
	        	"( #{id}, #{classItem}, #{timeSign})",
	        "</foreach>",
        "</script>"
	})
	int addNormalGradClassResult(@Param("idList")List<Long> idList, @Param("classItem")String classItem, @Param("timeSign")String timeSign );
	
	/**
	 * 将高级分容结果写入分容信息表
	 * @param idList 存放分容后的ID
	 * @param classItem 分容类别 100maH-200maH
	 * @param timeSign 时间戳
	 * @param gradCondition 分容条件表格的json
	 * @return
	 */
	@Insert({
        "<script>",
	        "insert into grading (baseid, groupclass, timesign, gradf)",
	        "values ",
	        "<foreach  collection='idList' item='id' index='index' separator=','>",
	        	"( #{id}, #{classItem}, #{timeSign}, #{gradCondition}::json)",
	        "</foreach>",
        "</script>"
	})
	int addAdvGradClassResult(@Param("idList") List<Long> idList, @Param("classItem")String classItem,
			@Param("timeSign")String timeSign, @Param("gradCondition")String gradCondition);
}
