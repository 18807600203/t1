package com.ium.um.domain.grading;

import java.io.Serializable;

public class ExpertGradingValues implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String rowid;//行号
	private Long id;//电池ID
	private String p;//电池位号
	private String no;//电池编号
	private String classGroup;//等级分类
	private String ocv;//开路电压
	private String avgu;//平均电压
	private String finalu;//终止电压
	private String finali;//终止电流
	private String maxc;//终止容量
	private String difc;//容量差
	private String t;//放电完成时间
	private String t1;//特征电压时间点1
	private String t2;//特征电压时间点2
	private String t3;//特征电压时间点3
	
	
	public String getRowid() {
		return rowid;
	}
	
	public void setRowid(String rowid) {
		this.rowid = rowid;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getP() {
		return p;
	}
	
	public void setP(String p) {
		this.p = p;
	}
	
	public String getNo() {
		return no == null ? "" : no;
	}
	
	public void setNo(String no) {
		this.no = no;
	}
	
	public String getClassGroup() {
		return classGroup;
	}
	
	public void setClassGroup(String classGroup) {
		this.classGroup = classGroup;
	}
	
	public String getOcv() {
		return ocv == null ? "0" : ocv;
	}
	
	public void setOcv(String ocv) {
		this.ocv = ocv;
	}
	
	public String getAvgu() {
		return avgu == null ? "0" : avgu;
	}
	
	public void setAvgu(String avgu) {
		this.avgu = avgu;
	}
	
	public String getFinalu() {
		return finalu == null ? "0" : finalu;
	}
	
	public void setFinalu(String finalu) {
		this.finalu = finalu;
	}
	
	public String getFinali() {
		return finali == null ? "0" : finali;
	}
	
	public void setFinali(String finali) {
		this.finali = finali;
	}
	
	public String getMaxc() {
		return maxc == null ? "0" : maxc;
	}
	
	public void setMaxc(String maxc) {
		this.maxc = maxc;
	}
	
	public String getDifc() {
		return difc == null ? "0" : difc;
	}
	
	public void setDifc(String difc) {
		this.difc = difc;
	}
	
	public String getT() {
		return t == null ? "0" : t;
	}
	
	public void setT(String t) {
		this.t = t;
	}
	
	public String getT1() {
		return t1 == null ? "0" : t1;
	}
	
	public void setT1(String t1) {
		this.t1 = t1;
	}
	
	public String getT2() {
		return t2 == null ? "0" : t2;
	}
	
	public void setT2(String t2) {
		this.t2 = t2;
	}
	
	public String getT3() {
		return t3 == null ? "0" : t3;
	}
	
	public void setT3(String t3) {
		this.t3 = t3;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((avgu == null) ? 0 : avgu.hashCode());
		result = prime * result + ((classGroup == null) ? 0 : classGroup.hashCode());
		result = prime * result + ((difc == null) ? 0 : difc.hashCode());
		result = prime * result + ((finali == null) ? 0 : finali.hashCode());
		result = prime * result + ((finalu == null) ? 0 : finalu.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((maxc == null) ? 0 : maxc.hashCode());
		result = prime * result + ((no == null) ? 0 : no.hashCode());
		result = prime * result + ((ocv == null) ? 0 : ocv.hashCode());
		result = prime * result + ((p == null) ? 0 : p.hashCode());
		result = prime * result + ((rowid == null) ? 0 : rowid.hashCode());
		result = prime * result + ((t == null) ? 0 : t.hashCode());
		result = prime * result + ((t1 == null) ? 0 : t1.hashCode());
		result = prime * result + ((t2 == null) ? 0 : t2.hashCode());
		result = prime * result + ((t3 == null) ? 0 : t3.hashCode());
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
		ExpertGradingValues other = (ExpertGradingValues) obj;
		if (avgu == null) {
			if (other.avgu != null)
				return false;
		} else if (!avgu.equals(other.avgu))
			return false;
		if (classGroup == null) {
			if (other.classGroup != null)
				return false;
		} else if (!classGroup.equals(other.classGroup))
			return false;
		if (difc == null) {
			if (other.difc != null)
				return false;
		} else if (!difc.equals(other.difc))
			return false;
		if (finali == null) {
			if (other.finali != null)
				return false;
		} else if (!finali.equals(other.finali))
			return false;
		if (finalu == null) {
			if (other.finalu != null)
				return false;
		} else if (!finalu.equals(other.finalu))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (maxc == null) {
			if (other.maxc != null)
				return false;
		} else if (!maxc.equals(other.maxc))
			return false;
		if (no == null) {
			if (other.no != null)
				return false;
		} else if (!no.equals(other.no))
			return false;
		if (ocv == null) {
			if (other.ocv != null)
				return false;
		} else if (!ocv.equals(other.ocv))
			return false;
		if (p == null) {
			if (other.p != null)
				return false;
		} else if (!p.equals(other.p))
			return false;
		if (rowid == null) {
			if (other.rowid != null)
				return false;
		} else if (!rowid.equals(other.rowid))
			return false;
		if (t == null) {
			if (other.t != null)
				return false;
		} else if (!t.equals(other.t))
			return false;
		if (t1 == null) {
			if (other.t1 != null)
				return false;
		} else if (!t1.equals(other.t1))
			return false;
		if (t2 == null) {
			if (other.t2 != null)
				return false;
		} else if (!t2.equals(other.t2))
			return false;
		if (t3 == null) {
			if (other.t3 != null)
				return false;
		} else if (!t3.equals(other.t3))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ExpertGradingValues [rowid=" + rowid + ", id=" + id + ", p=" + p + ", no=" + no + ", classGroup="
				+ classGroup + ", ocv=" + ocv + ", avgu=" + avgu + ", finalu=" + finalu + ", finali=" + finali
				+ ", maxc=" + maxc + ", difc=" + difc + ", t=" + t + ", t1=" + t1 + ", t2=" + t2 + ", t3=" + t3 + "]";
	}
	
	
}
