package com.sat.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class SeatDetails {

    private Integer number;
    private boolean hide;
    private boolean booked;
    private String bookedBy;

}
