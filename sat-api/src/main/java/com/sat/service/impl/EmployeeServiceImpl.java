package com.sat.service.impl;

import com.sat.entity.Employee;
import com.sat.exception.BusinessException;
import com.sat.repository.EmployeeRepository;
import com.sat.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Optional<Employee> getEmployeeById(Long userId) {
		return employeeRepository.findById(userId);
	}

	@Override
	public Optional<Employee> getEmployeeByUsername(String username) {
		return employeeRepository.findByUsername(username);
	}

	@Override
	public Employee createEmployee(Employee user) throws BusinessException {
		Optional<Employee> existingUser =  getEmployeeByUsername(user.getUsername());
		if(existingUser.isPresent()){
			throw new BusinessException("Employee already exist with username "+user.getUsername());
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return employeeRepository.save(user);
	}

	@Override
	public Employee updateEmployee(Employee userForm) {
		Employee user = getEmployeeById(userForm.getId()).get();
		user.setFullName(userForm.getFullName());
		user.setEmail(userForm.getEmail());
		user.setRoles(userForm.getRoles());
		return employeeRepository.save(user);
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> userList = employeeRepository.findAll();
		if(userList!=null){
			userList.forEach(t-> t.setPassword(null));
		}
		return userList;
	}

}
