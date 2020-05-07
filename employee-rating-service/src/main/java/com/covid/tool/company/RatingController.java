package com.covid.tool.company;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.covid.tool.company.model.Rating;



@RestController
@RequestMapping("/ratings")
public class RatingController {

	//There is a class level mapping as well.
	@RequestMapping("/employeerating/{employeeId}")
	public Rating getEmployeeRatings(@PathVariable String employeeId){
		return new Rating(employeeId, 4);
	}
	
	
}