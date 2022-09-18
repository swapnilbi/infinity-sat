package com.sat.repository;


import com.sat.entity.SeatBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface SeatBookingRepository extends JpaRepository<SeatBooking, Long> {

    List<SeatBooking> findByEmployeeId(Long employeeId);

    Optional<SeatBooking> findByEmployeeIdAndStartDate(Long employeeId, Date startDate);

    Optional<SeatBooking> findByZoneIdAndSeatNumberAndStartDate(Long zoneId, Integer seatNo, Date startDate);

    List<SeatBooking> findByZoneIdAndStartDate(Long zoneId, Date startDate);

    List<SeatBooking> findByFloorIdAndStartDate(Long floorId, Date startDate);

}
