package com.mju.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mju.domain.Employee;
import com.mju.service.EmployeeService;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "*")
public class EmployeeController {
	@Autowired
	private EmployeeService empService;
	
	@RequestMapping(path ="/", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Employee> getAllEmployees() {
		return this.empService.getAllEmployees();
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Employee getEmployee(@PathVariable int id) {
		return this.empService.getEmployee(id);
	}
	
}
