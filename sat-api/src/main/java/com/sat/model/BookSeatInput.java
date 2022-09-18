package com.sat.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class BookSeatInput {

	private Long zoneId;
	private Integer seatNo;
	private Date startDate;

}
