package com.mju.app.service;

import java.util.List;

import com.mju.app.domain.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();
	Employee getEmployee(int id);
	Employee loginEmployee(String empEmail, String pass);
}
