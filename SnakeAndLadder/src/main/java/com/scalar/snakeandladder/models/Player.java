package com.scalar.snakeandladder.models;

import lombok.Data;
import java.util.List;

@Data
public class Player {
    private String name;
    private int id;
    private List<Button> buttonList;
    private String color;
}
