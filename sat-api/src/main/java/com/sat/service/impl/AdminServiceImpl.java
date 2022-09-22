package com.sat.service.impl;

import com.sat.entity.*;
import com.sat.exception.BusinessException;
import com.sat.repository.*;
import com.sat.service.IAdminService;
import com.sat.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	OEStructureRepository oeStructureRepository;

	@Autowired
	OfficeRepository officeRepository;

	@Autowired
	ZoneRepository zoneRepository;

	@Autowired
	FloorRepository floorRepository;

	@Autowired
	IEmployeeService employeeService;

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

	@Override
	public OEStructure createOEStructure(OEStructure oeStructure) throws BusinessException {
		Optional<OEStructure> existingUser = getOEStructureByCode(oeStructure.getCode());
		if(existingUser.isPresent()){
			throw new BusinessException("OC Structure already exist with code "+oeStructure.getCode());
		}
		return oeStructureRepository.save(oeStructure);
	}

	@Override
	public Optional<OEStructure> getOEStructureByCode(String code) {
		return oeStructureRepository.findByCode(code);
	}

	@Override
	public OEStructure getOEStructure(Long id) {
		return oeStructureRepository.findById(id).get();
	}

	@Override
	public List<OEStructure> getOEStructures(Long departmentId) {
		return oeStructureRepository.findAll();
	}

	@Override
	public List<OEStructure> getOEStructures(List<Long> departmentIds) {
		return oeStructureRepository.findByDepartmentId(departmentIds);
	}

	@Override
	public List<OEStructure> getOEStructuresByLevel(Integer level) {
		return oeStructureRepository.findByLevel(level);
	}

	@Override
	public Office getOffice(Long id) {
		return officeRepository.getById(id);
	}

	@Override
	public Office createOffice(Office office) throws BusinessException {
		Optional<Office> existingFloor = officeRepository.findByName(office.getName());
		if(existingFloor.isPresent()){
			throw new BusinessException("Office already exist with name "+office.getName());
		}
		return officeRepository.save(office);
	}

	@Override
	public List<Office> getOfficeList() throws BusinessException {
		return officeRepository.findAll();
	}

	@Override
	public Floor getFloor(Long id) {
		return floorRepository.getById(id);
	}

	@Override
	public Floor createFloor(Floor floor) throws BusinessException {
		Optional<Floor> existingFloor = floorRepository.findByName(floor.getName());
		if(existingFloor.isPresent()){
			throw new BusinessException("Floor already exist with name "+floor.getName());
		}
		return floorRepository.save(floor);
	}

	@Override
	public List<Floor> getFloors(Long officeId) {
		return floorRepository.findByOfficeId(officeId);
	}

	@Override
	public Zone getZone(Long id) {
		return zoneRepository.getById(id);
	}

	@Override
	public Zone createZone(Zone zone) throws BusinessException {
		Optional<Zone> existingZone = zoneRepository.findByName(zone.getName());
		if(existingZone.isPresent()){
			throw new BusinessException("Zone already exist with name "+zone.getName());
		}
		return zoneRepository.save(zone);
	}

	@Override
	public List<Zone> getZones(Long floorId) {
		return zoneRepository.findByFloorId(floorId);
	}

	@Override
	public List<OEStructure> getChildOeStructures(Long userId) {
		Employee employee = employeeService.getEmployeeById(userId).get();
		return oeStructureRepository.findByParentId(employee.getOeId());
	}
}
