package com.scalar.snakeandladder.strategy;

import com.scalar.snakeandladder.models.Board;
import com.scalar.snakeandladder.models.Button;

public interface HandleMoveStrategy {
    void move(Button button, int value, Board board);

}
