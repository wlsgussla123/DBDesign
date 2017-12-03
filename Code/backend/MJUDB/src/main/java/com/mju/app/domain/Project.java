package com.mju.app.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class Project {
	int prjId;
	int cusId;
	String prjName;
	Date prjStartDate;
	Date prjEndDate;
	
	Customer customer;
}
