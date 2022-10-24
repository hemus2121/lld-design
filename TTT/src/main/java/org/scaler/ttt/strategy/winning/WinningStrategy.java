package org.scaler.ttt.strategy.winning;

import org.scaler.ttt.models.Board;
import org.scaler.ttt.models.Cell;
import org.scaler.ttt.models.Player;

public interface WinningStrategy {
    boolean checkIfWon(Board board, Cell cell, Player player);

}
