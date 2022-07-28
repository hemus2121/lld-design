package com.in.lld.bookmyshow.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.*;

//@MappedSuperclass
public  class BaseModel {
  //  @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private LocalTime createdTime;
    private LocalTime modifiedTime;
}
