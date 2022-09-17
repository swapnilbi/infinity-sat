package com.sat.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
@Table(name = "employee")
public class Employee implements UserDetails {

	@Id
	@GeneratedValue
	private long id;
	@Column(name = "username")
	private String username;
	@Column(name = "department_id")
	private Long departmentId;
	@Column(name = "oe_id")
	private Long oeId;
	@Column(name = "reporting_to")
	private Long reportingTo;
	@Column(name = "password")
	private String password;
	@Column(name = "full_name")
	private String fullName;
	@Column(name = "email")
	private String email;

	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles = new ArrayList<>();
	private boolean isActive = Boolean.TRUE;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		if(!roles.isEmpty()){
			for(String role:roles) {
				grantedAuthorities.add(new SimpleGrantedAuthority(role));
			}
		}
		return grantedAuthorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return isActive;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return isActive;
	}
}
