package org.scaler.ttt.strategy.botplaying;

import org.scaler.ttt.models.Board;
import org.scaler.ttt.models.Cell;
import org.scaler.ttt.models.Move;
import org.scaler.ttt.models.Player;

import java.util.List;
import java.util.Objects;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move makeNextMove(Board board, Player player) {
        for (int i =0;i < board.getGrid().size();i++){
            List<Cell> row = board.getGrid().get(i);
            for (Cell cell : row){
                if (Objects.isNull(cell.getSymbol())){
                    cell.setSymbol(player.getSymbol());
                    Move move = new Move();
                    move.setPlayer(player);
                    move.setCell(cell);
                    return  move;
                }
            }
        }
        return null;
    }
}
