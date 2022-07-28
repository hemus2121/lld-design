package com.in.lld.bookmyshow.model;

import lombok.Data;

import javax.persistence.Entity;

@Data
//@Entity(name ="seats")
public class Seats extends BaseModel{
    private int number;
    private SeatType seatType;
}
