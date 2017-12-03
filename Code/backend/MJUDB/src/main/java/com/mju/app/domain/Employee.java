package com.mju.app.domain;

import lombok.Data;

@Data
public class Employee {
	int empId;
	int deptId;
	String empName;
	String employeeRrn;
	String empEdu;
	String empEmail;
	String pass;
	
	Department department;
}
