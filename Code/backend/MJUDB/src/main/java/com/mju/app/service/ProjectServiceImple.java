package com.mju.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mju.app.dao.ProjectDao;
import com.mju.app.domain.Project;

@Service
public class ProjectServiceImple implements ProjectService {
	@Autowired
	private ProjectDao projectDao;
	
	@Override
	public List<Project> getAllProjects() {
		return this.projectDao.getAllProjects();
	}
	
	@Override
	public Project getProject(int id) {
		return this.projectDao.getProject(id);
	}
}
