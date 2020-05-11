package com.learn.external.settings.demo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.external.settings.demo.config.Employee;

@RestController
public class EmployeeLombokContoller {
	
	@Autowired
	private Employee employee;
	
	@RequestMapping("/lombok")
	public String Lombok()
	{
		employee.setId(101);
		employee.setAddress("address");
		employee.setAadhar(54656545);
		employee.setName("name1");
		
		return "Lombok " +
		" " +employee.getId()
		+ " " +employee.getAddress()
		+ " " +employee.getAadhar()
		+ " " +employee.getName();
	}

}
