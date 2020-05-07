package com.covid.tool.company.resource.employee;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.covid.tool.company.model.Company;
import com.covid.tool.company.model.employee.Employee;
import com.covid.tool.company.model.employee.EmployeeList;
import com.covid.tool.company.service.CompanyService;
import com.covid.tool.company.service.employee.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private CompanyService companyService;
	
    //url : /companies/seeddata
	@RequestMapping("/companies/seeddata")
    public String seeddata() {
        companyService.addCompany(new Company("Hexaware", "Hexaware India Pvt Ltd", 22000));
        companyService.addCompany(new Company("Apple", "Apple India Pvt Ltd", 10000));
        companyService.addCompany(new Company("Infosys", "Infosys India Pvt Ltd", 5000));
        
        employeeService.createEmployee(new Employee("Sajal", "Sajal from Hexaware", 1000000, "Hexaware"),"Hexaware");
        employeeService.createEmployee(new Employee("Mayur", "Sajal always from Hexaware", 2000000, "Hexaware"),"Hexaware");
        employeeService.createEmployee(new Employee("Swapil", "Sajal is also from Hexaware", 3000000, "Hexaware"),"Hexaware");
        employeeService.createEmployee(new Employee("Rehman", "Rehman pillar of Hexaware", 4000000, "Hexaware"),"Hexaware");
        employeeService.createEmployee(new Employee("Akash", "Akash Shah", 40000, "Apple"),"Apple");
        employeeService.createEmployee(new Employee("Lucky", "Lakhvinder Singh", 1000, "Apple"),"Apple");
        
        return "Data Seeded";
	}
	
	@RequestMapping(value = "/companies/{CompanyId}/employees", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeList getAllEmployees(@PathVariable String CompanyId)
	{
		EmployeeList empList = new EmployeeList();
		empList.setEmpList(employeeService.getAllEmployees(CompanyId));
		return empList;
	}
	
	@RequestMapping("/companies/{companyId}/employees/{empId}")
	public Optional<Employee> getEmployee(@PathVariable String companyId, @PathVariable String empId)
	{
		return employeeService.getEmployee(empId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/companies/{companyId}/employees")
	public void createEmployee(@PathVariable String companyId,@RequestBody Employee employee) {
		employeeService.createEmployee(employee,companyId);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/companies/{companyId}/employees/{empId}")
	public void updateEmployee(@PathVariable String companyId, @PathVariable String empId, @RequestBody Employee employee) {
		employeeService.updateEmployee(employee);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/companies/{companyId}/employees/{empId}")
	public void deleteEmployee(@PathVariable String companyId, @PathVariable String empId) {
		employeeService.deleteEmployee(empId);
	}
}
