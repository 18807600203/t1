package com.ium.um.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
	
	/**
	 * 批量更新电池的NO信息
	 * @param biList
	 * @return
	 * @see
	 * <br>update base	
	 * <br>&nbsp&nbsp set no = case id 
	 * <br>&nbsp&nbsp&nbsp&nbsp	when 1 then 'no1'
	 * <br>&nbsp&nbsp&nbsp&nbsp	when 2 then 'no2'
	 * <br>&nbsp&nbsp&nbsp&nbsp	when 3 then 'no3'
	 * <br>&nbsp&nbsp end
	 * <br>where id in (1,2,3)
	 */
	@Update({
		"<script>",
	        "update base ",
	        "<trim prefix='set' suffixOverrides=','>",
	        "<trim prefix='no = case' suffix='end,'>",
		        "<foreach collection='biList' item='bi' index='index'>",
			        "<if test='bi.no!=null'>",
			        	"when id=#{bi.id} then #{bi.no}",
			        "</if>",
		        "</foreach>",
	        "</trim>",
	        "</trim>",
	        " where ",
	        "<foreach collection='biList' separator='or' item='bi' index='index' >",
	        	"id=#{bi.id}",
	        "</foreach>",
        "</script>"
	})
	int updateNoBatch(@Param("biList") List<BatteryInfo> biList);
	
	/**
	 * 更新单个电池的NO信息
	 * @param id
	 * @param no
	 * @return
	 */
	@Update("update base set no = #{no} where id = #{id}")
	boolean updateNo(@Param("id") Long id, @Param("no")String no);

	/**
	 * 批量更新已完成分选的电池
	 * @param idList
	 * @return
	 */
	@Update({
		"<script>",
	        "update base set isgrad = B'1' ",
	        "where isformat = B'1' and isgrad = B'0' and ismastop = B'0' and id in (",
	        "<foreach collection='idList' index='index' item='id' separator=',' >",
            	"#{id}",
	        "</foreach>",
	        ")",
	    "</script>"
	})
	int updateStatusBatch(@Param("idList") List<Long> idList);

	/**
	 * 将对应机框的手动停止位置1
	 * @param chassisno
	 * @return
	 */
	@Update("update base set ismastop = B'1' where chassis = #{chassisno} and ismastop = B'0'")
	int updateIsMastopByChassisNo(@Param("chassisno") String chassisno);

	/**
	 * 以ID查找电池的基本信息
	 * @param id
	 * @return
	 */
	@Select("select id, no, chassis, channel, module, isformat, isgrad, ismatch, ismastop from base where id = #{id}")
	BatteryInfo findById(@Param("id") Long id);
	
	/**
	 * 查询没完成 化成&分容&配对  工步的电池
	 * @return List<BatteryInfo>只包含id 和 no
	 */
	@Select("select id, no from base where isformat = B'0' and isgrad = B'0' and ismatch = B'0' and ismastop = B'0' ")
	List<BatteryInfo> findBatteryInfoInProc();
	
	/**
	 * 查询表中当前最大的ID
	 * @return
	 */
	@Select("select max(id) from base")
	Long getMaxId();
	
	/**
	 * 查询表中删一次没完成分容&分选操作的第一个ID
	 * <br>即本地ID表删掉后可以获得上一次的ID号
	 * @return
	 */
	@Select("select id from base where chassis = #{chassisno} and channel = '01' and module = '1' and "
			+ "isformat = B'0' and isgrad = B'0' and ismatch = B'0' and ismastop = B'0' ")
	Long getLastId(@Param("chassisno") String chassisNo);
	
	
}
