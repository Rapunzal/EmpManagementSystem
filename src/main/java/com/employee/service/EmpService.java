package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepo;

@Service
public class EmpService {
	
	@Autowired
	private EmployeeRepo repo;
	
	public Employee saveEmployee(Employee e) {
		return repo.save(e);
	} 
	
	public List<Employee> getAllEmp(){
		return repo.findAll();
	}

	public Employee getEmployeeById(int id) {
		
		Optional<Employee> e=  repo.findById(id);
		if(e.isPresent()) {
			return e.get();
		}
		return null;
	}
	
	public void deleteEmployeeById(int id) {
			repo.deleteById(id);
	}

}
