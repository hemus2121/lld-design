package com.in.lld.bookmyshow.model;

import com.in.lld.bookmyshow.model.enums.ShowFeatures;

import java.time.LocalTime;
import java.util.List;

public class Show extends BaseModel{
    private LocalTime startTime;
    private LocalTime endTime;
    private Auditorium auditorium;
    private String language;
    private List<ShowSeat> showSeatList;
    private ShowFeatures showFeatures;
}
