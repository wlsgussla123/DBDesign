package com.mju.domain;

import java.util.Date;

// PRJ_ID CUS_ID PRJ_NAME PRJ_START_DATE PRJ_END_DATE
public class Project {
	private int prjId;
	private int cusId;
	private String prjName;
	private Date prjStartDate;
	private Date prjEndDate;
	
	public Project() {}

	public int getPrjId() {
		return prjId;
	}

	public void setPrjId(int prjId) {
		this.prjId = prjId;
	}

	public int getCusId() {
		return cusId;
	}

	public void setCusId(int cusId) {
		this.cusId = cusId;
	}

	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}

	public Date getPrjStartDate() {
		return prjStartDate;
	}

	public void setPrjStartDate(Date prjStartDate) {
		this.prjStartDate = prjStartDate;
	}

	public Date getPrjEndDate() {
		return prjEndDate;
	}

	public void setPrjEndDate(Date prjEndDate) {
		this.prjEndDate = prjEndDate;
	}

	@Override
	public String toString() {
		return "Project [prjId=" + prjId + ", cusId=" + cusId + ", prjName=" + prjName + ", prjStartDate="
				+ prjStartDate + ", prjEndDate=" + prjEndDate + "]";
	}
}
