package com.ium.um.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class GradingData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String baseid;
	private String location;
	private BigDecimal cvalue;
	
	public String getBaseid() {
		return baseid;
	}
	
	public void setBaseid(String baseid) {
		this.baseid = baseid;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public BigDecimal getCvalue() {
		return cvalue;
	}
	
	public void setCvalue(BigDecimal cvalue) {
		this.cvalue = cvalue;
	}

	@Override
	public String toString() {
		return "GradingData [baseid=" + baseid + ", location=" + location + ", cvalue=" + cvalue + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((baseid == null) ? 0 : baseid.hashCode());
		result = prime * result + ((cvalue == null) ? 0 : cvalue.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
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
		GradingData other = (GradingData) obj;
		if (baseid == null) {
			if (other.baseid != null)
				return false;
		} else if (!baseid.equals(other.baseid))
			return false;
		if (cvalue == null) {
			if (other.cvalue != null)
				return false;
		} else if (!cvalue.equals(other.cvalue))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		return true;
	}
	
	
}
