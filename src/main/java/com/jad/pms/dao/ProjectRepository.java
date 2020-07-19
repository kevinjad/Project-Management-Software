package com.jad.pms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jad.pms.dto.ProjectStageCount;
import com.jad.pms.models.Project;

public interface ProjectRepository extends CrudRepository<Project,Long>{
	@Override
	List<Project> findAll();
	
	@Query(nativeQuery = true, value = "SELECT stage , COUNT(*) as stageCount FROM PROJECT GROUP BY stage")
	List<ProjectStageCount> stageData();
}
