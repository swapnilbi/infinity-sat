package com.sat.service.impl;

import com.sat.entity.*;
import com.sat.exception.BusinessException;
import com.sat.model.AllotmentDetails;
import com.sat.model.AllotmentInput;
import com.sat.model.CreateAllotmentDetails;
import com.sat.model.SplitAllotmentInput;
import com.sat.repository.SeatAllotmentRepository;
import com.sat.service.IAdminService;
import com.sat.service.IAllotmentService;
import com.sat.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AllotmentService implements IAllotmentService {

	@Autowired
	SeatAllotmentRepository seatAllotmentRepository;

	@Autowired
	IAdminService adminService;

	@Autowired
	IEmployeeService employeeService;

	@Override
	public SeatAllotment saveAllotment(AllotmentInput allotmentInput) throws BusinessException {
		SeatAllotment seatAllotment = new SeatAllotment();
		seatAllotment.setFloorId(allotmentInput.getFloorId());
		seatAllotment.setZoneId(allotmentInput.getZoneId());
		seatAllotment.setMaxNoSeats(allotmentInput.getNoOfSeats());
		seatAllotment.setDivisionId(allotmentInput.getDivisionId());
		seatAllotment.setFromDate(allotmentInput.getFromDate());
		seatAllotment.setToDate(allotmentInput.getToDate());
		seatAllotmentRepository.save(seatAllotment);
		return seatAllotment;
	}

	@Override
	public List<SpaceCapacity> getSpaceCapacity(){
		return seatAllotmentRepository.getSpaceCapacity();
	}

	@Override
	public List<AllotmentDetails> getAllotmentList() {
		List<AllotmentDetails> allotmentDetailsList = new ArrayList<>();
		List<SeatAllotment> seatAllotmentList = seatAllotmentRepository.findAll();
		if(seatAllotmentList!=null && !seatAllotmentList.isEmpty()){
			for(SeatAllotment seatAllotment : seatAllotmentList){
				allotmentDetailsList.add(getAllotmentDetails(seatAllotment));
			}
		}
		return allotmentDetailsList;
	}

	private AllotmentDetails getAllotmentDetails(SeatAllotment seatAllotment){
		AllotmentDetails allotmentDetails = new AllotmentDetails();
		allotmentDetails.setId(seatAllotment.getId());
		if(seatAllotment.getDivisionId()!=null){
			OEStructure oeStructure = adminService.getOEStructure(seatAllotment.getDivisionId());
			if(oeStructure!=null){
				allotmentDetails.setDivisionName(oeStructure.getName());
				allotmentDetails.setOeCode(oeStructure.getCode());
			}
		}
		Floor floor = adminService.getFloor(seatAllotment.getFloorId());
		allotmentDetails.setFloorName(floor.getName());
		Office office = adminService.getOffice(floor.getOfficeId());
		allotmentDetails.setOfficeName(office.getName());
		allotmentDetails.setNoOfSeats(seatAllotment.getMaxNoSeats());
		if(seatAllotment.getZoneId()!=null){
			Zone zone = adminService.getZone(seatAllotment.getZoneId());
			if(zone !=null){
				allotmentDetails.setZoneName(zone.getName());
			}
		}
		return allotmentDetails;
	}

	@Override
	public CreateAllotmentDetails initAllotment() throws BusinessException {
		CreateAllotmentDetails allotmentDetails = new CreateAllotmentDetails();
		List<Office> officeList = adminService.getOfficeList();
		allotmentDetails.setOfficeList(officeList);
		if(officeList!=null && !officeList.isEmpty()){
			List<Long> departmentIds = new ArrayList<>();
			for(Office office : officeList){
				if(office.getDepartmentList()!=null){
					departmentIds.addAll(office.getDepartmentList().stream().map(d -> d.getId()).collect(Collectors.toList()));
				}
			}
			allotmentDetails.setDivisionList(adminService.getOEStructures(departmentIds));
		}
		return allotmentDetails;
	}

	@Override
	public List<SeatAllotment> getAllotmentByZone(Long zoneId) {
		return seatAllotmentRepository.findByZoneId(zoneId);
	}

	@Override
	public List<AllotmentDetails> getManagerAllotmentList(Long employeeId) {
		Employee employee = employeeService.getEmployeeById(employeeId).get();
		List<AllotmentDetails> allotmentDetailsList = new ArrayList<>();
		List<SeatAllotment> seatAllotmentList = seatAllotmentRepository.findByDivisionId(employee.getOeId());
		if(seatAllotmentList!=null && !seatAllotmentList.isEmpty()){
			for(SeatAllotment seatAllotment : seatAllotmentList){
				AllotmentDetails allotmentDetails = getAllotmentDetails(seatAllotment);
				List<SeatAllotment> seatAllotments = seatAllotmentRepository.findByParentId(seatAllotment.getId());
				allotmentDetails.setSplittedAllotments(seatAllotments);
				allotmentDetailsList.add(allotmentDetails);
			}
		}
		return allotmentDetailsList;
	}

	@Override
	public List<AllotmentDetails> getSplittedAllotments(Long employeeId) {
		Employee employee = employeeService.getEmployeeById(employeeId).get();
		List<AllotmentDetails> allotmentDetailsList = new ArrayList<>();
		List<OEStructure> oeStructureList = adminService.getChildOeStructures(employee.getId());
		if(oeStructureList!=null && !oeStructureList.isEmpty()){
			List<Long> childOeList =  oeStructureList.stream().map(t-> t.getId()).collect(Collectors.toList());
			List<SeatAllotment> seatAllotmentList = seatAllotmentRepository.findByDivisionIds(childOeList);
			if(seatAllotmentList!=null && !seatAllotmentList.isEmpty()){
				for(SeatAllotment seatAllotment : seatAllotmentList){
					allotmentDetailsList.add(getAllotmentDetails(seatAllotment));
				}
			}
		}
		return allotmentDetailsList;
	}

	@Override
	public SeatAllotment splitAllotment(SplitAllotmentInput splitAllotmentInput) {
		SeatAllotment parentAllotment = seatAllotmentRepository.findById(splitAllotmentInput.getParentId()).get();
		SeatAllotment seatAllotment = new SeatAllotment();
		seatAllotment.setFloorId(parentAllotment.getFloorId());
		seatAllotment.setZoneId(parentAllotment.getZoneId());
		seatAllotment.setMaxNoSeats(splitAllotmentInput.getNoOfSeats());
		seatAllotment.setDivisionId(splitAllotmentInput.getDivisionId());
		seatAllotment.setParentId(splitAllotmentInput.getParentId());
		seatAllotmentRepository.save(seatAllotment);
		return seatAllotment;
	}
}
