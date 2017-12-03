package com.mju.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mju.app.dao.CustomerDao;
import com.mju.app.dao.EmployeeDao;
import com.mju.app.dao.EvaluationDao;
import com.mju.app.dao.ProjectDao;
import com.mju.app.domain.Evaluation;

@Service
public class EvaluationServiceImpl implements EvaluationService {
	@Autowired
	private EvaluationDao evaluationDao;
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private CustomerDao customerDao;

	@Override
	public List<Evaluation> getAllEvaluations() {
		List<Evaluation> evaluationList = this.evaluationDao.getAllEvaluations();
		
		// 카테고리 분류에 따라서 평가자에 대한 정보 셋팅.
		for(Evaluation eval : evaluationList) {
			setSubject(eval);
			setProject(eval);
			setEvaluator(eval);
		}
		
		return evaluationList;
	}
	
	public void setSubject(Evaluation eval) {
		eval.setSubjectObj(this.employeeDao.getEmployee(eval.getSubject()));
	}
	
	public void setProject(Evaluation eval) {
		eval.setProjectObj(this.projectDao.getProject(eval.getPrjId()));
	}
	
	public void setEvaluator(Evaluation eval) {
		int category = eval.getEvalCategory(); // 카테고리
		int evalNum = eval.getEvaluator(); // 평가자 번호
		
		switch(category) {
		case 1:
		case 2:
			eval.setEvalEmpObj(this.employeeDao.getEmployee(evalNum));
			break;
		case 3:
			eval.setEvalCusObj(this.customerDao.getCustomer(evalNum));
			break;
		}		
	}
}
