package com.in.lld.bookmyshow.model;

import lombok.Data;

import javax.persistence.Entity;
import java.util.List;

@Data
//@Entity( name ="theatre")
public class Theatre  extends  BaseModel{
    private String name;
    private String address;
    private List<Auditorium> auditoriumList;
    //private List<String> upcomingShowsList;
    private City city;

}
