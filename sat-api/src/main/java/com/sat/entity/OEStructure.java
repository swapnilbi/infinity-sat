package com.sat.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "oe_structure")
public class OEStructure {

	@Id
	@GeneratedValue
	private long id;
	@Column(name = "code")
	private String code;
	@Column(name = "parent")
	private Long parentId;
	private Integer level;
	@Column(name = "department_id")
	private Long departmentId;

}
