package com.mju.app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mju.app.dao.InputDao;
import com.mju.app.domain.Input;

@Service
public class InputServiceImpl implements InputService {
	private static final Logger logger = LoggerFactory.getLogger(Input.class);

	@Autowired
	private InputDao inputDao;
	
	@Override
	public List<Input> getAllInputs() {
		List<Input> inputList = this.inputDao.getAllInputs();
		return inputList;
	}
	
	@Override
	public List<Input> getInputsByPrj(int prjId) {
		logger.info("InputService IN==>" + prjId);
		List<Input> inputs = this.inputDao.getInputsByPrj(prjId);
		return inputs;
	}
}
