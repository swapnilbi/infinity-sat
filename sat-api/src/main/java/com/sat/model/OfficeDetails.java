package com.sat.model;

import com.sat.entity.Department;
import com.sat.entity.Floor;
import com.sat.entity.Office;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
public class OfficeDetails {

	private long id;
	private String name;
	private String address;
	private String city;
	private String country;
	private Set<Department> departmentList;
	private Set<FloorDetails> floorList = new HashSet<>();

	public OfficeDetails(Office office){
		this.id = office.getId();
		this.name = office.getName();
		this.address = office.getAddress();
		this.city = office.getCity();
		this.country = office.getCountry();
		this.departmentList = office.getDepartmentList();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		OfficeDetails office = (OfficeDetails) o;
		return id == office.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
