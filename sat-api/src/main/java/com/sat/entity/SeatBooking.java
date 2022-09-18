package com.sat.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Data
@Entity
@Table(name = "seat_booking")
public class SeatBooking {

	@Id
	@GeneratedValue
	private long id;
	@Column(name = "employee_id")
	private Long employeeId;
	@Column(name = "zone_id")
	private Long zoneId;
	@Column(name = "seat_number")
	private Integer seatNumber;
	@Column(name = "start_date")
	private Date startDate;
	@Column(name = "booking_timestamp")
	private Date bookedAt;
	@Column(name = "status")
	private Integer status;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SeatBooking that = (SeatBooking) o;
		return id == that.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
