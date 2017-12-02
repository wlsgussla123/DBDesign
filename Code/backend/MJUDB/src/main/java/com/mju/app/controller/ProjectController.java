package com.mju.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mju.app.domain.Project;
import com.mju.app.service.ProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value= "")
	public @ResponseBody List<Project> getAllProjects() {
		logger.info("PROJECT Controller IN==>");
		return this.projectService.getAllProjects();
	}
	
	@RequestMapping(value = "/{id}")
	public @ResponseBody Project getProject(@PathVariable int id) {
		logger.info("PROJECT Controller IN==>" + id);
		return this.projectService.getProject(id);
	}
	
	@RequestMapping(value ="/end")
	public @ResponseBody List<Project> getEndedProjects() {
		logger.info("PROJECT Controller IN==>");
		return this.projectService.getEndedProjects();
	}
}
	