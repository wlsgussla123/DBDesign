package com.mju.app.service;

import java.util.List;

import com.mju.app.domain.Role;

public interface RoleService {
	Role getRole(int id);
	List<Role> getAllRoles();

}
