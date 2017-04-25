package com.ium.um.domain.formation;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FormationData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("postition")
	private String position;
	@JsonProperty("u")
	private String u;
	@JsonProperty("i")
	private String i;
	@JsonProperty("c")
	private String c;
	@JsonProperty("t")
	private String t;
	@JsonProperty("t2")
	private String t2;
	@JsonProperty("r")
	private String r;
	@JsonProperty("status")
	private String status;
	@JsonProperty("errcode")
	private String errcode;
	@JsonProperty("step")
	private String step;
	

	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public String getU() {
		return u;
	}
	
	public void setU(String u) {
		this.u = u;
	}
	
	public String getI() {
		return i;
	}
	
	public void setI(String i) {
		this.i = i;
	}

	public String getC() {
		return c;
	}
	
	public void setC(String c) {
		this.c = c;
	}
	

	public String getT() {
		return t;
	}
	
	public void setT(String t) {
		this.t = t;
	}
	
	public String getT2() {
		return t2;
	}
	
	public void setT2(String t2) {
		this.t2 = t2;
	}
	
	public String getR() {
		return r;
	}
	
	public void setR(String r) {
		this.r = r;
	}
	
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public String getErrcode() {
		return errcode;
	}
	
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	
	
	public String getStep() {
		return step;
	}
	public void setStep(String step) {
		this.step = step;
	}

	@Override
	public String toString() {
		return "FormationDataBean [position=" + position + ", u=" + u + ", i=" + i + ", c=" + c + ", t=" + t + ", t2="
				+ t2 + ", r=" + r + ", status=" + status + ", errcode=" + errcode + ", step=" + step + "]";
	}

}
