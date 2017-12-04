package com.mju.app.service;

import java.util.List;

import com.mju.app.domain.Employee;
import com.mju.app.domain.Input;

public interface InputService {
	List<Input> getAllInputs();
	Input getInput(int id);
}
