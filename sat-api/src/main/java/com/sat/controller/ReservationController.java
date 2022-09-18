package com.sat.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sat.exception.BusinessException;
import com.sat.model.CreateReservationDetails;
import com.sat.model.Response;
import com.sat.model.SearchSeatInput;
import com.sat.model.SearchSeatResult;
import com.sat.service.IReservationService;
import com.sat.utility.SecurityHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "api/reservation")
@RestController
public class ReservationController {

    @Autowired
    private IReservationService reservationService;

    @GetMapping("init")
    public Response<CreateReservationDetails> initReservation() throws BusinessException {
        CreateReservationDetails reservationDetails = reservationService.initReservation(SecurityHelper.getEmployeeId());
        return new Response<>(reservationDetails);
    }

    @PostMapping("search")
    public Response<SearchSeatResult> searchSeats(@RequestBody SearchSeatInput searchSeatInput) throws BusinessException, JsonProcessingException {
        SearchSeatResult searchSeatResult = reservationService.searchSeats(searchSeatInput, SecurityHelper.getEmployeeId());
        return new Response<>(searchSeatResult);
    }

}
