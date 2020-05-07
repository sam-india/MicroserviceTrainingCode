package com.covid.tool.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class EmployeeRatingCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeRatingCatalogApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate()
	{
		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        //factory.setConnectTimeout(1000);
        return new RestTemplate(factory);
	}

}
