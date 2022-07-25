package co.learn.titactoe.strategies.bot;

import co.learn.titactoe.models.Board;
import co.learn.titactoe.models.Cell;
import co.learn.titactoe.models.Move;
import co.learn.titactoe.models.Player;

import java.util.List;

public class RandomBotPlayingStrategy implements  BotPlayingStrategy{


    @Override
    public Move makeNextMove(Board board, Player player) {
        for (List<Cell> row: board.getBoard()) {
            for (Cell cell : row){
                if (cell.isEmpty()){
                    Move move = new Move();
                    move.setSymbol(player.getSymbol());
                    move.setCell(cell);
                    move.setPlayer(player);
                    return move;

                }
            }
        }
        return null;
    }
}
