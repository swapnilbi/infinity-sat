package com.sat.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sat.entity.*;
import com.sat.model.*;
import com.sat.service.IAdminService;
import com.sat.service.IAllotmentService;
import com.sat.service.IEmployeeService;
import com.sat.service.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements IReservationService {

	@Autowired
	private IAdminService adminService;

	@Autowired
	private IEmployeeService employeeService;

	@Autowired
	private IAllotmentService allotmentService;

	@Override
	public CreateReservationDetails initReservation(Long employeeId) {
		CreateReservationDetails reservationDetails = new CreateReservationDetails();
		Employee employee = employeeService.getEmployeeById(employeeId).get();
		List<SeatAllotment> seatAllotments = allotmentService.getAllotmentByDivision(employee.getOeId());
		if(seatAllotments!=null && !seatAllotments.isEmpty()){
			Map<Long, FloorDetails> floors = new HashMap<>();
			HashSet<Long> zones = new HashSet<>();
			for (SeatAllotment seatAllotment : seatAllotments){
				if(!floors.containsKey(seatAllotment.getFloorId())){
					Floor floor = adminService.getFloor(seatAllotment.getFloorId());
					floor.setZoneList(new HashSet<>());
					floors.put(floor.getId(),new FloorDetails(floor));
				}
				if(!zones.contains(seatAllotment.getZoneId())){
					Zone zone = adminService.getZone(seatAllotment.getZoneId());
					zones.add(zone.getId());
					floors.get(seatAllotment.getFloorId()).getZoneList().add(zone);
				}
			}
			if(!floors.isEmpty()){
				Map<Long, OfficeDetails> offices = new HashMap<>();
				for(Map.Entry<Long,FloorDetails> entry : floors.entrySet()){
					if(!offices.containsKey(entry.getValue().getOfficeId())){
						Office office = adminService.getOffice(entry.getValue().getOfficeId());
						office.setFloorList(new HashSet<>());
						offices.put(office.getId(),new OfficeDetails(office));
					}
					offices.get(entry.getValue().getOfficeId()).getFloorList().add(entry.getValue());
				}
				reservationDetails.setOfficeList(new ArrayList<OfficeDetails>(offices.values()));
			}
		}
		return reservationDetails;
	}

	@Override
	public SearchSeatResult searchSeats(SearchSeatInput searchSeatInput, Long userId) throws JsonProcessingException {
		SearchSeatResult searchSeatResult = new SearchSeatResult();
		Floor floor = adminService.getFloor(searchSeatInput.getFloorId());
		Employee employee =  employeeService.getEmployeeById(userId).get();
		List<SeatAllotment> seatAllotments =  allotmentService.getAllotments(floor.getId(),employee.getOeId());
		Map<Long, List<SeatAllotment>> allotmentsByZoneMap = seatAllotments.stream().collect(Collectors.groupingBy(SeatAllotment::getZoneId));
		ObjectMapper mapper = new ObjectMapper();
		FloorLayoutConfig floorLayoutConfig  = mapper.readValue(floor.getFloorLayout(), FloorLayoutConfig.class);
		if(floorLayoutConfig.getLayout()!=null){
			List<SearchSeatResult.FloorLayout> floorLayouts = new ArrayList<>();
			for(FloorLayoutConfig.Layout layoutConfig : floorLayoutConfig.getLayout()){
				if(layoutConfig.getZones()!=null){
					SearchSeatResult.FloorLayout floorLayout = new SearchSeatResult.FloorLayout();
					List<SearchSeatResult.FloorLayout.ZoneLayout> zonelayoutList = new ArrayList<>();
					for(FloorLayoutConfig.Layout.ZoneLayout zoneLayoutConfig : layoutConfig.getZones()){
						SearchSeatResult.FloorLayout.ZoneLayout zoneLayout  = new SearchSeatResult.FloorLayout.ZoneLayout();
						Zone zoneDetails =  adminService.getZone(zoneLayoutConfig.getZoneId());
						zoneLayout.setZoneId(zoneDetails.getId());
						zoneLayout.setZoneName(zoneDetails.getName());
						// get seat details if allotment is present
						if(allotmentsByZoneMap.containsKey(zoneDetails.getId())){
							List<List<SeatDetails>> seatDetailsList = new ArrayList<>();
							for(List<Integer> row : zoneLayoutConfig.getSeats()){
								List<SeatDetails> seatDetailsRow = new ArrayList<>();
								for(Integer seat : row){
									SeatDetails seatDetails = new SeatDetails();
									if(seat!=0){
										seatDetails.setNumber(seat);
									}else{
										seatDetails.setHide(true);
									}
									seatDetailsRow.add(seatDetails);
								}
								seatDetailsList.add(seatDetailsRow);
							}
							zoneLayout.setSeats(seatDetailsList);
						}
						zonelayoutList.add(zoneLayout);
					}
					floorLayout.setZones(zonelayoutList);
					floorLayouts.add(floorLayout);
				}
			}
			searchSeatResult.setFloorLayout(floorLayouts);
		}
		return searchSeatResult;
	}
}
