package com.mju.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mju.domain.Employee;

@Repository
@Transactional
public class EmployeeDao {
	private final String NAMESPACE = "mapper.EmployeeMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	public Employee getEmployee(int emp_id) {
		return this.sqlSession.selectOne(NAMESPACE + "getEmployee", emp_id);
	}

	public List<Employee> getAllEmployees() {
		return this.sqlSession.selectList(NAMESPACE + "getAllEmployees");
	}
}
