package com.sat.repository;

import com.sat.entity.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserSessionRepository extends JpaRepository<UserSession, Long> {
    Optional<UserSession> findTop1ByUserIdOrderByLoginTimeDesc(Long userId);
}
