package com.sat.controller;

import com.sat.entity.SeatAllotment;
import com.sat.entity.SpaceCapacity;
import com.sat.exception.BusinessException;
import com.sat.model.*;
import com.sat.service.IAllotmentService;
import com.sat.utility.SecurityHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "api/space")
@RestController
public class SpaceAllocationController {

    @Autowired
    private IAllotmentService allotmentService;

    @GetMapping("/allotment/init")
    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER')")
    public Response<CreateAllotmentDetails> initAllotment() throws BusinessException {
        CreateAllotmentDetails allotmentDetails = allotmentService.initAllotment();
        return new Response<>(allotmentDetails);
    }

    @PostMapping("allotment")
    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER')")
    public Response<SeatAllotment> saveAllotment(@RequestBody AllotmentInput allotmentInput) throws BusinessException {
        SeatAllotment seatAllotment = allotmentService.saveAllotment(allotmentInput);
        return new Response<>(seatAllotment);
    }

    @DeleteMapping("allotment/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER')")
    public Response saveAllotment(@PathVariable Long id) throws BusinessException {
        allotmentService.deleteAllotment(id);
        return new Response<>();
    }

    @PostMapping("allotment/split")
    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER')")
    public Response<SeatAllotment> splitAllotment(@RequestBody SplitAllotmentInput splitAllotmentInput) throws BusinessException {
        SeatAllotment seatAllotment = allotmentService.splitAllotment(splitAllotmentInput);
        return new Response<>(seatAllotment);
    }

    @GetMapping("allotment/zone/{zoneId}")
    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER')")
    public Response<List<SeatAllotment>> getAllotmentByZone(@PathVariable Long zoneId) throws BusinessException {
        List<SeatAllotment> seatAllotmentList = allotmentService.getAllotmentByZone(zoneId);
        return new Response<>(seatAllotmentList);
    }

    @GetMapping("capacity")
    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER')")
    public Response<List<SpaceCapacity>> getSpaceCapacity() throws BusinessException {
        List<SpaceCapacity> spaceCapacityList = allotmentService.getSpaceCapacity();
        return new Response<>(spaceCapacityList);
    }

    @GetMapping("allotments")
    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER')")
    public Response<List<AllotmentDetails>> getAllotmentList() throws BusinessException {
        List<AllotmentDetails> allotmentDetails = allotmentService.getAllotmentList();
        return new Response<>(allotmentDetails);
    }


    @GetMapping("allotment/splits")
    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER')")
    public Response<List<AllotmentDetails>> getSplittedAllotmentList() throws BusinessException {
        List<AllotmentDetails> allotmentDetails = allotmentService.getSplittedAllotments(SecurityHelper.getEmployeeId());
        return new Response<>(allotmentDetails);
    }

    @GetMapping("allotment/manager")
    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER')")
    public Response<List<AllotmentDetails>> getManagerAllotmentList() throws BusinessException {
        List<AllotmentDetails> allotmentDetails = allotmentService.getManagerAllotmentList(SecurityHelper.getEmployeeId());
        return new Response<>(allotmentDetails);
    }

}
