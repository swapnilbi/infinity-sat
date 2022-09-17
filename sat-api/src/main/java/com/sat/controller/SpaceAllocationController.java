package com.sat.controller;

import com.sat.entity.Employee;
import com.sat.entity.SeatAllotment;
import com.sat.entity.SpaceCapacity;
import com.sat.exception.BusinessException;
import com.sat.model.AllotmentDetails;
import com.sat.model.AllotmentInput;
import com.sat.model.CreateAllotmentDetails;
import com.sat.model.Response;
import com.sat.service.IAllotmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(value = "api/space")
@RestController
public class SpaceAllocationController {

    @Autowired
    private IAllotmentService allotmentService;

    @GetMapping("/allotment/init")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Response<CreateAllotmentDetails> initAllotment() throws BusinessException {
        CreateAllotmentDetails allotmentDetails = allotmentService.initAllotment();
        return new Response<>(allotmentDetails);
    }

    @PostMapping("allotment")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Response<SeatAllotment> saveAllotment(@RequestBody AllotmentInput allotmentInput) throws BusinessException {
        SeatAllotment seatAllotment = allotmentService.saveAllotment(allotmentInput);
        return new Response<>(seatAllotment);
    }

    @GetMapping("allotment/zone/{zoneId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Response<List<SeatAllotment>> getAllotmentByZone(@PathVariable Long zoneId) throws BusinessException {
        List<SeatAllotment> seatAllotmentList = allotmentService.getAllotmentByZone(zoneId);
        return new Response<>(seatAllotmentList);
    }

    @GetMapping("capacity")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Response<List<SpaceCapacity>> getSpaceCapacity() throws BusinessException {
        List<SpaceCapacity> spaceCapacityList = allotmentService.getSpaceCapacity();
        return new Response<>(spaceCapacityList);
    }

    @GetMapping("allotments")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Response<List<AllotmentDetails>> getAllotmentList() throws BusinessException {
        List<AllotmentDetails> allotmentDetails = allotmentService.getAllotmentList();
        return new Response<>(allotmentDetails);
    }

}
