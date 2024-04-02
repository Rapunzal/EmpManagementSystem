package com.employee.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.employee.entity.Employee;
import com.employee.service.EmpService;

@SpringBootTest
public class EmployeeRepositoryTest {
	
	@MockBean
	private EmployeeRepo empRepo;
	
	@Autowired
	private EmpService empService;
	
	@Test
	public void testgetEmployee() {
		when(empRepo.findAll()).thenReturn(Stream.of(new Employee(1,"Arya","Gupta","ABD LMN street","arya@gmail.com","7236673457",1232),
				new Employee(1,"Arya","Gupta","ABD LMN street","arya@gmail.com","7236673457",1232)).collect(Collectors.toList()));
		
		assertEquals(2,empService.getAllEmp().size());
	}
}
