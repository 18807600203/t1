package com.ium.um.domain;

import java.io.Serializable;

public class BasesfData implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long baseid;
	private String sfile;
	private String timesign;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getBaseid() {
		return baseid;
	}
	
	public void setBaseid(Long baseid) {
		this.baseid = baseid;
	}
	
	public String getSfile() {
		return sfile;
	}
	
	public void setSfile(String sfile) {
		this.sfile = sfile;
	}
	
	public String getTimesign() {
		return timesign;
	}
	
	public void setTimesign(String timesign) {
		this.timesign = timesign;
	}

	@Override
	public String toString() {
		return "BasesfData [id=" + id + ", baseid=" + baseid + ", sfile=" + sfile + ", timesign=" + timesign + "]";
	}
	
	
	
}
