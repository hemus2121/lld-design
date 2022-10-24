package org.scaler.ttt.strategy.winning;

import org.scaler.ttt.models.Board;
import org.scaler.ttt.models.Cell;
import org.scaler.ttt.models.Player;

import java.util.List;

public class RowWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkIfWon(Board board, Cell cell, Player player) {

       List<Cell> row = board.getGrid().get(cell.getRow());
       for (Cell currCell: row){
           if (!player.getSymbol().equals(currCell.getSymbol())){
               return  false;
           }
       }
       return  true;
    }
}
