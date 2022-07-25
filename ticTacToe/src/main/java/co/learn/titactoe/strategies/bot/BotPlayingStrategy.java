package co.learn.titactoe.strategies.bot;

import co.learn.titactoe.models.Board;
import co.learn.titactoe.models.Move;
import co.learn.titactoe.models.Player;

public interface BotPlayingStrategy {

    Move makeNextMove(Board board, Player player);

}
