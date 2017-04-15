package com.ium.um.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;

import com.ium.um.domain.BatteryDetail;
import com.ium.um.domain.BatteryInfo;

@Mapper
public interface  BatteryInfoMapper {
	
//	@Insert("insert into base(chassis, channel, module) values( #{chassis}, #(channel), #{module})")
//	boolean insert(@Param("chassis")String chassis, @Param("channel")String channel, @Param("module")String module);
		
	/**
	 * 批量插入电池信息
	 * @param biList 电池BatteryInfo实例的List
	 * @return 成功插入条数
	 */
	@Insert({
        "<script>",
        "insert into base (chassis, channel, module)",
        "values ",
        "<foreach  collection='biList' item='bi' separator=','>",
        "( #{bi.chassis,jdbcType=VARCHAR}, #{bi.channel,jdbcType=VARCHAR}, #{bi.module,jdbcType=VARCHAR})",
        "</foreach>",
        "</script>"
	})
	int insertBatch(@Param("biList") List<BatteryInfo> biList);
	
	@Update({
		"<script>",
        "update base set (chassis, channel, module)",
        "values ",
        "<foreach  collection='biList' item='bi' separator=','>",
        "( #{bi.chassis,jdbcType=VARCHAR}, #{bi.channel,jdbcType=VARCHAR}, #{bi.module,jdbcType=VARCHAR})",
        "</foreach>",
        "</script>"
	})
	int updateBatch(@Param("biList") List<BatteryInfo> biList);
}
