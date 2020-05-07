package com.covid.tool.company.service.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.tool.company.model.Company;
import com.covid.tool.company.model.employee.Employee;
import com.covid.tool.company.repository.employee.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Iterable<Employee> getAllEmployees(String CompanyId)
	{
		List<Employee> empList = new ArrayList<>();
		employeeRepository.findByCompanyId(CompanyId).forEach(empList::add);
		return empList;
	}
	
	public Optional<Employee> getEmployee(String employeeId) {
		return employeeRepository.findById(employeeId);
	}
	
	public void createEmployee(Employee employee, String companyId) {
		employee.setCompany(new Company(companyId, "", 0));
		employeeRepository.save(employee);
	}
	
	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	
	public void deleteEmployee(String employeeId) {
		employeeRepository.deleteById(employeeId);
		
	}
//	getAllEmployee
//	getEmployee   
//	createEmployee
//	updateEmployee
//	deleteEmployee

}
