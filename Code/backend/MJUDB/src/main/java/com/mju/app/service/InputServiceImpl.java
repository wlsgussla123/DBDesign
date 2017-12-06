package com.mju.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mju.app.dao.InputDao;
import com.mju.app.dao.ProjectDao;
import com.mju.app.domain.Input;
import com.mju.app.domain.Project;

@Service
public class InputServiceImpl implements InputService {
	@Autowired
	private InputDao inputDao;
	
	@Override
	public List<Input> getAllInputs() {
		List<Input> inputList = this.inputDao.getAllInputs();
		
		return inputList;
	}
	
	@Override
	public Input getInput(int prjId) {
		Input input = this.inputDao.getInput(prjId);
//		input.setCusotmer(this.customerDao.getCustomer(input.getCusId()));
		
		return input;
	}

}
