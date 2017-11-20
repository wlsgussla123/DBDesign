package com.mju.domain;

// CUS_ID CUS_NAME CUS_EMAIL
public class Customer {
	private int cusId;
	private String cusName;
	private String cusEmail;
	
	public Customer() {}

	public int getCusId() {
		return cusId;
	}

	public void setCusId(int cusId) {
		this.cusId = cusId;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getCusEmail() {
		return cusEmail;
	}

	public void setCusEmail(String cusEmail) {
		this.cusEmail = cusEmail;
	}

	@Override
	public String toString() {
		return "Customer [cusId=" + cusId + ", cusName=" + cusName + ", cusEmail=" + cusEmail + "]";
	}
}
