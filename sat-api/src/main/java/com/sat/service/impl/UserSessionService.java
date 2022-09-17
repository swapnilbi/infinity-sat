package com.sat.service.impl;

import com.sat.entity.UserSession;
import com.sat.repository.UserSessionRepository;
import com.sat.service.IUserSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UserSessionService implements IUserSessionService {

	@Autowired
	UserSessionRepository userSessionRepository;

	@Override
	public UserSession createUserSession(UserSession userSession) {
		return userSessionRepository.save(userSession);
	}

	@Override
	public Optional<UserSession> getActiveUserSession(Long userId) {
		Optional<UserSession> optionalUserSession = userSessionRepository.findTop1ByUserIdOrderByLoginTimeDesc(userId);
		if(optionalUserSession.isPresent() && optionalUserSession.get().getLogoutTime()==null){
			return optionalUserSession;
		}
		return Optional.empty();
	}

	@Override
	public UserSession logoutUserSession(UserSession userSession) {
		userSession.setLogoutTime(new Date());
		return userSessionRepository.save(userSession);
	}

	@Override
	public void updateUserSession(UserSession userSession) {
		userSessionRepository.save(userSession);
	}
}
