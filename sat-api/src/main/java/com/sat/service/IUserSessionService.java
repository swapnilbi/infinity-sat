package com.sat.service;

import com.sat.entity.UserSession;

import java.util.Optional;

public interface IUserSessionService {

    UserSession createUserSession(UserSession userSession);

    Optional<UserSession> getActiveUserSession(Long userId);

    UserSession logoutUserSession(UserSession userSession);

    void updateUserSession(UserSession userSession);
}
