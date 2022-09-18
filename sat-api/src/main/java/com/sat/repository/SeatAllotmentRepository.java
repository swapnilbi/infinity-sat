package com.sat.repository;


import com.sat.entity.SeatAllotment;
import com.sat.entity.SpaceCapacity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SeatAllotmentRepository extends JpaRepository<SeatAllotment, Long> {

    @Query(nativeQuery = true, value = "SELECT \n" +
            "    o.name office,\n" +
            "    f.name floor,\n" +
            "    z.name zone,\n" +
            "    z.total_no_seats as totalNoSeats,\n" +
            "    IFNULL(sa.alloted_seats, 0) allotedSeats    \n" +
            "FROM\n" +
            "    office o\n" +
            "        LEFT JOIN\n" +
            "    floor f ON o.id = f.office_id\n" +
            "        LEFT JOIN\n" +
            "    zone z ON f.id = z.floor_id\n" +
            "        LEFT JOIN (\n" +
            "        select zone_id, sum(max_no_seats) alloted_seats from seat_allotment s\n" +
            "        group by zone_id\n" +
            "\t ) as sa        \n" +
            "    ON z.id = sa.zone_id\n" +
            "ORDER BY office , floor , zone")
    List<SpaceCapacity> getSpaceCapacity();

    List<SeatAllotment> findByZoneId(Long zoneId);

    List<SeatAllotment> findByParentId(Long parentId);

    List<SeatAllotment> findByDivisionId(Long divisinId);

    List<SeatAllotment> findByFloorIdAndDivisionId(Long floorId, Long divisionId);

    @Query(value = "SELECT u FROM SeatAllotment u WHERE u.divisionId IN :divisionIdList")
    List<SeatAllotment> findByDivisionIds(@Param("divisionIdList") List<Long> divisionIdList);
}
