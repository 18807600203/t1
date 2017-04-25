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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + finalILoop;
		result = prime * result + finalIStep;
		result = prime * result + maxCLoop;
		result = prime * result + maxCStep;
		result = prime * result + ocvLoop;
		result = prime * result + ocvStep;
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
		GradValueData other = (GradValueData) obj;
		if (finalILoop != other.finalILoop)
			return false;
		if (finalIStep != other.finalIStep)
			return false;
		if (maxCLoop != other.maxCLoop)
			return false;
		if (maxCStep != other.maxCStep)
			return false;
		if (ocvLoop != other.ocvLoop)
			return false;
		if (ocvStep != other.ocvStep)
			return false;
		return true;
	}

	
}
