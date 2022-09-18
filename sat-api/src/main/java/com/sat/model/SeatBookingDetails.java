package com.sat.model;

import com.sat.entity.SeatBooking;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor
public class SeatBookingDetails {

	private long id;
	private Long employeeId;
	private Long zoneId;
	private String floorName;
	private String zoneName;
	private Integer seatNumber;
	private Date startDate;
	private Date bookedAt;
	private Integer status;

	public SeatBookingDetails(SeatBooking seatBooking){
		this.id = seatBooking.getId();
		this.employeeId = seatBooking.getEmployeeId();
		this.zoneId = seatBooking.getZoneId();
		this.seatNumber = seatBooking.getSeatNumber();
		this.startDate = seatBooking.getStartDate();
		this.bookedAt = seatBooking.getBookedAt();
		this.status = seatBooking.getStatus();
	}

}
