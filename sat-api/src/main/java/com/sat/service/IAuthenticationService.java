package com.sat.service;

import com.sat.entity.Employee;
import com.sat.exception.SecurityException;
import com.sat.model.LoginInput;

public interface IAuthenticationService {

    String authenticate(LoginInput loginInput) throws SecurityException;

    void logout(Long userId) throws SecurityException;

    boolean validateToken(String token, Employee user);

    String refreshToken(Long userId);
}
