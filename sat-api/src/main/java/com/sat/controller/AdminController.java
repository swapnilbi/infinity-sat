package com.sat.controller;

import com.sat.entity.*;
import com.sat.exception.BusinessException;
import com.sat.model.Response;
import com.sat.service.IAdminService;
import com.sat.utility.SecurityHelper;
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

	@GetMapping("/departments")
	@PreAuthorize("hasAnyAuthority('ADMIN','EMPLOYEE')")
	public Response<List<Department>> getDepartmentList() {
		List<Department> departments = adminService.getDepartments();
		return new Response<>(departments);
	}

	@PostMapping("department/oe-structure")
	@PreAuthorize("hasAuthority('ADMIN')")
	public Response<OEStructure> createOEStructure(@RequestBody OEStructure oeStructure) throws BusinessException {
		oeStructure = adminService.createOEStructure(oeStructure);
		return new Response<>(oeStructure);
	}

	@GetMapping("department/{departmentId}/oe-structure")
	public Response<List<OEStructure>> getOeLists(@PathVariable Long departmentId) {
		List<OEStructure> oeStructureList = adminService.getOEStructures(departmentId);
		return new Response<>(oeStructureList);
	}

	@GetMapping("oe-structures/childrens")
	public Response<List<OEStructure>> getChildOeStructures() {
		List<OEStructure> oeStructureList = adminService.getChildOeStructures(SecurityHelper.getEmployeeId());
		return new Response<>(oeStructureList);
	}

	@PostMapping("office")
	@PreAuthorize("hasAuthority('ADMIN')")
	public Response<Office> createOffice(@RequestBody Office office) throws BusinessException {
		office = adminService.createOffice(office);
		return new Response<>(office);
	}

	@PostMapping("office/floor")
	@PreAuthorize("hasAuthority('ADMIN')")
	public Response<Floor> createFloor(@RequestBody Floor floor) throws BusinessException {
		floor = adminService.createFloor(floor);
		return new Response<>(floor);
	}

	@GetMapping("office/{officeId}/floors")
	public Response<List<Floor>> getFloors(@PathVariable Long officeId) {
		List<Floor> floorList = adminService.getFloors(officeId);
		return new Response<>(floorList);
	}

	@PostMapping("floor/zone")
	@PreAuthorize("hasAuthority('ADMIN')")
	public Response<Zone> createZone(@RequestBody Zone zone) throws BusinessException {
		zone = adminService.createZone(zone);
		return new Response<>(zone);
	}

	@GetMapping("/floor/{floorId}/zones")
	public Response<List<Zone>> getZones(@PathVariable Long floorId) {
		List<Zone> zoneList = adminService.getZones(floorId);
		return new Response<>(zoneList);
	}

}
