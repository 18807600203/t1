package com.ium.um.domain;

import java.io.Serializable;
import java.util.Vector;

import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelTarget;

import com.ium.um.core.kmeans.KmeanField;

@ExcelTarget("MatchData")
public class MatchData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Excel(name = "序号")
	private String rowid;//行号
	
	private Long id;//电池ID
	
	@Excel(name = "位号")
	private String p;//位号
	
	@Excel(name = "编号")
	private String no;//编号
	
	@Excel(name = "等级分类")
	private String classGroup;//等级分类
	
	@Excel(name = "配对分类")
	private String matchGroup;//配对分类
	
	@Excel(name = "开路电压")
	@KmeanField
	private double ocv;//开路电压
	
	@Excel(name = "平均电压")
	@KmeanField
	private double avgu;//平均电压
	
	@Excel(name = "终止电压")
	@KmeanField
	private double finalu;//终止电压
	
	@Excel(name = "终止电流")
	@KmeanField
	private double finali;//终止电流
	
	@Excel(name = "终止容量")
	@KmeanField
	private double maxc;//终止容量
	
	@Excel(name = "容量差")
	@KmeanField
	private double difc;//容量差
		
	@Excel(name = "放电完成时间")
	@KmeanField
	private double t;//放电完成时间
	
	@KmeanField
	@Excel(name = "特征放电电压时间点1")
	private double t1;//特征放电电压的是时间
	
	@Excel(name = "特征放电电压时间点1")
	@KmeanField
	private double t2;//特征放电电压的是时间
	
	@Excel(name = "特征放电电压时间点1")
	@KmeanField
	private double t3;//特征放电电压的是时间

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
		return no;
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

	public String getMatchGroup() {
		return matchGroup;
	}

	public void setMatchGroup(String matchGroup) {
		this.matchGroup = matchGroup;
	}

	public double getOcv() {
		return ocv;
	}

	public void setOcv(double ocv) {
		this.ocv = ocv;
	}

	public double getAvgu() {
		return avgu;
	}

	public void setAvgu(double avgu) {
		this.avgu = avgu;
	}

	public double getFinalu() {
		return finalu;
	}

	public void setFinalu(double finalu) {
		this.finalu = finalu;
	}

	public double getFinali() {
		return finali;
	}

	public void setFinali(double finali) {
		this.finali = finali;
	}

	public double getMaxc() {
		return maxc;
	}

	public void setMaxc(double maxc) {
		this.maxc = maxc;
	}

	public double getDifc() {
		return difc;
	}

	public void setDifc(double difc) {
		this.difc = difc;
	}

	public double getT() {
		return t;
	}

	public void setT(double t) {
		this.t = t;
	}

	public double getT1() {
		return t1;
	}

	public void setT1(double t1) {
		this.t1 = t1;
	}

	public double getT2() {
		return t2;
	}

	public void setT2(double t2) {
		this.t2 = t2;
	}

	public double getT3() {
		return t3;
	}

	public void setT3(double t3) {
		this.t3 = t3;
	}	
	
	@Override
	public String toString() {
		return "MatchData [rowid=" + rowid + ", id=" + id + ", p=" + p + ", no=" + no + ", classGroup=" + classGroup
				+ ", matchGroup=" + matchGroup + ", ocv=" + ocv + ", avgu=" + avgu + ", finalu=" + finalu + ", finali="
				+ finali + ", maxc=" + maxc + ", difc=" + difc + ", t=" + t + ", t1=" + t1 + ", t2=" + t2 + ", t3=" + t3
				+ "]";
	}

	public Vector<String> toVector(){
		
		Vector<String> v = new Vector<String>();
		//rowid, id, p, no, ocv, avgu,finalu, finali, maxc, difc, t, t1, t2,t3
		//序号, 位号, 编号, 等级名, 容量, 时间, 开压, 均压, 终压, 容量差, 终流, 点1时间, 点2时间, 点3时间
		v.add( this.rowid);
		v.add( this.p);
		v.add(this.no == null ? "" : no);
		v.add(this.classGroup);
		v.add(this.matchGroup);
		v.add(Double.toString( this.maxc));
		v.add(Double.toString( this.t));
		v.add(Double.toString( this.ocv));
		v.add(Double.toString( this.avgu));
		v.add(Double.toString( this.finalu));
		v.add(Double.toString( this.difc));
		v.add(Double.toString( this.finali));
		v.add(Double.toString( this.t1));
		v.add(Double.toString( this.t2));
		v.add(Double.toString( this.t3));
	
		return v;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(avgu);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((classGroup == null) ? 0 : classGroup.hashCode());
		temp = Double.doubleToLongBits(difc);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(finali);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(finalu);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((matchGroup == null) ? 0 : matchGroup.hashCode());
		temp = Double.doubleToLongBits(maxc);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((no == null) ? 0 : no.hashCode());
		temp = Double.doubleToLongBits(ocv);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((p == null) ? 0 : p.hashCode());
		result = prime * result + ((rowid == null) ? 0 : rowid.hashCode());
		temp = Double.doubleToLongBits(t);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(t1);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(t2);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(t3);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		MatchData other = (MatchData) obj;
		if (Double.doubleToLongBits(avgu) != Double.doubleToLongBits(other.avgu))
			return false;
		if (classGroup == null) {
			if (other.classGroup != null)
				return false;
		} else if (!classGroup.equals(other.classGroup))
			return false;
		if (Double.doubleToLongBits(difc) != Double.doubleToLongBits(other.difc))
			return false;
		if (Double.doubleToLongBits(finali) != Double.doubleToLongBits(other.finali))
			return false;
		if (Double.doubleToLongBits(finalu) != Double.doubleToLongBits(other.finalu))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (matchGroup == null) {
			if (other.matchGroup != null)
				return false;
		} else if (!matchGroup.equals(other.matchGroup))
			return false;
		if (Double.doubleToLongBits(maxc) != Double.doubleToLongBits(other.maxc))
			return false;
		if (no == null) {
			if (other.no != null)
				return false;
		} else if (!no.equals(other.no))
			return false;
		if (Double.doubleToLongBits(ocv) != Double.doubleToLongBits(other.ocv))
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
		if (Double.doubleToLongBits(t) != Double.doubleToLongBits(other.t))
			return false;
		if (Double.doubleToLongBits(t1) != Double.doubleToLongBits(other.t1))
			return false;
		if (Double.doubleToLongBits(t2) != Double.doubleToLongBits(other.t2))
			return false;
		if (Double.doubleToLongBits(t3) != Double.doubleToLongBits(other.t3))
			return false;
		return true;
	}

	
}
