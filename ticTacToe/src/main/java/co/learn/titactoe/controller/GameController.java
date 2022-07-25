package co.learn.titactoe.controller;

import co.learn.titactoe.exception.EmptyMoveUndoOperationException;
import co.learn.titactoe.exception.MultipleBotException;
import co.learn.titactoe.models.Enum.GameStatusEnum;
import co.learn.titactoe.models.Game;
import co.learn.titactoe.models.Player;
import co.learn.titactoe.strategies.winning.GameWinningStrategy;

import java.util.List;

public class GameController {

    public Game createGame(int dimension, List<Player> playerList, List<GameWinningStrategy> winningStrategyList){
        Game game = null;
        try {
            game = Game.create()
                        .setDimension(dimension)
                        .addGameWinningStrategies(winningStrategyList)
                        .addPlayers(playerList).build();
        } catch (MultipleBotException e) {
            throw new RuntimeException(e);
        }
        return game;
    }

    public void makeMove(Game game){
        game.makeMove();;
    }

    public boolean undo(Game game) throws EmptyMoveUndoOperationException {
        return game.undo();
    }

    public Player getWinner(Game game){
        return game.getWinner();
    }
    public GameStatusEnum getGameStatus(Game game){
        return game.getGameStatusEnum();
    }
    public void display(Game game){
        game.getBoard().display();
    }

}
