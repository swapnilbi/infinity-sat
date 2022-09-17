package com.sat.repository;


import com.sat.entity.Floor;
import com.sat.entity.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ZoneRepository extends JpaRepository<Zone, Long> {

    Optional<Zone> findByName(String code);

    List<Zone> findByFloorId(Long floorId);
}
