package com.ium.um.domain.grading;

import java.io.Serializable;
import java.util.List;
import java.util.Vector;

public class ExpertGradingTableData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int no;//序号
	private String classStr;//等级分类
	private String minTime;//时间
	private String maxTime;
	private float minC;//容量
	private float maxC;
	private float min_ocv_u;//开路电压
	private float max_ocv_u;
	private float min_avg_u;//平均电压
	private float max_avg_u;
	private float minU;//最终电压
	private float maxU;
	private float min_dif_c;//容量差
	private float max_dif_c;
	private int minI;//终止电流
	private int maxI;
	private String min_point_1_time;//点1时间
	private String max_point_1_time;
	private String min_point_2_time;//点2时间
	private String max_point_2_time;
	private String min_point_3_time;//点3时间
	private String max_point_3_time;
	
	
	public void setValues(List<String> tableV){
		
		this.no = Integer.valueOf(tableV.get(0));//序号
		this.classStr = tableV.get(1);//等级分类
		this.minTime = tableV.get(2);//时间
		this.maxTime = tableV.get(3);
		this.minC = Float.valueOf( tableV.get(4));//容量
		this.maxC = Float.valueOf( tableV.get(5));
		this.min_ocv_u = Float.valueOf( tableV.get(6));//开路电压
		this.max_ocv_u = Float.valueOf( tableV.get(7));
		this.min_avg_u = Float.valueOf( tableV.get(8));//平均电压
		this.max_avg_u = Float.valueOf( tableV.get(9));
		this.minU = Float.valueOf( tableV.get(10));//最终电压
		this.maxU = Float.valueOf( tableV.get(11));
		this.min_dif_c = Float.valueOf( tableV.get(12));//容量差
		this.max_dif_c = Float.valueOf( tableV.get(13));
		this.minI = Integer.valueOf( tableV.get(14));//终止电流
		this.maxI = Integer.valueOf( tableV.get(15));
		this.min_point_1_time = tableV.get(16);//点1时间
		this.max_point_1_time = tableV.get(17);
		this.min_point_2_time = tableV.get(18);//点2时间
		this.max_point_2_time = tableV.get(19);
		this.min_point_3_time = tableV.get(20);//点3时间
		this.max_point_3_time = tableV.get(21);
		
	}
	
	public Vector<String> getValues(){
		
		Vector<String> v = new Vector<>();
		v.add( Integer.toString(this.no));
		v.add(this.classStr);
		v.add(this.minTime);
		v.add(this.maxTime);
		v.add(Float.toString( this.minC));
		v.add(Float.toString( this.maxC));
		v.add(Float.toString( this.min_ocv_u));
		v.add(Float.toString( this.min_ocv_u));
		v.add(Float.toString( this.min_avg_u));
		v.add(Float.toString( this.max_avg_u));
		v.add(Float.toString( this.minU));
		v.add(Float.toString( this.maxU));
		v.add(Float.toString( this.min_dif_c));
		v.add(Float.toString( this.max_dif_c));
		v.add(Integer.toString( this.minI));
		v.add(Integer.toString( this.maxI));
		v.add(this.min_point_1_time);
		v.add(this.max_point_1_time);
		v.add(this.min_point_2_time);
		v.add(this.max_point_2_time);
		v.add(this.min_point_3_time);
		v.add(this.max_point_3_time);
		
		return v;
	}
	
	
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public String getClassStr() {
		return classStr;
	}
	
	public void setClassStr(String classStr) {
		this.classStr = classStr;
	}
	
	public String getMinTime() {
		return minTime;
	}
	
	public void setMinTime(String minTime) {
		this.minTime = minTime;
	}
	
	public String getMaxTime() {
		return maxTime;
	}
	
	public void setMaxTime(String maxTime) {
		this.maxTime = maxTime;
	}
	
	public float getMinC() {
		return minC;
	}
	
	public void setMinC(float minC) {
		this.minC = minC;
	}
	
	public float getMaxC() {
		return maxC;
	}
	
	public void setMaxC(float maxC) {
		this.maxC = maxC;
	}
	
	public float getMin_ocv_u() {
		return min_ocv_u;
	}
	
	public void setMin_ocv_u(float min_ocv_u) {
		this.min_ocv_u = min_ocv_u;
	}
	
	public float getMax_ocv_u() {
		return max_ocv_u;
	}
	
	public void setMax_ocv_u(float max_ocv_u) {
		this.max_ocv_u = max_ocv_u;
	}
	
	public float getMin_avg_u() {
		return min_avg_u;
	}
	
	public void setMin_avg_u(float min_avg_u) {
		this.min_avg_u = min_avg_u;
	}
	
	public float getMax_avg_u() {
		return max_avg_u;
	}
	
	public void setMax_avg_u(float max_avg_u) {
		this.max_avg_u = max_avg_u;
	}
	
	public float getMinU() {
		return minU;
	}
	
	public void setMinU(float minU) {
		this.minU = minU;
	}
	
	public float getMaxU() {
		return maxU;
	}
	
	public void setMaxU(float maxU) {
		this.maxU = maxU;
	}
	
	public float getMin_dif_c() {
		return min_dif_c;
	}
	
	public void setMin_dif_c(float min_dif_c) {
		this.min_dif_c = min_dif_c;
	}
	
	public float getMax_dif_c() {
		return max_dif_c;
	}
	
	public void setMax_dif_c(float max_dif_c) {
		this.max_dif_c = max_dif_c;
	}
	
	public int getMinI() {
		return minI;
	}
	
	public void setMinI(int minI) {
		this.minI = minI;
	}
	
	public int getMaxI() {
		return maxI;
	}
	
	public void setMaxI(int maxI) {
		this.maxI = maxI;
	}
	
	public String getMin_point_1_time() {
		return min_point_1_time;
	}
	
	public void setMin_point_1_time(String min_point_1_time) {
		this.min_point_1_time = min_point_1_time;
	}
	
	public String getMax_point_1_time() {
		return max_point_1_time;
	}
	
	public void setMax_point_1_time(String max_point_1_time) {
		this.max_point_1_time = max_point_1_time;
	}
	
	public String getMin_point_2_time() {
		return min_point_2_time;
	}
	
	public void setMin_point_2_time(String min_point_2_time) {
		this.min_point_2_time = min_point_2_time;
	}
	
	public String getMax_point_2_time() {
		return max_point_2_time;
	}
	
	public void setMax_point_2_time(String max_point_2_time) {
		this.max_point_2_time = max_point_2_time;
	}
	
	public String getMin_point_3_time() {
		return min_point_3_time;
	}
	
	public void setMin_point_3_time(String min_point_3_time) {
		this.min_point_3_time = min_point_3_time;
	}
	
	public String getMax_point_3_time() {
		return max_point_3_time;
	}
	
	public void setMax_point_3_time(String max_point_3_time) {
		this.max_point_3_time = max_point_3_time;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classStr == null) ? 0 : classStr.hashCode());
		result = prime * result + Float.floatToIntBits(maxC);
		result = prime * result + maxI;
		result = prime * result + ((maxTime == null) ? 0 : maxTime.hashCode());
		result = prime * result + Float.floatToIntBits(maxU);
		result = prime * result + Float.floatToIntBits(max_avg_u);
		result = prime * result + Float.floatToIntBits(max_dif_c);
		result = prime * result + Float.floatToIntBits(max_ocv_u);
		result = prime * result + ((max_point_1_time == null) ? 0 : max_point_1_time.hashCode());
		result = prime * result + ((max_point_2_time == null) ? 0 : max_point_2_time.hashCode());
		result = prime * result + ((max_point_3_time == null) ? 0 : max_point_3_time.hashCode());
		result = prime * result + Float.floatToIntBits(minC);
		result = prime * result + minI;
		result = prime * result + ((minTime == null) ? 0 : minTime.hashCode());
		result = prime * result + Float.floatToIntBits(minU);
		result = prime * result + Float.floatToIntBits(min_avg_u);
		result = prime * result + Float.floatToIntBits(min_dif_c);
		result = prime * result + Float.floatToIntBits(min_ocv_u);
		result = prime * result + ((min_point_1_time == null) ? 0 : min_point_1_time.hashCode());
		result = prime * result + ((min_point_2_time == null) ? 0 : min_point_2_time.hashCode());
		result = prime * result + ((min_point_3_time == null) ? 0 : min_point_3_time.hashCode());
		result = prime * result + no;
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
		ExpertGradingTableData other = (ExpertGradingTableData) obj;
		if (classStr == null) {
			if (other.classStr != null)
				return false;
		} else if (!classStr.equals(other.classStr))
			return false;
		if (Float.floatToIntBits(maxC) != Float.floatToIntBits(other.maxC))
			return false;
		if (maxI != other.maxI)
			return false;
		if (maxTime == null) {
			if (other.maxTime != null)
				return false;
		} else if (!maxTime.equals(other.maxTime))
			return false;
		if (Float.floatToIntBits(maxU) != Float.floatToIntBits(other.maxU))
			return false;
		if (Float.floatToIntBits(max_avg_u) != Float.floatToIntBits(other.max_avg_u))
			return false;
		if (Float.floatToIntBits(max_dif_c) != Float.floatToIntBits(other.max_dif_c))
			return false;
		if (Float.floatToIntBits(max_ocv_u) != Float.floatToIntBits(other.max_ocv_u))
			return false;
		if (max_point_1_time == null) {
			if (other.max_point_1_time != null)
				return false;
		} else if (!max_point_1_time.equals(other.max_point_1_time))
			return false;
		if (max_point_2_time == null) {
			if (other.max_point_2_time != null)
				return false;
		} else if (!max_point_2_time.equals(other.max_point_2_time))
			return false;
		if (max_point_3_time == null) {
			if (other.max_point_3_time != null)
				return false;
		} else if (!max_point_3_time.equals(other.max_point_3_time))
			return false;
		if (Float.floatToIntBits(minC) != Float.floatToIntBits(other.minC))
			return false;
		if (minI != other.minI)
			return false;
		if (minTime == null) {
			if (other.minTime != null)
				return false;
		} else if (!minTime.equals(other.minTime))
			return false;
		if (Float.floatToIntBits(minU) != Float.floatToIntBits(other.minU))
			return false;
		if (Float.floatToIntBits(min_avg_u) != Float.floatToIntBits(other.min_avg_u))
			return false;
		if (Float.floatToIntBits(min_dif_c) != Float.floatToIntBits(other.min_dif_c))
			return false;
		if (Float.floatToIntBits(min_ocv_u) != Float.floatToIntBits(other.min_ocv_u))
			return false;
		if (min_point_1_time == null) {
			if (other.min_point_1_time != null)
				return false;
		} else if (!min_point_1_time.equals(other.min_point_1_time))
			return false;
		if (min_point_2_time == null) {
			if (other.min_point_2_time != null)
				return false;
		} else if (!min_point_2_time.equals(other.min_point_2_time))
			return false;
		if (min_point_3_time == null) {
			if (other.min_point_3_time != null)
				return false;
		} else if (!min_point_3_time.equals(other.min_point_3_time))
			return false;
		if (no != other.no)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ExpertGradingTableData [no=" + no + ", classStr=" + classStr + ", minTime=" + minTime + ", maxTime="
				+ maxTime + ", minC=" + minC + ", maxC=" + maxC + ", min_ocv_u=" + min_ocv_u + ", max_ocv_u="
				+ max_ocv_u + ", min_avg_u=" + min_avg_u + ", max_avg_u=" + max_avg_u + ", minU=" + minU + ", maxU="
				+ maxU + ", min_dif_c=" + min_dif_c + ", max_dif_c=" + max_dif_c + ", minI=" + minI + ", maxI=" + maxI
				+ ", min_point_1_time=" + min_point_1_time + ", max_point_1_time=" + max_point_1_time
				+ ", min_point_2_time=" + min_point_2_time + ", max_point_2_time=" + max_point_2_time
				+ ", min_point_3_time=" + min_point_3_time + ", max_point_3_time=" + max_point_3_time + "]";
	}

	
}
