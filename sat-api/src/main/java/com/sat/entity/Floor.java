package com.sat.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "floor")
public class Floor {

	@Id
	@GeneratedValue
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "office_id")
	private Long officeId;

	@Column(name = "floor_layout")
	private String floorLayout;

	@OneToMany(mappedBy="floorId", fetch = FetchType.EAGER)
	private Set<Zone> zoneList;

	public Floor(Long id){
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Floor floor = (Floor) o;
		return id == floor.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
