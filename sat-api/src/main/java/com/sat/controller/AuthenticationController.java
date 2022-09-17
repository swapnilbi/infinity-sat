package com.sat.controller;

import com.sat.exception.SecurityException;
import com.sat.model.LoginInput;
import com.sat.model.LoginResponse;
import com.sat.model.Response;
import com.sat.service.IAuthenticationService;
import com.sat.utility.SecurityHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AuthenticationController {

	@Autowired
	private IAuthenticationService authenticationService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@RequestMapping(value = "api/authenticate", method = RequestMethod.POST)
	public ResponseEntity<Response<LoginResponse>> authenticate(@RequestBody LoginInput loginInput)
			throws SecurityException {
		System.out.println(passwordEncoder.encode(loginInput.getPassword()));
		String token = authenticationService.authenticate(loginInput);
		return ResponseEntity.ok(new Response<>(new LoginResponse(token)));
	}

	@RequestMapping(value = "api/authenticate/refresh", method = RequestMethod.POST)
	public ResponseEntity<Response<LoginResponse>> refreshToken() {
		String token = authenticationService.refreshToken(SecurityHelper.getEmployeeId());
		return ResponseEntity.ok(new Response<>(new LoginResponse(token)));
	}

	@RequestMapping(value = "api/logout", method = RequestMethod.GET)
	public ResponseEntity logout()
			throws SecurityException {
		authenticationService.logout(SecurityHelper.getEmployeeId());
		return  ResponseEntity.ok().build();
	}

}
