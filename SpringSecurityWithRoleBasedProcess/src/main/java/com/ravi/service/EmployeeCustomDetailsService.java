package com.ravi.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//import com.ravi.dto.EmployeeCustomDetails;
import com.ravi.entity.Employee;
import com.ravi.repository.EmployeeRepo;

@Service
public class EmployeeCustomDetailsService implements UserDetailsService {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Employee employee = employeeRepo.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));

		return new User(
				employee.getUsername(),
				employee.getPassword(),
				Collections.singletonList(new SimpleGrantedAuthority(employee.getRole().name()))
				);
	}


}
