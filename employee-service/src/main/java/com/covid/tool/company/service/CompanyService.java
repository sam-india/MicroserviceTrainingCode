package com.covid.tool.company.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.tool.company.model.Company;
import com.covid.tool.company.repository.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	public Iterable<Company> getAllCompanies(){
		return companyRepository.findAll();
	}
	
	public Optional<Company> getCompany(String id){
		return companyRepository.findById(id);
	}

	public void addCompany(Company company) {
		companyRepository.save(company);
	}
	
	public void updateCompany(Company company) {
		companyRepository.save(company);
	}
	
	public void deleteCompany(String companyId) {
		companyRepository.deleteById(companyId);
	}
}
