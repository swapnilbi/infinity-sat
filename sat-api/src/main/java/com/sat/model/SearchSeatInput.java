package com.sat.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class SearchSeatInput {

	private Long officeId;
	private Long floorId;
	private Date startDate;

}
