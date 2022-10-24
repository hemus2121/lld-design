package org.scaler.ttt.models;

import org.scaler.ttt.Factory.BotPlayingStrategyFactory;
import org.scaler.ttt.strategy.botplaying.BotPlayingStrategy;

public class BotPlayer extends  Player{

    private DifficultyLevel difficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public BotPlayer(String name,Symbol symbol, DifficultyLevel difficultyLevel, BotPlayingStrategy botPlayingStrategy){
        super(name, symbol, PlayerType.BOT);
        this.difficultyLevel = difficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.createPlayingStrategy(this.difficultyLevel);
    }
    @Override
    public Move makeMove(Board board) {
        return this.botPlayingStrategy.makeNextMove(board, this);
    }
}
