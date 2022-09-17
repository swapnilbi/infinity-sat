package com.sat.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
@Table(name = "department")
public class Department {

	@Id
	@GeneratedValue
	private long id;
	@Column(name = "name")
	private String name;

}
