package com.mju.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mju.app.dao.InputDao;
import com.mju.app.domain.Input;

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
	public List<Input> getInputsByPrj(int prjId) {
		List<Input> inputs = this.inputDao.getInputsByPrj(prjId);
		return inputs;
	}

}
