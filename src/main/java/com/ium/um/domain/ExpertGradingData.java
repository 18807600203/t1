package com.ium.um.domain;

import java.io.Serializable;
import java.util.List;

public class ExpertGradingData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ExpertGradingTableData> tableValuesList;
	
	
	public List<ExpertGradingTableData> getTableValuesList() {
		return tableValuesList;
	}
	
	public void setTableValuesList(List<ExpertGradingTableData> tableValuesList) {
		this.tableValuesList = tableValuesList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tableValuesList == null) ? 0 : tableValuesList.hashCode());
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
		ExpertGradingData other = (ExpertGradingData) obj;
		if (tableValuesList == null) {
			if (other.tableValuesList != null)
				return false;
		} else if (!tableValuesList.equals(other.tableValuesList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ExpertGradingData [tableValuesList=" + tableValuesList + "]";
	}
	
	
}

