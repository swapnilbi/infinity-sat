package com.sat.repository;


import com.sat.entity.Office;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OfficeRepository extends JpaRepository<Office, Long> {

    Optional<Office> findByName(String code);
}
