package com.learn.external.settings.demo.config;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class Employee {
	private int id;
	private String name;
	private int aadhar;
	private String address;
	
	public Employee(int id, String name, int aadhar, String address) {
		super();
		this.id = id;
		this.name = name;
		this.aadhar = aadhar;
		this.address = address;
	}
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	}