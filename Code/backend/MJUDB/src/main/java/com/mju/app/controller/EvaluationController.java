package com.mju.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mju.app.domain.Evaluation;
import com.mju.app.service.EvaluationService;

@Controller
@RequestMapping("/evaluation")
public class EvaluationController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EvaluationService evaluationService;
	
	@RequestMapping(value = "")
	public @ResponseBody List<Evaluation> getAllEvaluations() {
		logger.info("getAllEvaluations IN==>");
		return this.evaluationService.getAllEvaluations();
	}
}
