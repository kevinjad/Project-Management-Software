package com.jad.pms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jad.pms.models.Employee;
import com.jad.pms.services.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	EmployeeService empService;
	
	@GetMapping
	public String displayEmployeeScreen(Model model) {
		List<Employee> employees = empService.getAll();
		model.addAttribute("employees",employees);
		return "employee/employee";
	}
	
	@GetMapping("/new")
	public String displayNewEmployeeForm(Model model) {
		Employee newEmployee = new Employee();
		model.addAttribute("employee",newEmployee);
		return "employee/new-employee";
	}
	
	@PostMapping("/save")
	public String createEmployee(Employee employee,Model model) {
		empService.save(employee);
		return "redirect:/employees/new";
	}
	
}
