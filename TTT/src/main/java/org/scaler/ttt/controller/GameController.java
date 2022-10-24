package org.scaler.ttt.controller;

import org.scaler.ttt.exceptions.InvalidUndoOperation;
import org.scaler.ttt.models.Board;
import org.scaler.ttt.models.Game;
import org.scaler.ttt.models.GameStatus;
import org.scaler.ttt.models.Player;
import org.scaler.ttt.strategy.winning.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    public Game createGame(int dimension, List<Player> playerList, List<WinningStrategy> winningStrategyList) throws Exception {
        return   new Game.Builder()
                .setBoard(new Board(dimension))
                .setPlayersList(playerList)
                .setMovesList(new ArrayList<>())
                .setWinningStrategyList(winningStrategyList)
                .setLastPlayerMovedIndex(-1)
                .setGameStatus(GameStatus.IN_PROGRESS)
                .build();
    }
    public void makeMove(Game game) throws InvalidUndoOperation {
        game.makeMove();
    }

    public void undo(Game game) throws InvalidUndoOperation{
        game.undo();
    }

    public GameStatus getGameStatus(Game game){
        return game.getGameStatus();
    }
    public Player getWinner(Game game){
        return game.getWinner();
    }
    public  void  disPlayBoard(Game game){
        game.getBoard().printBoard();
    }

}
