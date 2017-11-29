package com.mju.app.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mju.app.domain.Employee;
import com.mju.app.service.EmployeeService;

@Controller
@RequestMapping("/login")
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public @ResponseBody Employee login(@RequestBody Map<String, Object> map) {
		logger.info("Login Controller IN==>" + map.get("empEmail"));
		logger.info("Login Controller IN==>" + map.get("pass"));
		
		String empEmail = map.get("empEmail").toString();
		String pass = map.get("pass").toString();
		Employee emp = this.employeeService.loginEmployee(empEmail, pass);
		
		return this.employeeService.loginEmployee(empEmail, pass);
	}
}
