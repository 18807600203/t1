package com.ium.um.domain.formation;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

public class FormationData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String position;
	private String u;
	private String i;
	private String c;
	private String t;
	private String t2;
	private String r;
	private String status;
	private String errcode;
	private String step;
	
	@JSONField(name = "postition")
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	@JSONField(name = "u")
	public String getU() {
		return u;
	}
	
	public void setU(String u) {
		this.u = u;
	}
	
	@JSONField(name = "i")
	public String getI() {
		return i;
	}
	
	public void setI(String i) {
		this.i = i;
	}
	
	@JSONField(name = "c")
	public String getC() {
		return c;
	}
	
	public void setC(String c) {
		this.c = c;
	}
	
	@JSONField(name = "t")
	public String getT() {
		return t;
	}
	
	public void setT(String t) {
		this.t = t;
	}
	
	@JSONField(name = "t2")
	public String getT2() {
		return t2;
	}
	
	public void setT2(String t2) {
		this.t2 = t2;
	}
	@JSONField(name = "r")
	public String getR() {
		return r;
	}
	
	public void setR(String r) {
		this.r = r;
	}
	
	@JSONField(name = "status")
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	@JSONField(name = "errcode")
	public String getErrcode() {
		return errcode;
	}
	
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	
	@JSONField(name = "step")
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
