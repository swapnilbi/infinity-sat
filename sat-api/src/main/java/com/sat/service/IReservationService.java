package com.sat.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sat.model.CreateReservationDetails;
import com.sat.model.SearchSeatInput;
import com.sat.model.SearchSeatResult;

public interface IReservationService {

    CreateReservationDetails initReservation(Long employeeId);

    SearchSeatResult searchSeats(SearchSeatInput searchSeatInput, Long userId) throws JsonProcessingException;
}
