package com.mju.app.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mju.app.domain.Input;

@Repository
@Transactional
public class InputDao {
	private final String NAMESPACE = "com.mju.app.mapper.InputMapper.";

	@Autowired
	private SqlSessionTemplate sqlSession;

	public List<Input> getAllInputs() {
		return this.sqlSession.selectList(NAMESPACE + "getAllInputs");
	}
	
	public List<Input> getInputsByPrj(int prjId) {
		return this.sqlSession.selectList(NAMESPACE + "getInputsByPrj", prjId);
	}
	
}
