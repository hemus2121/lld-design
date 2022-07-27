package com.scalar.snakeandladder.models;

import com.scalar.snakeandladder.models.enums.ForeignEntityTypeEnum;
import lombok.Data;

@Data
public abstract  class ForeignEntity {
    private int from;
    private int to;
    private ForeignEntityTypeEnum foreignEntityType;
}
