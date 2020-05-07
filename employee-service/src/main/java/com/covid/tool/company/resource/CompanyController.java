package com.covid.tool.company.resource;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.covid.tool.company.model.Company;
import com.covid.tool.company.service.CompanyService;

@RestController
public class CompanyController {

	@Autowired
	CompanyService companyService;
	
	@RequestMapping("/companies")
	public Iterable<Company> getAllCompanies()
	{
		return companyService.getAllCompanies();
	}
	
	@RequestMapping("/companies/{id}")
	public Optional<Company> getCompanyById(@PathVariable("id") String companyId)
	{
		return companyService.getCompany(companyId);
	}
	
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/companies")
	public void addCompany(@RequestBody Company company)
	{
		companyService.addCompany(company);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/companies/{id}")
	public void updateCompany(@RequestBody Company company,@PathVariable("id") String companyId )
	{
		companyService.updateCompany(company);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/companies/{id}")
	public void deleteCompany(@PathVariable("id") String companyId )
	{
		companyService.deleteCompany(companyId);
	}
	
	
	
}
