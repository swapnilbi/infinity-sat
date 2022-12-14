package com.sat.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "oe_structure")
public class OEStructure {

	@Id
	@GeneratedValue
	private long id;
	@Column(name = "code")
	private String code;
	@Column(name = "name")
	private String name;
	@Column(name = "parent")
	private Long parentId;
	private Integer level;
	@Column(name = "department_id")
	private Long departmentId;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		OEStructure that = (OEStructure) o;
		return id == that.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
