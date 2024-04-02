package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.employee.entity.Employee;
import com.employee.service.EmpService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmpService service;
	
	@GetMapping("/")
	public String home(Model m) {
		
		List<Employee> emp = service.getAllEmp();
		m.addAttribute("employee",emp);
		return "index";
	}

	@GetMapping("/addEmployee")
	public String addEmpForm(Model m) {
		m.addAttribute("e", new Employee());
		return "addEmployee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@Valid @ModelAttribute("e") Employee employee,Errors result,Model m, HttpSession session) {
		System.out.println(employee);
		if(result.hasErrors()) {
			System.out.println("error=========");
			return "addEmployee";
		}
		service.saveEmployee(employee);
		
		session.setAttribute("message", "Employee added Successfully");
		return "redirect:/";
	}
	
	@GetMapping("/editEmployee/{id}")
	public String edit(@PathVariable int id,Model m) 
	{
		Employee e = service.getEmployeeById(id);
		m.addAttribute("emp", e);
		return "editEmployee";
	}
	
	@PostMapping("/updateEmployee")
	public String updateEmployee(@ModelAttribute Employee emp,HttpSession session) 
	{
		service.saveEmployee(emp);
		session.setAttribute("message", "Employee data updated Successfully");
		return "redirect:/";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable int id,HttpSession session) {
		service.deleteEmployeeById(id);
		session.setAttribute("message", "Employee data deleted Successfully");
		return "redirect:/";
		
	}
	
}
