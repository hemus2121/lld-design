package org.scaler.ttt.strategy.winning;

import org.scaler.ttt.models.Board;
import org.scaler.ttt.models.Cell;
import org.scaler.ttt.models.Player;

public class ColumnWinningStrategy implements  WinningStrategy{
    @Override
    public boolean checkIfWon(Board board, Cell cell, Player player) {
        int column = cell.getCol();
        for (int row =0;row < board.getDimension();row++){
            Cell currCell = board.getGrid().get(row).get(column);
            if (!player.getSymbol().equals(currCell.getSymbol())){
            return  false;
            }
        }
        return  true;
    }
}
