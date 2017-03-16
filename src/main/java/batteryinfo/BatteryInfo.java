package batteryinfo;

import java.io.Serializable;

/**
 * 电池信息实体
 */
public class BatteryInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ID; //数据库ID列
	private String NO; //电池编码
	private String CHASSIS; //机框
	private String CHANNEL; //通道
	private String MODULE;  //模块
	private boolean ISFORMAT; //是否化成
	private boolean ISGRAD; //是否分容
	private boolean ISMATCH; //是否配对
	private boolean ISMASTOP; //是否收工停止

	public void setId(String ID) {
		this.ID = ID;
	}

	public String getId() {
		return ID ;
	}

	public void setNo(String NO){
		this.NO = NO;
	}

	public String getNo(){
		return NO;
	}
	
	public void setChassis(String CHASSIS){
		this.CHASSIS = CHASSIS;
	}
	
	public String getChassis(){
		return CHASSIS;
	}
	
	public void setChannel(String CHANNEL){
		this.CHANNEL = CHANNEL;
	}
	
	public String getChannel(){
		return CHANNEL;
	}
	
	public void setModule(String MODULE){
		this.MODULE = MODULE;
	}
	
	public String getModule(){
		return MODULE;
	}
	
	public void setIsformat(boolean ISFORMAT){
		this.ISFORMAT = ISFORMAT;
	}
	
	public boolean getIsformat(){
		return ISFORMAT;
	}
	
	public void setIsgrad(boolean ISGRAD){
		this.ISGRAD = ISGRAD;
	}
	
	public boolean getIsgrad(){
		return ISGRAD;
	}
	
	public void setIsmatch(boolean ISMATCH){
		this.ISMATCH = ISMATCH;
	}
	
	public boolean getIsmatch(){
		return ISMATCH;
	}
	
	public void setIsmastop(boolean ISMASTOP){
		this.ISMASTOP = ISMASTOP;
	}
	
	public boolean getIsmastop(){
		return ISMASTOP;
	}
	
	public String getPosition(){
		
		return CHASSIS + "_" + CHANNEL + "_" + MODULE;
	}
	
	@Override
	public String toString(){
		
		return "[ID:" + ID + " " +
				"NO:" + NO + " " +
				"Chassis:" + CHASSIS + " " +
				"Channel:" + CHANNEL + " " +
				"Module:"  + MODULE  + " " +
				"isFormat:" + ISFORMAT + "  " +
				"isGrad:"   + ISGRAD   + "  " +
				"isMatch:"  + ISMATCH  + "  " +
				"isMaStop:" + ISMATCH  + "]";
	}
	
	@Override
	public int hashCode() {
		
		int result = NO.hashCode();
		result = result * 37 + ID.hashCode();
		return result;
	}
	
	@Override
	public boolean equals(Object obj){
		
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		BatteryInfo bi = (BatteryInfo) obj;
		return this.NO.equals(bi.NO) && this.ID == bi.ID;
	}
	
	
}

