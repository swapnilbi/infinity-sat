package com.sat.model;

import com.sat.entity.SeatAllotment;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

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
	private Integer startSeatNo;
	private Integer endSeatNo;
	private List<SeatAllotment> splittedAllotments;

	public Integer getAllotedSeats(){
		return splittedAllotments!=null ? splittedAllotments.stream().map(x -> x.getMaxNoSeats())
				.reduce(0, Integer::sum):0;
	}

}
