package org.scaler.ttt.strategy.botplaying;

import org.scaler.ttt.models.Board;
import org.scaler.ttt.models.Move;
import org.scaler.ttt.models.Player;

public interface BotPlayingStrategy {
    Move makeNextMove(Board board, Player player);

}
