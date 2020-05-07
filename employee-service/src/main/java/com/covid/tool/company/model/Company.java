package com.covid.tool.company.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Company {

	@Id
	private String id;
	private String name;
	private int empCount;
	
	public Company(String id, String name, int empCount) {
		super();
		this.id = id;
		this.name = name;
		this.empCount = empCount;
	}

	public Company() {

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

	public int getEmpCount() {
		return empCount;
	}

	public void setEmpCount(int empCount) {
		this.empCount = empCount;
	}
}
