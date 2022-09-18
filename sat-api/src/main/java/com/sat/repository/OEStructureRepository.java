package com.sat.repository;


import com.sat.entity.OEStructure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OEStructureRepository extends JpaRepository<OEStructure, Long> {

    Optional<OEStructure> findByCode(String code);

    List<OEStructure> findByParentId(Long parentId);

    @Query(value = "SELECT u FROM OEStructure u WHERE u.departmentId IN :names")
    List<OEStructure> findByDepartmentId(@Param("names") List<Long> departmentIds);

}
