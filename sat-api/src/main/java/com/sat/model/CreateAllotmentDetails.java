package com.sat.model;

import com.sat.entity.OEStructure;
import com.sat.entity.Office;
import lombok.Data;

import java.util.List;

@Data
public class CreateAllotmentDetails {

	private List<Office> officeList;
	private List<OEStructure> divisionList;

}
