package com.mju.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mju.app.dao.RoleDao;
import com.mju.app.domain.Role;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;
	
	@Override
	public List<Role> getAllRoles() {
		List<Role> roleList = this.roleDao.getAllRoles();
		
		return roleList;
	}
	
	@Override
	public Role getRole(int id) {
		Role role = this.roleDao.getRole(id);
		
		return role;
	}

}
