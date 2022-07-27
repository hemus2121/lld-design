package com.scalar.snakeandladder.strategy;

public class DiceRollUnlockStrategy implements UnlockButtonMoveStrategy{

    @Override
    public boolean canUnlock(int value) {
        return false;
    }
}
