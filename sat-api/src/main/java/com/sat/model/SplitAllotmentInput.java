package com.sat.model;

import lombok.Data;

import java.util.Date;

@Data
public class SplitAllotmentInput {

	private Long floorId;
	private Long zoneId;
	private Integer noOfSeats;
	private Long divisionId;
	private Long parentId;
}
