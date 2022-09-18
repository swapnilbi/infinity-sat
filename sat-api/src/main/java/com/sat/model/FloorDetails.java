package com.sat.model;

import com.sat.entity.Floor;
import com.sat.entity.Zone;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
public class FloorDetails {

	private long id;
	private String name;
	private Long officeId;
	private Set<ZoneDetails> zoneList = new HashSet<>();

	public FloorDetails(Floor floor){
		this.id = floor.getId();
		this.name = floor.getName();
		this.officeId =  floor.getOfficeId();
	}

	public FloorDetails(Long id){
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FloorDetails floor = (FloorDetails) o;
		return id == floor.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
