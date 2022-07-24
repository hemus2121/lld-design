package co.learn.titactoe.models;

import co.learn.titactoe.strategies.winning.WinningStrategy;

import java.util.List;

public class Game {
    int lastMovedPlayerIndex;
    Player winner;
    Board board;
    List<WinningStrategy> winningStrategyList;
    List<Player> playerList;
    List<Move> moveList;


}
