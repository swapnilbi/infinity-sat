package com.sat.service.impl;

import com.sat.entity.Employee;
import com.sat.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeDetailsService implements UserDetailsService {

	@Autowired
	private IEmployeeService employeeService;

	@Override
	public Employee loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Employee> userOptional = employeeService.getEmployeeByUsername(username);
		if (userOptional.isPresent()) {
			return  userOptional.get();
		}
		throw new UsernameNotFoundException("Employee not found with username: " + username);
	}

}