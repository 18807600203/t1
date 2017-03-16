package batteryinfo;

public interface BatteryInfoService {

	public long total() ;
	public void save(BatteryInfo batteryInfoBean);
	public void allUser(BatteryInfo query);
}
