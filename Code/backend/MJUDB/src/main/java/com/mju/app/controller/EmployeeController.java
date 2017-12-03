package com.mju.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mju.app.HomeController;
import com.mju.app.domain.Employee;
import com.mju.app.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "")
	public @ResponseBody List<Employee> getAllEmployees() {
		return this.employeeService.getAllEmployees();
	}
	
	@RequestMapping(value = "/{id}")
	public @ResponseBody Employee getEmployee(@PathVariable int id) {
		logger.info("Controller IN==>" + id);
		return this.employeeService.getEmployee(id);
	}
}
