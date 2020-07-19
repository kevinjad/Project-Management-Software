package com.jad.pms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jad.pms.dao.EmployeeRepository;
import com.jad.pms.dto.EmployeeProject;
import com.jad.pms.models.Employee;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository empRepo;
	
	public List<Employee> getAll(){
		return empRepo.findAll();
	}
	
	public void save(Employee e) {
		empRepo.save(e);
	}
	public List<EmployeeProject> employeeProjects(){
		return empRepo.employeeProjects();
	}
	public Iterable<Employee> findAllById(List<Long> ids){
		return empRepo.findAllById(ids);
	}
}
