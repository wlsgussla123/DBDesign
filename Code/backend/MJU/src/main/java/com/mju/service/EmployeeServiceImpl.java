package com.mju.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mju.dao.EmployeeDao;
import com.mju.domain.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao empDao;
	
	public Employee getEmployee(int id) {
		return this.empDao.getEmployee(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return this.empDao.getAllEmployees();
	}
}
