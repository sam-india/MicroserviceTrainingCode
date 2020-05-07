package com.covid.tool.company.service.employee;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.covid.tool.company.model.employee.Employee;
import com.covid.tool.company.repository.employee.EmployeeRepository;

@SpringBootTest
class EmployeeServiceTest {

	@Mock
    private EmployeeRepository empRepository;

    @InjectMocks
    private EmployeeService empService = new EmployeeService();

	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testGetAllEmployees() {
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee("1", "Vilas", 10000, "Hexaware"));
		when(empRepository.findByCompanyId("Hexaware")).thenReturn(empList);

		Iterable<Employee> resultEmpList = empService.getAllEmployees("Hexaware");
		Iterator<Employee> iterator = resultEmpList.iterator();
		while(iterator.hasNext()) {
			Employee emp = iterator.next();
			assertEquals("Vilas", emp.getName(), "Name doesn't match");
		}	}

	@Disabled
	@Test
	void testGetEmployee() {
		fail("Not yet implemented");
	}

	@Disabled
	@Test
	void testCreateEmployee() {
		fail("Not yet implemented");
	}

	@Disabled
	@Test
	void testUpdateEmployee() {
		fail("Not yet implemented");
	}

	@Disabled
	@Test
	void testDeleteEmployee() {
		fail("Not yet implemented");
	}
}