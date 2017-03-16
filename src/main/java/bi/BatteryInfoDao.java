package bi;

import java.util.List;

import org.beetl.sql.core.annotatoin.Sql;
import org.beetl.sql.core.annotatoin.SqlStatement;
import org.beetl.sql.core.mapper.BaseMapper;

import batteryinfo.BatteryInfo;

public interface BatteryInfoDao extends BaseMapper<BatteryInfo>{

	@SqlStatement(params="ID")
	public BatteryInfo findBatteryInfo(String id);
	
	//使用默认user.updateAge
	public int updateNo(BatteryInfo batteryInfo);
	
	@Sql(value=" update base set no = ? where id = ? ")
	public int updateAge2(String id,String no);
	
	public List<BatteryInfo> selectUser(BatteryInfo batteryInfo);
}
