package com.ium.um.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ium.um.domain.grading.ExpertGradingValues;

@Mapper
public interface ExpertGradingValuesMapper {

	/**
	 * 高级分选的入口
	 * @param chassises 机框s
	 * @param ustep 电压分选工步
	 * @param maxcsteps 终止容量分选工步s
	 * @param minordifcsteps 最小容量或容量差分选工步
	 * @param istep 电流分选工步
	 * @param ufeatures 特征电压值
	 * @return
	 */
	@Select("select row_number() over ( order by id) as rowid, id, p, no, ocv, avgu, finalu, finali, maxc, difc, t, t1, t2, t3 "
			+ " from p_ex_grad( #{arg0}, #{arg1}, #{arg2}, #{arg3}, #{arg4}, #{arg5} )")
	List<ExpertGradingValues> findAll(@Param("arg0")String chassises, @Param("arg1")String ustep, @Param("arg2")String maxcsteps, 
				@Param("arg3")String minordifcsteps, @Param("arg4")String istep, @Param("arg5")String ufeatures);
}
