package com.mju.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mju.app.dao.InputDao;
import com.mju.app.dao.ProjectDao;
import com.mju.app.domain.Input;
import com.mju.app.domain.Project;

@Service
public class InputServiceImpl implements InputService {
	private static final Logger logger = LoggerFactory.getLogger(Input.class);

	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private InputDao inputDao;
	
	@Override
	public List<Input> getAllInputs() {
		List<Input> inputList = this.inputDao.getAllInputs();
		
		/*for(Input input : inputList) {
			input.setCusotmer(this.inputDao.getCustomer(input.getCusId()));
		}*/
		
		return inputList;
	}
	
	@Override
	public List<Input> getInput(int prjId) {
		logger.info("InputService IN==>" + prjId);

		List<Input> input = this.inputDao.getInput(prjId);
//		input.setCusotmer(this.customerDao.getCustomer(input.getCusId()));
		
		return input;
	}
}
