package com.ium.um.domain.step;

public class TableValueData {

	/**
	 * 工步号
	 */
	private int no;
	
	/**
	 * 工步名称
	 */
	private String name;
	
	/**
	 * 时间
	 */
	private int time;
	
	/**
	 * 电流mV
	 */
	private int i;
	
	/**
	 * 下限电压
	 */
	private int minU;
	
	/**
	 * 上限电压
	 */
	private int maxU;
	
	/**
	 * 电压增量
	 */
	private int detaV;
	
	/**
	 * 终止电流
	 */
	private int finalI;
	
	/**
	 * 终止容量
	 */
	private int fianlC;

	public TableValueData(){
		
	}
	
	public TableValueData(int no, String name, int time, int i, int minU, int maxU, int detaV, int finalI, int fianlC) {
		
		this.no = no;
		this.name = name;
		this.time = time;
		this.i = i;
		this.minU = minU;
		this.maxU = maxU;
		this.detaV = detaV;
		this.finalI = finalI;
		this.fianlC = fianlC;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getMinU() {
		return minU;
	}

	public void setMinU(int minU) {
		this.minU = minU;
	}

	public int getMaxU() {
		return maxU;
	}

	public void setMaxU(int maxU) {
		this.maxU = maxU;
	}

	public int getDetaV() {
		return detaV;
	}

	public void setDetaV(int detaV) {
		this.detaV = detaV;
	}

	public int getFinalI() {
		return finalI;
	}

	public void setFinalI(int finalI) {
		this.finalI = finalI;
	}

	public int getFianlC() {
		return fianlC;
	}

	public void setFianlC(int fianlC) {
		this.fianlC = fianlC;
	}

	@Override
	public String toString() {
		return "TableValueData [no=" + no + ", name=" + name + ", time=" + time + ", i=" + i + ", minU=" + minU
				+ ", maxU=" + maxU + ", detaV=" + detaV + ", finalI=" + finalI + ", fianlC=" + fianlC + "]";
	}

	
}
