package com.ravi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ravi.entity.Employee;
import com.ravi.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class Controller {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping("/welcome")
	public String home() {
		return "Welcome to visit ! but this is unauthorised";
	}
	 
	@PostMapping("/create")
	@PreAuthorize("hasRole('HR')")
	public String createNewEmployee(@RequestBody Employee employee) {
		return employeeService.createNewEmployee(employee);
	}
	
	@GetMapping("/all")
	@PreAuthorize("hasRole('HR') or hasRole('MANAGER')")
	public List<Employee> getEmployees(){
		return employeeService.getEmployees();
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('EMPLOYEE')")
	public Employee getEmployee(@PathVariable Long id) {
		return employeeService.getEmployee(id);
	}
}
