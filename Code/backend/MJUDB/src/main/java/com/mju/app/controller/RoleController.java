package com.mju.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mju.app.domain.Role;
import com.mju.app.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
//	private static final Logger logger = LoggerFactory.getLogger(Input.class);
	
	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "")
	public @ResponseBody List<Role> getAllRoles() {
		return this.roleService.getAllRoles();
	}
	
	@RequestMapping(value = "/{id}")
	public @ResponseBody Role getRole(@PathVariable int id) {
//		logger.info("PROJECT Controller IN==>" + id);
		return this.roleService.getRole(id);
	}


}
