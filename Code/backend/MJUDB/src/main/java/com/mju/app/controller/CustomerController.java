package com.mju.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mju.app.domain.Customer;
import com.mju.app.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "")
	public @ResponseBody List<Customer> getAllCustomer() {
		logger.info("getAllCustomer Controller IN==>");
		return this.customerService.getAllCustomers();
	}
	
	@RequestMapping(value = "/{id}")
	public @ResponseBody Customer getCustomer(@PathVariable int id) {
		logger.info("getCustomer Controller IN==>" + id);
		return this.customerService.getCustomer(id);
	}
}
