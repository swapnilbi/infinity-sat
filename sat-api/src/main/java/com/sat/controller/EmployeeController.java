package com.sat.controller;

import com.sat.entity.Employee;
import com.sat.exception.BusinessException;
import com.sat.model.EmployeeProfile;
import com.sat.model.Response;
import com.sat.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(value = "api/employee")
@RestController
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;

	@PostMapping
	@PreAuthorize("hasAuthority('ADMIN')")
	public Response<Employee> createEmployee(@RequestBody Employee user) throws BusinessException {
		Optional<Employee> userOptional = employeeService.getEmployeeByUsername(user.getUsername());
		if(userOptional.isPresent()){
			throw new BusinessException("Employee already exist with username :"+ user.getUsername());
		}
		user = employeeService.createEmployee(user);
		return new Response<>(user);
	}

	@PutMapping("/{employeeId}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public Response<Employee> updateEmployee(@RequestBody Employee employee) throws BusinessException {
		Optional<Employee> existingUser = employeeService.getEmployeeById(employee.getId());
		if(!existingUser.isPresent()){
			throw new BusinessException("Employee does not exist");
		}
		employeeService.updateEmployee(employee);
		return new Response<>(employee);
	}

	@GetMapping("/{employeeId}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public Response<Employee> getEmployee(@PathVariable Long employeeId) throws BusinessException {
		Employee user = employeeService.getEmployeeById(employeeId).get();
		user.setPassword(null);
		return new Response<>(user);
	}

	@GetMapping("/profile")
	@PreAuthorize("hasAnyAuthority('EMPLOYEE','ADMIN')")
	public Response<EmployeeProfile> getEmployeeProfile(Authentication authentication) {
		Employee user = employeeService.getEmployeeByUsername(authentication.getName()).get();
		return new Response<>(new EmployeeProfile(user));
	}

	@GetMapping("/list")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public Response<List<Employee>> getEmployees() {
		List<Employee> users = employeeService.getEmployees();
		return new Response<>(users);
	}

}
