package com.sat.service.impl;

import com.sat.entity.*;
import com.sat.exception.BusinessException;
import com.sat.model.AllotmentDetails;
import com.sat.model.AllotmentInput;
import com.sat.model.CreateAllotmentDetails;
import com.sat.repository.SeatAllotmentRepository;
import com.sat.service.IAdminService;
import com.sat.service.IAllotmentService;
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
				AllotmentDetails allotmentDetails = new AllotmentDetails();
				allotmentDetails.setId(seatAllotment.getId());
				if(seatAllotment.getDivisionId()!=null){
					OEStructure oeStructure = adminService.getOEStructure(seatAllotment.getDivisionId());
					if(oeStructure!=null){
						allotmentDetails.setDivisionName(oeStructure.getName()+"-"+oeStructure.getCode());
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
				allotmentDetailsList.add(allotmentDetails);
			}
		}
		return allotmentDetailsList;
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
}
