package com.covid.tool.employee.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class EmployeeApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApiGatewayApplication.class, args);
	}

}
