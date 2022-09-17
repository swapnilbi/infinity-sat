package com.sat.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "zone")
public class Zone {

	@Id
	@GeneratedValue
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "total_no_seats")
	private Integer totalNoSeats;

	@Column(name = "floor_id")
	private Long floorId;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Zone zone = (Zone) o;
		return id == zone.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
