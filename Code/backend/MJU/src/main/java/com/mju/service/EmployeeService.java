package com.mju.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mju.domain.Employee;

@Service
public interface EmployeeService {
	Employee getEmployee(int id);

	List<Employee> getAllEmployees();
}
