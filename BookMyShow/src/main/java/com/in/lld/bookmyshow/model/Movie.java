package com.in.lld.bookmyshow.model;

import com.in.lld.bookmyshow.model.enums.MovieFeatureEnum;
import lombok.Data;
import java.util.List;


@Data
//@Entity(name ="movie")
public class Movie extends BaseModel{
    private String name;
    private List<String> languageList;
    private List<String> castList;
    private MovieFeatureEnum movieFeatureEnum;
    private long duration;
    private int rating;
}
