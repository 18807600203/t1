package com.ium.um.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ium.um.domain.BasesfData;

@Mapper
public interface BasesfDataMapper {

	/**
	 * 插入basesf表的配置文件关联信息
	 * @param idList
	 * @param genid
	 * @return
	 */
	@Insert({
        "<script>",
	        "insert into basesf (baseid, sfid)",
	        "values ",
	        "<foreach  collection='idList' item='id' separator=','>",
	        	"( #{id}, #{genid})",
	        "</foreach>",
        "</script>"
	})
	int addBatch(@Param("idList")List<Long> idList, @Param("genid")String genid);
	
	/**
	 * 以ID查询分容配置文件
	 * @param id
	 * @return
	 */
	@Select("select a.id, a.baseid, b.sfile::text, b.timesign from basesf a, historysf b where a.baseid = #{id} and "
			+ "a.sfid = b.genid")
	BasesfData findById(@Param("id")Long id);
}
