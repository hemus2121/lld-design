package com.in.lld.bookmyshow.model;

import com.in.lld.bookmyshow.model.enums.PaymentType;
import lombok.Data;
import java.time.LocalTime;

@Data
public class Payment extends  BaseModel{
    private long paymentReferenceId;
    private PaymentType paymentType;
    private LocalTime localTime;
    private double amount;
}
