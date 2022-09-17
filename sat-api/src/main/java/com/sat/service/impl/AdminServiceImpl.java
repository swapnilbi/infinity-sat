package com.sat.service.impl;

import com.sat.entity.Department;
import com.sat.exception.BusinessException;
import com.sat.repository.DepartmentRepository;
import com.sat.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	DepartmentRepository departmentRepository;

	@Override
	public Department createDepartment(Department department) throws BusinessException {
		Optional<Department> existingUser =  getDepartmentByName(department.getName());
		if(existingUser.isPresent()){
			throw new BusinessException("Employee already exist with username "+department.getName());
		}
		return departmentRepository.save(department);
	}

	@Override
	public Optional<Department> getDepartmentByName(String name) {
		return departmentRepository.findByName(name);
	}

	@Override
	public Department getDepartment(Long id) {
		return departmentRepository.getById(id);
	}

	@Override
	public List<Department> getDepartments() {
		return departmentRepository.findAll();
	}
}
