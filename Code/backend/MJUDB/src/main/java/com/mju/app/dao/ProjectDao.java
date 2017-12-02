package com.mju.app.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mju.app.domain.Project;

@Repository
@Transactional
public class ProjectDao {
	private final String NAMESPACE = "com.mju.app.mapper.ProjectMapper.";

	@Autowired
	private SqlSessionTemplate sqlSession;

	public List<Project> getAllProjects() {
		return this.sqlSession.selectList(NAMESPACE + "getAllProjects");
	}
	
	public Project getProject(int id) {
		return this.sqlSession.selectOne(NAMESPACE + "getProject", id);
	}
	
	public List<Project> getEndedProjects() {
		String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		System.out.println(date);
		
		return this.sqlSession.selectList(NAMESPACE + "getEndedProjects", date);
	}
}
