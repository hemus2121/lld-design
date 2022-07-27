package com.scalar.snakeandladder.models;

import com.scalar.snakeandladder.models.enums.ButtonStatusEnum;
import lombok.Data;

@Data
public class Button {
    private int position;
    private ButtonStatusEnum buttonStatus;
}
