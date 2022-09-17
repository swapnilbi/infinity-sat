package com.sat.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user_session")
public class UserSession {

	@Transient
	public static final String SEQUENCE_NAME = "user_session_sequence";

	public UserSession(Long userId, String token, Date loginTime, Date tokenExpiresAt){
		this.userId = userId;
		this.token = token;
		this.loginTime = loginTime;
		this.tokenExpiresAt = tokenExpiresAt;
	}

	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "user_id")
	private Long userId;
	private String token;
	@Column(name = "login_time")
	private Date loginTime;
	@Column(name = "logout_time")
	private Date logoutTime;
	@Column(name = "token_expires_at")
	private Date tokenExpiresAt;

}
