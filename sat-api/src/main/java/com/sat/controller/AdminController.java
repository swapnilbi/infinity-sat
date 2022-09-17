package com.sat.controller;

import com.sat.entity.Department;
import com.sat.exception.BusinessException;
import com.sat.model.Response;
import com.sat.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "api/admin")
@RestController
public class AdminController {

	@Autowired
	private IAdminService adminService;

	@PostMapping("department")
	@PreAuthorize("hasAuthority('ADMIN')")
	public Response<Department> createDepartment(@RequestBody Department department) throws BusinessException {
		department = adminService.createDepartment(department);
		return new Response<>(department);
	}

	@GetMapping("/department/list")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public Response<List<Department>> getDepartmentList() {
		List<Department> departments = adminService.getDepartments();
		return new Response<>(departments);
	}

}
