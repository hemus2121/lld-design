package co.learn.titactoe.strategies.winning;

import co.learn.titactoe.models.Board;
import co.learn.titactoe.models.Cell;
import co.learn.titactoe.models.Player;

public interface GameWinningStrategy {
    boolean checkIfWon(Board board, Player player, Cell cell);
}
