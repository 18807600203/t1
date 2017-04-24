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


	
}
