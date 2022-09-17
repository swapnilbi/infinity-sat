package com.sat.entity;

import lombok.Data;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "office")
public class Office {

	@Id
	@GeneratedValue
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "address")
	private String address;
	@Column(name = "city")
	private String city;
	@Column(name = "country")
	private String country;

	@OneToMany(mappedBy = "officeId", fetch = FetchType.LAZY)
	private Set<Department> departmentList;

	@OneToMany(mappedBy="officeId", fetch = FetchType.LAZY)
	private Set<Floor> floorList;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Office office = (Office) o;
		return id == office.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
