package com.sat.service;

import com.sat.entity.Employee;
import com.sat.exception.BusinessException;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {

    Optional<Employee> getEmployeeById(Long userId);

    Optional<Employee> getEmployeeByUsername(String username);

    Employee createEmployee(Employee employee) throws BusinessException;

    Employee updateEmployee(Employee employee);

    List<Employee> getEmployees();

}
