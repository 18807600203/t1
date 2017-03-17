package com.ium.um.domain;

import java.io.Serializable;

/**
 * 电池信息实体
 */
public class BatteryInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id; //数据库ID列
	private String no; //电池编码
	private String chassis; //机框
	private String channel; //通道
	private String module;  //模块
	private boolean isformat; //是否化成
	private boolean isgrad; //是否分容
	private boolean ismatch; //是否配对
	private boolean ismastop; //是否收工停止
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getChassis() {
		return chassis;
	}
	public void setChassis(String chassis) {
		this.chassis = chassis;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public boolean isIsformat() {
		return isformat;
	}
	public void setIsformat(boolean isformat) {
		this.isformat = isformat;
	}
	public boolean isIsgrad() {
		return isgrad;
	}
	public void setIsgrad(boolean isgrad) {
		this.isgrad = isgrad;
	}
	public boolean isIsmatch() {
		return ismatch;
	}
	public void setIsmatch(boolean ismatch) {
		this.ismatch = ismatch;
	}
	public boolean isIsmastop() {
		return ismastop;
	}
	public void setIsmastop(boolean ismastop) {
		this.ismastop = ismastop;
	}
	
	@Override
	public String toString() {
		return "BatteryInfoBean [id=" + id + ", no=" + no + ", chassis=" + chassis + ", channel=" + channel
				+ ", module=" + module + ", isformat=" + isformat + ", isgrad=" + isgrad + ", ismatch=" + ismatch
				+ ", ismastop=" + ismastop + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((no == null) ? 0 : no.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BatteryInfo other = (BatteryInfo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (no == null) {
			if (other.no != null)
				return false;
		} else if (!no.equals(other.no))
			return false;
		return true;
	}
	
	
}

