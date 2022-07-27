package co.learn.titactoe.simulator;


import co.learn.titactoe.controller.GameController;
import co.learn.titactoe.models.*;
import co.learn.titactoe.models.Enum.BotDifficultyLevelEnum;
import co.learn.titactoe.models.Enum.GameStatusEnum;
import co.learn.titactoe.models.Enum.PlayerTypeEnum;
import co.learn.titactoe.strategies.winning.GameWinningStrategy;
import co.learn.titactoe.strategies.winning.OrderOneWinningStrategy;

import java.util.List;


public class GameSimulator {
    public static void main(String[] args) {

        //create players

        Player player1 = new HumanPlayer(PlayerTypeEnum.HUMAN, new Symbol('X'),"hemanth");
        Player player2 = new Bot(PlayerTypeEnum.BOT,  new Symbol('O'), BotDifficultyLevelEnum.EASY, "bot");
        List<Player> playerList = List.of(player1, player2);

        //create strategy
        GameWinningStrategy gameWinningStrategy = new OrderOneWinningStrategy();
        List<GameWinningStrategy> gameWinningStrategyList = List.of(gameWinningStrategy);

        //instantiate Controller to create game with players and strategy
        GameController gameController = new GameController();
        Game game = gameController.createGame(3, playerList, gameWinningStrategyList);

        gameController.display(game);

        while (!gameController.getGameStatus(game).equals( GameStatusEnum.ENDED)){
            System.out.println("Enter your next step");
            gameController.makeMove(game);
            gameController.display(game);
        }
        System.out.println("Game has ended");
        System.out.println("Winner is:"+ gameController.getWinner(game).getName());
    }
}
