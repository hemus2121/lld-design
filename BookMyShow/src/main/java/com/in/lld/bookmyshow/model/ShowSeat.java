package com.in.lld.bookmyshow.model;

import com.in.lld.bookmyshow.model.enums.SeatStatus;
import lombok.Data;

@Data
public class ShowSeat extends BaseModel {
    private Show show;
    private Seats seats;
    private SeatStatus seatStatus;
}
