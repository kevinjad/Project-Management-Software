package com.jad.pms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jad.pms.dao.ProjectRepository;
import com.jad.pms.dto.ProjectStageCount;
import com.jad.pms.models.Project;

@Service
public class ProjectService {
	@Autowired
	ProjectRepository proRepo;
	
	public List<Project> getAll(){
		return proRepo.findAll();
	}
	
	public void save(Project p) {
		proRepo.save(p);
	}
	public List<ProjectStageCount> stageData(){
		return proRepo.stageData();
	}
}
