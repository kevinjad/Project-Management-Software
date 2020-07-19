package com.jad.pms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jad.pms.dto.EmployeeProject;
import com.jad.pms.models.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Long>{
	@Override
	List<Employee> findAll();
	
	@Query(nativeQuery = true, value = "SELECT e.firstname as firstname , e.lastname as lastname, COUNT(project_id) as projectcount FROM EMPLOYEE e LEFT JOIN PROJECT_EMPLOYEE pe ON e.employee_id = pe.employee_id GROUP BY e.firstname, e.lastname ORDER BY 3 DESC")
	public List<EmployeeProject> employeeProjects();
}
