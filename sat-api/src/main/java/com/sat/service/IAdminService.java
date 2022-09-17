package com.sat.service;

import com.sat.entity.Department;
import com.sat.exception.BusinessException;

import java.util.List;
import java.util.Optional;

public interface IAdminService {

    Department createDepartment(Department department) throws BusinessException;

    Optional<Department> getDepartmentByName(String name);

    Department getDepartment(Long id);

    List<Department> getDepartments();



}
