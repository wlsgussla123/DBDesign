package com.mju.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mju.app.dao.CustomerDao;
import com.mju.app.dao.ProjectDao;
import com.mju.app.domain.Project;

@Service
public class ProjectServiceImple implements ProjectService {
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public List<Project> getAllProjects() {
		List<Project> projectList = this.projectDao.getAllProjects();
		for(Project project : projectList) {
			setCustomer(project);
		}
		
		return projectList;
	}
	
	@Override
	public Project getProject(int id) {
		Project project = this.projectDao.getProject(id);
		setCustomer(project);
		
		return project;
	}

	@Override
	public List<Project> getEndedProjects() {
		List<Project> projectList = this.projectDao.getEndedProjects();
		for(Project project : projectList) {
			setCustomer(project);
		}
		
		return projectList;
	}
	
	public void setCustomer(Project project) {
		project.setCustomer(this.customerDao.getCustomer(project.getCusId()));
	}
}
