package com.ium.um.domain.step;

public class SafeValueData {

	/**
	 * 循环次数
	 */
	private int loopCount;
	
	/**
	 * 容量阈值
	 */
	private int cThreshold;

	public SafeValueData(){
		
	}
	
	public SafeValueData(int loopCount, int cThreshold) {
		
		this.loopCount = loopCount;
		this.cThreshold = cThreshold;
	}

	public int getLoopCount() {
		return loopCount;
	}

	public void setLoopCount(int loopCount) {
		this.loopCount = loopCount;
	}

	public int getcThreshold() {
		return cThreshold;
	}

	public void setcThreshold(int cThreshold) {
		this.cThreshold = cThreshold;
	}

	@Override
	public String toString() {
		return "SafeValueData [loopCount=" + loopCount + ", cThreshold=" + cThreshold + "]";
	}
	
	
}
