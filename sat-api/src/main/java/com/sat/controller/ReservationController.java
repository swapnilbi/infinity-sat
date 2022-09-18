package com.sat.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sat.entity.SeatBooking;
import com.sat.exception.BusinessException;
import com.sat.model.*;
import com.sat.service.IReservationService;
import com.sat.utility.SecurityHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("book")
    public Response<SeatBooking> bookSeat(@RequestBody BookSeatInput bookSeatInput) throws BusinessException {
        SeatBooking seatBooking = reservationService.bookSeat(bookSeatInput, SecurityHelper.getEmployeeId());
        return new Response<>(seatBooking);
    }

    @PostMapping("book/nextSlots")
    public Response<List<SeatDetails>> getNextBookingSlots(@RequestBody BookSeatInput bookSeatInput) throws BusinessException {
        List<SeatDetails> nextBookingSlots = reservationService.getNextBookingSlots(bookSeatInput);
        return new Response<>(nextBookingSlots);
    }

    @GetMapping("book/history")
    public Response<List<SeatBookingDetails>> getBookingHistory() throws BusinessException {
        List<SeatBookingDetails> bookingHistory = reservationService.getBookingHistory( SecurityHelper.getEmployeeId());
        return new Response<>(bookingHistory);
    }

}
