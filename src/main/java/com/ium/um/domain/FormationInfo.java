package com.ium.um.domain;

import java.io.Serializable;

public class FormationInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String baseid;
	private FormationData dat_fm;
	private String instime;
	
	public String getBaseid() {
		return baseid;
	}
	
	public void setBaseid(String baseid) {
		this.baseid = baseid;
	}
	
	public FormationData getDat_fm() {
		return dat_fm;
	}
	
	public void setDat_fm(FormationData dat_fm) {
		this.dat_fm = dat_fm;
	}
	
	public String getInstime() {
		return instime;
	}
	
	public void setInstime(String instime) {
		this.instime = instime;
	}

	@Override
	public String toString() {
		return "FormationInfo [baseid=" + baseid + ", dat_fm=" + dat_fm + ", instime=" + instime + "]";
	}
	
	
}
