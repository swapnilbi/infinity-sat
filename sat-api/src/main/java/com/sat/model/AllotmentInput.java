package com.sat.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class AllotmentInput {

	private Long officeId;
	private Long floorId;
	private Long zoneId;
	private Integer noOfSeats;
	private Date fromDate;
	private Date toDate;
	private Long divisionId;

}
