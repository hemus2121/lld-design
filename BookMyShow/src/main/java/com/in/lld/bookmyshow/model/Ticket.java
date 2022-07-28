package com.in.lld.bookmyshow.model;

import lombok.Data;
import java.util.List;

@Data
public class Ticket extends BaseModel{
     private double amount;
     private List<Seats> seatsList;
     private Show show;
     private Payment payment;

}
