package com.sat.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sat.entity.SeatBooking;
import com.sat.exception.BusinessException;
import com.sat.model.*;

import java.util.Date;
import java.util.List;

public interface IReservationService {

    CreateReservationDetails initReservation(Long employeeId);

    SearchSeatResult searchSeats(SearchSeatInput searchSeatInput, Long userId) throws JsonProcessingException, BusinessException;

    SeatBooking bookSeat(BookSeatInput bookSeatInput, Long employeeId) throws BusinessException;

    List<SeatBooking> searchSeatBookings(Long zoneId, Date startDate) throws BusinessException;

    List<SeatBookingDetails> getBookingHistory(Long employeeId);

    List<SeatDetails> getNextBookingSlots(BookSeatInput bookSeatInput);
}
