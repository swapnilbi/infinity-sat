package com.sat.service.impl;

import com.sat.config.JwtTokenUtil;
import com.sat.entity.Employee;
import com.sat.entity.UserSession;
import com.sat.exception.SecurityException;
import com.sat.model.LoginInput;
import com.sat.service.IAuthenticationService;
import com.sat.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class AuthenticationService implements IAuthenticationService {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private IEmployeeService employeeService;

	@Autowired
	private UserSessionService userSessionService;

	@Override
	public String authenticate(LoginInput loginInput) throws SecurityException {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginInput.getUsername(), loginInput.getPassword()));
			final Employee employee = employeeService.getEmployeeByUsername(loginInput.getUsername()).get();
			UserSession userSession = createUserSession(employee);
			userSessionService.createUserSession(userSession);
			return userSession.getToken();
		} catch (DisabledException e) {
			throw new SecurityException("Your account has been disabled. Please contact administrator", e);
		} catch (BadCredentialsException e) {
			throw new SecurityException("Invalid username or password", e);
		}
	}

	private UserSession createUserSession(Employee user){
		Date issueAt = new Date(System.currentTimeMillis());
		Date expiredAt = new Date(System.currentTimeMillis() + JwtTokenUtil.JWT_TOKEN_VALIDITY*1000);
		String token = jwtTokenUtil.generateToken(user,issueAt,expiredAt);
		return new UserSession(user.getId(),token,issueAt,expiredAt);
	}

	@Override
	public void logout(Long userId) {
		Optional<UserSession> userSession = userSessionService.getActiveUserSession(userId);
		if(userSession.isPresent()){
			userSessionService.logoutUserSession(userSession.get());
		}
	}

	@Override
	public boolean validateToken(String token, Employee employee) {
		if(jwtTokenUtil.validateToken(token, employee)){
			Optional<UserSession> userSession = userSessionService.getActiveUserSession(employee.getId());
			if(userSession.isPresent() || (userSession.isPresent() && userSession.get().getLogoutTime()==null)){
				return true;
			}
		}
		return false;
	}

	@Override
	public String refreshToken(Long userId) {
		final Employee user = employeeService.getEmployeeById(userId).get();
		UserSession userSession = createUserSession(user);
		Optional<UserSession> existingSession = userSessionService.getActiveUserSession(userSession.getUserId());
		if(existingSession.isPresent()){
			userSession.setId(existingSession.get().getId());
			userSession.setLoginTime(existingSession.get().getLoginTime());
			userSessionService.updateUserSession(userSession);
		}else{
			userSessionService.createUserSession(userSession);
		}
		return userSession.getToken();
	}

}
