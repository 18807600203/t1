package com.ium.um.domain.battery;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Vector;

/**
 * 电池的基本信息Bean 对应数据库的base表
 */
public class BatteryDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String no;
	private String chassis;
	private String channel;
	private String module;
	private boolean isformat;
	private boolean isgrad;
	private boolean ismatch;
	private boolean ismastop;
	private String sfile;
	private String sftimesign;//SFTIMESIGN
	private String groupclass;
	private String gradtimesign;//GRADTIMESIGN
	private String gradf;

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
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
	
	public boolean getIsformat() {
		return isformat;
	}
	public void setIsformat(boolean isformat) {
		this.isformat = isformat;
	}
	
	public boolean getIsgrad() {
		return isgrad;
	}
	
	public void setIsgrad(boolean isgrad) {
		this.isgrad = isgrad;
	}
	
	public boolean getIsmatch() {
		return ismatch;
	}
	
	public void setIsmatch(boolean ismatch) {
		this.ismatch = ismatch;
	}
	
	public boolean getIsmastop() {
		return ismastop;
	}
	
	public void setIsmastop(boolean ismastop) {
		this.ismastop = ismastop;
	}
	
	public String getSfile() {
		return sfile;
	}
	
	public void setSfile(String sfile) {
		this.sfile = sfile;
	}
	
	public String getSftimesign() {
		return sftimesign;
	}
	
	public void setSftimesign(String sftimesign) {
		this.sftimesign = sftimesign;
	}
	
	public String getGroupclass() {
		return groupclass;
	}
	
	public void setGroupclass(String groupclass) {
		this.groupclass = groupclass;
	}
	
	public String getGradtimesign() {
		return gradtimesign;
	}
	
	public void setGradtimesign(String gradtimesign) {
		this.gradtimesign = gradtimesign;
	}

	public String getGradf() {
		return gradf;
	}

	public void setGradf(String gradf) {
		this.gradf = gradf;
	}
	
	
	public Vector<String> toVector() throws UnsupportedEncodingException{
		
		Vector<String> v = new Vector<>();
		v.add(this.id);
		v.add(this.no == null ? "" : this.no);
		v.add(this.chassis);
		v.add(this.channel);
		v.add(this.module);
		v.add(this.isformat == true ? "是" : "否");
		v.add(this.isgrad == true ? "是" : "否");
		v.add(this.ismatch == true ? "是" : "否");
		v.add(this.ismastop == true ? "是" : "否");
		v.add(this.sfile == null ? "" : this.sfile);
		//v.add(this.SFILE == null ? "" : new String(this.SFILE.getBytes("ISO-8859-1"), "UTF-8"));
		v.add(this.sftimesign == null ? "" :String.format("%tF %<tT", Long.valueOf(this.sftimesign)));
		v.add(this.groupclass == null ? "" : this.groupclass);
		v.add(this.gradf == null ? (this.groupclass == null ? "未分选" : "普通分选") : this.gradf);
		v.add(this.gradtimesign == null ? "" : String.format("%tF %<tT", Long.valueOf(this.gradtimesign)));	
		return v;
	}

	@Override
	public String toString() {
		return "BatteryDetailBean [ID=" + id + ", NO=" + no + ", chassis=" + chassis + ", CHANNEL=" + channel
				+ ", MODULE=" + module + ", ISFORMAT=" + isformat + ", ISGRAD=" + isgrad + ", ISMATCH=" + ismatch
				+ ", ISMASTOP=" + ismastop + ", SFILE=" + sfile + ", SFTIMESIGN=" + sftimesign + ", GROUPCLASS="
				+ groupclass + ", GRADTIMESIGN=" + gradtimesign + ", GRADF=" + gradf + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((channel == null) ? 0 : channel.hashCode());
		result = prime * result + ((gradf == null) ? 0 : gradf.hashCode());
		result = prime * result + ((gradtimesign == null) ? 0 : gradtimesign.hashCode());
		result = prime * result + ((groupclass == null) ? 0 : groupclass.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isformat ? 1231 : 1237);
		result = prime * result + (isgrad ? 1231 : 1237);
		result = prime * result + (ismastop ? 1231 : 1237);
		result = prime * result + (ismatch ? 1231 : 1237);
		result = prime * result + ((module == null) ? 0 : module.hashCode());
		result = prime * result + ((no == null) ? 0 : no.hashCode());
		result = prime * result + ((sfile == null) ? 0 : sfile.hashCode());
		result = prime * result + ((sftimesign == null) ? 0 : sftimesign.hashCode());
		result = prime * result + ((chassis == null) ? 0 : chassis.hashCode());
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
		BatteryDetail other = (BatteryDetail) obj;
		if (channel == null) {
			if (other.channel != null)
				return false;
		} else if (!channel.equals(other.channel))
			return false;
		if (gradf == null) {
			if (other.gradf != null)
				return false;
		} else if (!gradf.equals(other.gradf))
			return false;
		if (gradtimesign == null) {
			if (other.gradtimesign != null)
				return false;
		} else if (!gradtimesign.equals(other.gradtimesign))
			return false;
		if (groupclass == null) {
			if (other.groupclass != null)
				return false;
		} else if (!groupclass.equals(other.groupclass))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isformat != other.isformat)
			return false;
		if (isgrad != other.isgrad)
			return false;
		if (ismastop != other.ismastop)
			return false;
		if (ismatch != other.ismatch)
			return false;
		if (module == null) {
			if (other.module != null)
				return false;
		} else if (!module.equals(other.module))
			return false;
		if (no == null) {
			if (other.no != null)
				return false;
		} else if (!no.equals(other.no))
			return false;
		if (sfile == null) {
			if (other.sfile != null)
				return false;
		} else if (!sfile.equals(other.sfile))
			return false;
		if (sftimesign == null) {
			if (other.sftimesign != null)
				return false;
		} else if (!sftimesign.equals(other.sftimesign))
			return false;
		if (chassis == null) {
			if (other.chassis != null)
				return false;
		} else if (!chassis.equals(other.chassis))
			return false;
		return true;
	}
	
	
}
