package com.sat.service;

import com.sat.entity.SeatAllotment;
import com.sat.entity.SpaceCapacity;
import com.sat.exception.BusinessException;
import com.sat.model.AllotmentDetails;
import com.sat.model.AllotmentInput;
import com.sat.model.CreateAllotmentDetails;

import java.util.List;

public interface IAllotmentService {

    SeatAllotment saveAllotment(AllotmentInput allotmentInput) throws BusinessException;

    List<SpaceCapacity> getSpaceCapacity();

    List<AllotmentDetails> getAllotmentList();

    CreateAllotmentDetails initAllotment() throws BusinessException;

    List<SeatAllotment> getAllotmentByZone(Long zoneId);

    List<AllotmentDetails> getManagerAllotmentList(Long employeeId);
}
