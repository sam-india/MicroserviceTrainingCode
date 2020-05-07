package com.covid.tool.company.repository;

import org.springframework.data.repository.CrudRepository;

import com.covid.tool.company.model.Company;

public interface CompanyRepository extends CrudRepository<Company, String> {
	
}
