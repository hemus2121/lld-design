package org.scaler.ttt;

import org.scaler.ttt.controller.GameController;
import org.scaler.ttt.models.*;
import org.scaler.ttt.strategy.botplaying.BotPlayingStrategy;
import org.scaler.ttt.strategy.botplaying.EasyBotPlayingStrategy;
import org.scaler.ttt.strategy.winning.ColumnWinningStrategy;
import org.scaler.ttt.strategy.winning.DiagonalWinningStrategy;
import org.scaler.ttt.strategy.winning.RowWinningStrategy;
import org.scaler.ttt.strategy.winning.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class GameSimulator {
    public static void main(String[] args) throws Exception {
        int dimension =3;
        List<Player> playerList = new ArrayList<>();
        List<WinningStrategy> winningStrategyList = List.of(new RowWinningStrategy(), new ColumnWinningStrategy(), new DiagonalWinningStrategy());

        BotPlayingStrategy botPlayingStrategy = new EasyBotPlayingStrategy();

        Player p1 = new HumanPlayer("p1",new Symbol('x'));
        //String name,Symbol symbol, DifficultyLevel difficultyLevel, BotPlayingStrategy botPlayingStrategy
        Player p2 = new BotPlayer("b1", new Symbol('y'), DifficultyLevel.EASY, botPlayingStrategy);

        playerList.add(p1);
        playerList.add(p2);

        GameController controller = new GameController();
        Game game = controller.createGame(dimension,playerList,winningStrategyList);

        while (game.getGameStatus().equals(GameStatus.IN_PROGRESS)){
            controller.makeMove(game);
            controller.disPlayBoard(game);
        }

        if (GameStatus.DRAW.equals(game.getGameStatus())) {
            System.out.println("Game Drawn");
        }

        if (GameStatus.FINISHED.equals(game.getGameStatus())) {
            System.out.println("Winner is " + game.getWinner().getSymbol());
        }
    }
}
