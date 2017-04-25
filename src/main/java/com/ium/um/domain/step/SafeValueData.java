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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cThreshold;
		result = prime * result + loopCount;
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
		SafeValueData other = (SafeValueData) obj;
		if (cThreshold != other.cThreshold)
			return false;
		if (loopCount != other.loopCount)
			return false;
		return true;
	}
	
	
}
