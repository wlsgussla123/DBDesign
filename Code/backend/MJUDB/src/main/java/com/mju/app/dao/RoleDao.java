package com.mju.app.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mju.app.domain.Role;

@Repository
@Transactional
public class RoleDao {
	private final String NAMESPACE = "com.mju.app.mapper.RoleMapper.";

	@Autowired
	private SqlSessionTemplate sqlSession;

	public List<Role> getAllRoles() {
		return this.sqlSession.selectList(NAMESPACE + "getAllRoles");
	}
	
	public Role getRole(int id) {
		return this.sqlSession.selectOne(NAMESPACE + "getRole", id);
	}
	
}
