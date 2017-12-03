package com.mju.app.service;

import java.util.List;

import com.mju.app.domain.Project;

public interface ProjectService {
	Project getProject(int id);
	List<Project> getAllProjects();
	List<Project> getEndedProjects();
}
