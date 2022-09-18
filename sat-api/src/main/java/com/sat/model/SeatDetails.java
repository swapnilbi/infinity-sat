package com.sat.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
public class SeatDetails {

    private Integer number;
    private boolean hide;
    private boolean booked;
    private String bookedBy;
    private Date date;
}
