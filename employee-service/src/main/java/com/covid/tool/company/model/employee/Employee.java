package com.covid.tool.company.model.employee;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.covid.tool.company.model.Company;

@Entity
public class Employee {
	
	@Id
	private String id;
	private String name;
	private int salary;
	
	@ManyToOne
	private Company company;
	
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Employee() {

	}

	public Employee(String id, String name, int salary, String compId) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.company = new Company(compId, "", 0);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
}
