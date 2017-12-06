package com.mju.app.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mju.app.domain.Evaluation;

@Repository
@Transactional
public class EvaluationDao {
	private final String NAMESPACE = "com.mju.app.mapper.EvaluationMapper.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<Evaluation> getAllEvaluations() {
		return this.sqlSession.selectList(NAMESPACE + "getAllEvaluations");
	}
}