package com.employee.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepo;

@SpringBootTest
public class EmployeeServiceTest {
	
	@Autowired
	private EmpService empService;
	
	@MockBean
	private EmployeeRepo empRepo;
	private Employee emp;
	
	@BeforeEach
	void setUp() {
		Optional<Employee> employee = Optional.of(new Employee(1,"Arya","Gupta","ABD LMN street","arya@gmail.com","7236673457",1232));
		Mockito.when(empRepo.findById(1)).thenReturn(employee);
	}
	
	@Test
	public void testGetEmployeeById() {
		String empName = "Arya";
		Employee emp = empService.getEmployeeById(1);
		assertEquals(empName,emp.getFirstName());
		
	}
	
	@Test
	public void testSaveEmployee() {
		emp = new Employee(1,"Arya","Gupta","ABD LMN street","arya@gmail.com","7236673457",1232);
		Mockito.when(empService.saveEmployee(emp)).thenReturn(emp);
		assertEquals(emp,empService.saveEmployee(emp));
	}
	
	

}
