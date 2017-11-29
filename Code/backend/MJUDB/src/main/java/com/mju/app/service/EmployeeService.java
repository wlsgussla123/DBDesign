package com.mju.app.service;

import com.mju.app.domain.Employee;

public interface EmployeeService {
	Employee getEmployee(int id);
	Employee loginEmployee(String empEmail, String pass);
}
