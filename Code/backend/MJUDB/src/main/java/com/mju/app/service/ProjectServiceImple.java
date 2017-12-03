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
			project.setCusotmer(this.customerDao.getCustomer(project.getCusId()));
		}
		
		return projectList;
	}
	
	@Override
	public Project getProject(int id) {
		Project project = this.projectDao.getProject(id);
		project.setCusotmer(this.customerDao.getCustomer(project.getCusId()));
		
		return project;
	}

	@Override
	public List<Project> getEndedProjects() {
		return this.projectDao.getEndedProjects();
	}
}
