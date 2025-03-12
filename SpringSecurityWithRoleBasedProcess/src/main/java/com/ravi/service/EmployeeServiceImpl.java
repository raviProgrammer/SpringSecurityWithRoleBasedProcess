package com.ravi.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ravi.entity.Employee;
import com.ravi.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public String createNewEmployee(Employee employee) {
		employee.setPassword(passwordEncoder.encode(employee.getPassword()));
		employee.setDateOfJoining(LocalDate.now());
		employee.setUsername(employee.getEmail());
		employeeRepo.save(employee);
		return "Successfully created !";
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employee = employeeRepo.findAll();
		return employee;
	}

	@Override
	public Employee getEmployee(Long id) {
		return employeeRepo.findById(id).orElseThrow(() -> {
			return new RuntimeException("Employee not found with ID: " + id);
		});
	}

}
