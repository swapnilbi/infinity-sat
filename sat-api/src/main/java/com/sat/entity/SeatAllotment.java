package com.sat.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "seat_allotment")
public class SeatAllotment {

	@Id
	@GeneratedValue
	private long id;

	@Column(name = "floor_id")
	private Long floorId;
	@Column(name = "zone_id")
	private Long zoneId;
	@Column(name = "max_no_seats")
	private Integer maxNoSeats;
	@Column(name = "division_id")
	private Long divisionId;
	@Column(name = "from_date")
	private Date fromDate;
	@Column(name = "to_date")
	private Date toDate;
	@Column(name = "parent_allotment_id")
	private Long parentId;


}
