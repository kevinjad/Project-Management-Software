package com.jad.pms.daoo;

import static org.junit.Assert.assertEquals;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import com.jad.pms.ProjectManagementApplication;
import com.jad.pms.dao.ProjectRepository;
import com.jad.pms.models.Project;

@ContextConfiguration(classes=ProjectManagementApplication.class)
@RunWith(SpringRunner.class)
@DataJpaTest
@SqlGroup({@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD,
			scripts= {"classpath:schema.sql", "classpath:data.sql"}),
			@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD,
			scripts= "classpath:drop.sql")})
public class ProjectRepositoryIntegrationTest {
	@Autowired
	ProjectRepository proRepo;
	@Test
	public void ifnewProjectSaved_thenSuccess() {
		Project newProject = new Project("New test Project","COMPLETE","Test description");
		proRepo.save(newProject);
		
		assertEquals(5, proRepo.findAll().size());
	}
}
