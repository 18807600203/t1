package com.ium.um.domain.step;

public class GradValueData {

	/**
	 * 开路电压分选工步号
	 */
	private int ocvStep;
	
	/**
	 * 开路电压分选循环号
	 */
	private int ocvLoop;
	
	/**
	 * 终止容量分选工步号
	 */
	private int maxCStep;
	
	/**
	 * 终止容量分选循环号
	 */
	private int maxCLoop;
	
	/**
	 * 终止电流分选工步号
	 */
	private int finalIStep;
	
	/**
	 * 终止电流分选循环号
	 */
	private int finalILoop;
	
	public GradValueData() {
	
	}

	public GradValueData(int ocvStep, int ocvLoop, int maxCStep, int maxCLoop, int finalIStep, int finalILoop) {
		
		this.ocvStep = ocvStep;
		this.ocvLoop = ocvLoop;
		this.maxCStep = maxCStep;
		this.maxCLoop = maxCLoop;
		this.finalIStep = finalIStep;
		this.finalILoop = finalILoop;
	}

	public int getOcvStep() {
		return ocvStep;
	}

	public void setOcvStep(int ocvStep) {
		this.ocvStep = ocvStep;
	}

	public int getOcvLoop() {
		return ocvLoop;
	}

	public void setOcvLoop(int ocvLoop) {
		this.ocvLoop = ocvLoop;
	}

	public int getMaxCStep() {
		return maxCStep;
	}

	public void setMaxCStep(int maxCStep) {
		this.maxCStep = maxCStep;
	}

	public int getMaxCLoop() {
		return maxCLoop;
	}

	public void setMaxCLoop(int maxCLoop) {
		this.maxCLoop = maxCLoop;
	}

	public int getFinalIStep() {
		return finalIStep;
	}

	public void setFinalIStep(int finalIStep) {
		this.finalIStep = finalIStep;
	}

	public int getFinalILoop() {
		return finalILoop;
	}

	public void setFinalILoop(int finalILoop) {
		this.finalILoop = finalILoop;
	}

	@Override
	public String toString() {
		return "GradValueData [ocvStep=" + ocvStep + ", ocvLoop=" + ocvLoop + ", maxCStep=" + maxCStep + ", maxCLoop="
				+ maxCLoop + ", finalIStep=" + finalIStep + ", finalILoop=" + finalILoop + "]";
	}

	
}
