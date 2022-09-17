package com.sat.model;

import com.sat.entity.Employee;
import com.sat.enums.Gender;
import lombok.Data;

import java.util.List;

@Data
public class EmployeeProfile {

	private long id;
	private String fullName;
	private String email;
	private Gender gender;
	private List<String> roles;
	private Long departmentId;
	private Long oeId;
	private Long reportingTo;

	public EmployeeProfile(){

	}

	public static EmployeeProfile getEmployeeProfile(Employee user){
		EmployeeProfile userProfile = new EmployeeProfile();
		userProfile.setId(user.getId());
		userProfile.setDepartmentId(user.getDepartmentId());
		userProfile.setOeId(user.getOeId());
		userProfile.setReportingTo(user.getReportingTo());
		userProfile.setFullName(user.getFullName());
		return userProfile;
	}

	public EmployeeProfile(Employee user){
		this.id = user.getId();
		this.fullName = user.getFullName();
		this.email = user.getEmail();
		this.roles = user.getRoles();
		this.departmentId = user.getDepartmentId();
		this.reportingTo = user.getReportingTo();
		this.oeId = user.getOeId();
	}

}
