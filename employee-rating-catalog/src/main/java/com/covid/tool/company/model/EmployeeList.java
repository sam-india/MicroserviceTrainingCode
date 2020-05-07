package com.covid.tool.company.model;

public class EmployeeList {

	private Iterable<Employee> empList;

	public Iterable<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(Iterable<Employee> empList) {
		this.empList = empList;
	}

	public EmployeeList() {
		super();
	}

	public EmployeeList(Iterable<Employee> empList) {
		super();
		this.empList = empList;
	}
}