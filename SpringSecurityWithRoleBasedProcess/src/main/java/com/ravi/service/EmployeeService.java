package com.ravi.service;

import java.util.List;

import com.ravi.entity.Employee;

public interface EmployeeService {
	
	public String createNewEmployee(Employee employee);
	public List<Employee> getEmployees();
	public Employee getEmployee(Long id);
}
