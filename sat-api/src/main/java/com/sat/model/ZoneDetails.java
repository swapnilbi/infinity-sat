package com.sat.model;

import com.sat.entity.Zone;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
public class ZoneDetails {

	private long id;
	private String name;
	private Integer totalNoSeats;
	private Long floorId;

	public ZoneDetails(Zone zone){
		this.id = zone.getId();
		this.name = zone.getName();
		this.totalNoSeats = zone.getTotalNoSeats();
		this.floorId = zone.getFloorId();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ZoneDetails zone = (ZoneDetails) o;
		return id == zone.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
