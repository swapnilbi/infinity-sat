package com.sat.service;

import com.sat.entity.*;
import com.sat.exception.BusinessException;

import java.util.List;
import java.util.Optional;

public interface IAdminService {

    Department createDepartment(Department department) throws BusinessException;

    Optional<Department> getDepartmentByName(String name);

    Department getDepartment(Long id);

    List<Department> getDepartments();

    OEStructure createOEStructure(OEStructure oeStructure) throws BusinessException;

    Optional<OEStructure> getOEStructureByCode(String code);

    OEStructure getOEStructure(Long id);
    List<OEStructure> getOEStructures(Long departmentId);

    List<OEStructure> getOEStructures(List<Long> departmentIds);

    Office getOffice(Long id);

    Office createOffice(Office office) throws BusinessException;

    List<Office> getOfficeList() throws BusinessException;

    Floor getFloor(Long id);

    Floor createFloor(Floor floor) throws BusinessException;

    List<Floor> getFloors(Long officeId);

    Zone getZone(Long id);

    Zone createZone(Zone zone) throws BusinessException;

    List<Zone> getZones(Long floorId);

    List<OEStructure> getChildOeStructures(Long parentOeId);
}
