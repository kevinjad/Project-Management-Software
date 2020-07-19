package com.jad.pms.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jad.pms.dto.EmployeeProject;
import com.jad.pms.dto.ProjectStageCount;
import com.jad.pms.models.Project;
import com.jad.pms.services.EmployeeService;
import com.jad.pms.services.ProjectService;

@Controller
public class HomeController {
	@Autowired
	ProjectService proService;
	@Autowired
	EmployeeService empService;
	@GetMapping("/")
	public String displayHome(Model model) {
		Map<String,Object> map = new HashMap<String,Object>();
		ObjectMapper om = new ObjectMapper();
		List<Project> projects = proService.getAll();
		List<ProjectStageCount> psc = proService.stageData();
		try {
			String pscString = om.writeValueAsString(psc);
			model.addAttribute("psc",pscString);
		}
		catch(Exception e) {
			System.out.println("psc is empty");
		}
		
		List<EmployeeProject> employeesProjectCount = empService.employeeProjects();
		model.addAttribute("projects",projects);
		model.addAttribute("employeesProjectCount",employeesProjectCount);
		return "main/home";
	}
}
