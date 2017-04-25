package com.ium.um.domain.step;

import java.util.List;

public class ChassisStepInfo {

	/**
	 * 机框编号
	 */
	private String no;
	
	/**
	 * 工步文件路径
	 */
	private String filePath;
	
	/**
	 * 工步信息表格
	 */
	private List<TableValueData> tableValueData;
	
	/**
	 * 安全参数
	 */
	private SafeValueData safeValueData;
	
	/**
	 * 分选条件
	 */
	private GradValueData gradValueData;
	
	/**
	 * 工步起始序号
	 */
	private StepFromToData stepFromToData;
	
	/**
	 * 工步信息表格二进制
	 */
	private List<byte[]> stepHexString;

	public ChassisStepInfo() {
		
	}

	public ChassisStepInfo(String no, String filePath, List<TableValueData> tableValueData, SafeValueData safeValueData,
			GradValueData gradValueData, StepFromToData stepFromToData, List<byte[]> stepHexString) {
		
		this.no = no;
		this.filePath = filePath;
		this.tableValueData = tableValueData;
		this.safeValueData = safeValueData;
		this.gradValueData = gradValueData;
		this.stepFromToData = stepFromToData;
		this.stepHexString = stepHexString;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public List<TableValueData> getTableValueData() {
		return tableValueData;
	}

	public void setTableValueData(List<TableValueData> tableValueData) {
		this.tableValueData = tableValueData;
	}

	public SafeValueData getSafeValueData() {
		return safeValueData;
	}

	public void setSafeValueData(SafeValueData safeValueData) {
		this.safeValueData = safeValueData;
	}

	public GradValueData getGradValueData() {
		return gradValueData;
	}

	public void setGradValueData(GradValueData gradValueData) {
		this.gradValueData = gradValueData;
	}

	public StepFromToData getStepFromToData() {
		return stepFromToData;
	}

	public void setStepFromToData(StepFromToData stepFromToData) {
		this.stepFromToData = stepFromToData;
	}

	public List<byte[]> getStepHexString() {
		return stepHexString;
	}

	public void setStepHexString(List<byte[]> stepHexString) {
		this.stepHexString = stepHexString;
	}

	@Override
	public String toString() {
		return "ChassisStepInfo [no=" + no + ", filePath=" + filePath + ", tableValueData=" + tableValueData
				+ ", safeValueData=" + safeValueData + ", gradValueData=" + gradValueData + ", stepFromToData="
				+ stepFromToData + ", stepHexString=" + stepHexString + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((filePath == null) ? 0 : filePath.hashCode());
		result = prime * result + ((gradValueData == null) ? 0 : gradValueData.hashCode());
		result = prime * result + ((no == null) ? 0 : no.hashCode());
		result = prime * result + ((safeValueData == null) ? 0 : safeValueData.hashCode());
		result = prime * result + ((stepFromToData == null) ? 0 : stepFromToData.hashCode());
		result = prime * result + ((stepHexString == null) ? 0 : stepHexString.hashCode());
		result = prime * result + ((tableValueData == null) ? 0 : tableValueData.hashCode());
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
		ChassisStepInfo other = (ChassisStepInfo) obj;
		if (filePath == null) {
			if (other.filePath != null)
				return false;
		} else if (!filePath.equals(other.filePath))
			return false;
		if (gradValueData == null) {
			if (other.gradValueData != null)
				return false;
		} else if (!gradValueData.equals(other.gradValueData))
			return false;
		if (no == null) {
			if (other.no != null)
				return false;
		} else if (!no.equals(other.no))
			return false;
		if (safeValueData == null) {
			if (other.safeValueData != null)
				return false;
		} else if (!safeValueData.equals(other.safeValueData))
			return false;
		if (stepFromToData == null) {
			if (other.stepFromToData != null)
				return false;
		} else if (!stepFromToData.equals(other.stepFromToData))
			return false;
		if (stepHexString == null) {
			if (other.stepHexString != null)
				return false;
		} else if (!stepHexString.equals(other.stepHexString))
			return false;
		if (tableValueData == null) {
			if (other.tableValueData != null)
				return false;
		} else if (!tableValueData.equals(other.tableValueData))
			return false;
		return true;
	}

	
	
}
