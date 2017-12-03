package com.mju.app.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.mju.app.domain.Customer;

public interface CustomerService {
	List<Customer> getAllCustomers();
	Customer getCustomer(int id);
}
