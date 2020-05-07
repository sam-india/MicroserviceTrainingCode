package com.covid.tool.company.repository.employee;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.covid.tool.company.model.employee.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, String> {

	public List<Employee> findByCompanyId(String id);
	
}
