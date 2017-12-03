package com.mju.app.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mju.app.domain.Employee;

@Repository
@Transactional
public class EmployeeDao {
	private final String NAMESPACE = "com.mju.app.mapper.EmployeeMapper.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public List<Employee> getAllEmployees() {
		return this.sqlSession.selectList(NAMESPACE + "getAllEmployees");
	}
	
	public Employee getEmployee(int id) {
		return this.sqlSession.selectOne(NAMESPACE + "getEmployee", id);
	}

	public Employee loginEmployee(String empEmail, String pass) {
		Employee employee = new Employee();
		employee.setEmpEmail(empEmail);
		employee.setPass(pass);
		
		return this.sqlSession.selectOne(NAMESPACE + "loginEmployee", employee);
	}
}
