package com.sat.repository;


import com.sat.entity.Floor;
import com.sat.entity.Office;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FloorRepository extends JpaRepository<Floor, Long> {

    Optional<Floor> findByName(String code);

    List<Floor> findByOfficeId(Long officeId);

}
