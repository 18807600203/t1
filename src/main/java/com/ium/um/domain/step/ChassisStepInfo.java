package com.ium.um.domain.step;

import java.util.List;

public class ChassisStepInfo {

	/**
	 * 机框编号
	 */
	private int no;
	
	/**
	 * 工步文件路径
	 */
	private String filePath;
	
	/**
	 * 工步信息表格
	 */
	private List<TableValueData> tableValueDatas;
	
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

	public ChassisStepInfo(int no, String filePath, List<TableValueData> tableValueDatas, SafeValueData safeValueData,
			GradValueData gradValueData, StepFromToData stepFromToData, List<byte[]> stepHexString) {
		
		this.no = no;
		this.filePath = filePath;
		this.tableValueDatas = tableValueDatas;
		this.safeValueData = safeValueData;
		this.gradValueData = gradValueData;
		this.stepFromToData = stepFromToData;
		this.stepHexString = stepHexString;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public List<TableValueData> getTableValueData() {
		return tableValueDatas;
	}

	public void setTableValueData(List<TableValueData> tableValueData) {
		this.tableValueDatas = tableValueData;
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
		return "ChassisStepInfo [no=" + no + ", filePath=" + filePath + ", tableValueData=" + tableValueDatas
				+ ", safeValueData=" + safeValueData + ", gradValueData=" + gradValueData + ", stepFromToData="
				+ stepFromToData + ", stepHexString=" + stepHexString + "]";
	}

	
	
}
