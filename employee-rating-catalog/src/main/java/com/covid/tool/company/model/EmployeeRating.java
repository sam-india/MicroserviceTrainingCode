package com.covid.tool.company.model;

public class EmployeeRating {
	
	private Employee employee;
	private Rating rating;
	public EmployeeRating() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeRating(Employee employee, Rating rating) {
		super();
		this.employee = employee;
		this.rating = rating;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Rating getRating() {
		return rating;
	}
	public void setRating(Rating rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "EmployeeRating [employee=" + this.employee.getId() + ", rating=" + this.rating.getRating() + "]";
	}
	
	

}
