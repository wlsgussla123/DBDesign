package com.mju.app.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mju.app.domain.Input;

@Repository
@Transactional
public class InputDao {

	private static final Logger logger = LoggerFactory.getLogger(Input.class);
	private final String NAMESPACE = "com.mju.app.mapper.InputMapper.";

	@Autowired
	private SqlSessionTemplate sqlSession;

	public List<Input> getAllInputs() {
		return this.sqlSession.selectList(NAMESPACE + "getAllInputs");
	}
	
	public List<Input> getInputsByPrj(int prjId) {
    logger.info("inputDao ==>" + prjId);
		return this.sqlSession.selectList(NAMESPACE + "getInputsByPrj", prjId);
	}
}
