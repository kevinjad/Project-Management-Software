package com.jad.pms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jad.pms.models.Employee;
import com.jad.pms.models.Project;
import com.jad.pms.services.EmployeeService;
import com.jad.pms.services.ProjectService;


@Controller
@RequestMapping("/projects")
public class ProjectController {
	@Autowired
	ProjectService proService;
	@Autowired
	EmployeeService empService;
	
	@GetMapping
	public String displayProjectScreen(Model model) {
		List<Project> projects = proService.getAll();
		model.addAttribute("projects",projects);
		return "project/project";
	}
	
	@RequestMapping("/new")
	public String displayNewProjectForm(Model model) {
		Project newProject = new Project();
		List<Employee> employees = empService.getAll();
		model.addAttribute("project",newProject);
		model.addAttribute("allEmployees",employees);
		return "project/new-project";
	}
	
	@PostMapping("/save")
	public String createProject(Project project,BindingResult bindingResult,@RequestParam List<Long> employees,Model model) {
		if(employees != null) {
		Iterable<Employee> e = empService.findAllById(employees);
		for(Employee x : e) {
			project.addEmployee(x);
		}
		}
		proService.save(project);
		return "redirect:/projects/new";
	}
}
