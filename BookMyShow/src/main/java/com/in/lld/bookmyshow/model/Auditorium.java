package com.in.lld.bookmyshow.model;

import com.in.lld.bookmyshow.model.enums.AudiFeatures;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

//@Entity(name ="auditorium")
public class Auditorium extends BaseModel{
    private int capacity;
    private int name;
    private int number;
    private List<Seats> seatsList;
    private AudiFeatures audiFeatures;
}
