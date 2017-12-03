package com.mju.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mju.app.dao.CustomerDao;
import com.mju.app.domain.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao;

	@Override
	public List<Customer> getAllCustomers() {
		return this.customerDao.getAllCustomers();
	}

	@Override
	public Customer getCustomer(int id) {
		return this.customerDao.getCustomer(id);
	}
}
