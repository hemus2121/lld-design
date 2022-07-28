package com.in.lld.bookmyshow.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

//@Entity(name ="city")
@Data
public class City extends BaseModel{
    private String name;
    private String zipcode;
    private List<Theatre> theatresList;
}
