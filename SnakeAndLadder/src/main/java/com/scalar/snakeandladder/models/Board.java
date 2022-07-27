package com.scalar.snakeandladder.models;

import lombok.Data;
import java.util.Map;

@Data
public class Board{
    private int dimension;
    private  Map<Integer, ForeignEntity> foreignEntityMap;

    public Board(int dimension, Map<Integer, ForeignEntity> foreignEntityMap){
        this.dimension = dimension;
        this.foreignEntityMap = foreignEntityMap;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }


}
