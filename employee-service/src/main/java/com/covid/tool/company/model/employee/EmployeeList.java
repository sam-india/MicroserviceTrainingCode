package com.covid.tool.company.model.employee;

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
		// TODO Auto-generated constructor stub
	}

	public EmployeeList(Iterable<Employee> empList) {
		super();
		this.empList = empList;
	}
	
	

}
