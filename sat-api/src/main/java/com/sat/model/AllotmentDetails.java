package com.sat.model;

import lombok.Data;

import java.util.Date;

@Data
public class AllotmentDetails {

	private Long id;
	private String officeName;
	private String floorName;
	private String zoneName;
	private Integer noOfSeats;
	private Date fromDate;
	private Date endDate;
	private String divisionName;
	private String oeCode;

}
