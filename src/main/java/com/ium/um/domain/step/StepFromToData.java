package com.ium.um.domain.step;

public class StepFromToData {

	/**
	 * 开始工步
	 */
	private int from;
	
	/**
	 * 结束工步
	 */
	private int to;

	public StepFromToData(){
		
	}
	
	public StepFromToData(int from, int to) {
		
		this.from = from;
		this.to = to;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	@Override
	public String toString() {
		return "StepFromToData [from=" + from + ", to=" + to + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + from;
		result = prime * result + to;
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
		StepFromToData other = (StepFromToData) obj;
		if (from != other.from)
			return false;
		if (to != other.to)
			return false;
		return true;
	}

	
	
}
