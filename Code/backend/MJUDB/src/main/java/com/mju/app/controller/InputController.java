package com.mju.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mju.app.domain.Input;
import com.mju.app.service.InputService;

@Controller
@RequestMapping("/input")
public class InputController {
//	private static final Logger logger = LoggerFactory.getLogger(Input.class);
	
	@Autowired
	private InputService inputService;

	@RequestMapping(value = "")
	public @ResponseBody List<Input> getAllInputs() {
		return this.inputService.getAllInputs();
	}

}
