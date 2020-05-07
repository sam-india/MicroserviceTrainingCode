package com.covid.tool.company.resource;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.covid.tool.company.model.Employee;
import com.covid.tool.company.model.EmployeeList;
import com.covid.tool.company.model.EmployeeRating;
import com.covid.tool.company.model.Rating;
import com.covid.tool.company.service.EmployeeCatalogService;

import ch.qos.logback.classic.Logger;

@RestController
public class EmployeeRatingCatalogController {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(EmployeeRatingCatalogController.class);

	
	@Autowired
	private RestTemplate restTemplate;// Avoid create a new instance for every call.
	// getRestTemplate is added in Application class.

	@RequestMapping("/catalog/Access")
    public String Accessed() {
		return "Accessed";
	}
	
	// Remember there is a Class level request mapping also out here.
	@RequestMapping("/catalog/companies/{companyId}/employeeratings")
	public List<EmployeeRating> getEmployeesRating(@PathVariable String companyId) {
		
		EmployeeList emplist = restTemplate.getForObject("http://EMPLOYEE-SERVICE/companies/"+companyId+"/employees", EmployeeList.class);
		//EmployeeList emplist = restTemplate.getForObject("http://employee-service:8081/companies/"+companyId+"/employees", EmployeeList.class);
		
		Iterable<Employee> itrEmp = emplist.getEmpList();
		Iterator<Employee> empIterator = itrEmp.iterator();
		List<EmployeeRating> employeeRatings = new ArrayList<EmployeeRating>();
		while(empIterator.hasNext())
		{
			Employee emp = empIterator.next();
			Rating rating = restTemplate.getForObject("http://RATING-SERVICE/ratings/employeerating/"+emp.getId(), Rating.class);
			employeeRatings.add(new EmployeeRating(emp,rating));
			logger.info(employeeRatings.toString());
		}
		return employeeRatings;
	}
}
