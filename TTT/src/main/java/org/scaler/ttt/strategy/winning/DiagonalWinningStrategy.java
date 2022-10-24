package org.scaler.ttt.strategy.winning;

import org.scaler.ttt.models.Board;
import org.scaler.ttt.models.Cell;
import org.scaler.ttt.models.Player;

public class DiagonalWinningStrategy implements  WinningStrategy{
    @Override
    public boolean checkIfWon(Board board, Cell cell, Player player) {
        return checkLeftDiagonal(board,cell, player) || checkRightDiagonal(board,cell,player);
    }
    boolean checkLeftDiagonal(Board board, Cell cell, Player player){
        for (int row = 0; row < board.getDimension(); row++) {
            Cell currCell = board.getGrid().get(row).get(row);
            if (!player.getSymbol().equals(currCell.getSymbol())) {
                return false;
            }
        }
        return true;
    }

    boolean checkRightDiagonal(Board board, Cell cell, Player player){
        int column = board.getDimension() - 1;
        for (int row = 0; row < board.getDimension(); row++) {
            Cell currCell = board.getGrid().get(row).get(column--);
            if (!player.getSymbol().equals(currCell.getSymbol())) {
                return false;
            }
        }
        return true;
    }


}
