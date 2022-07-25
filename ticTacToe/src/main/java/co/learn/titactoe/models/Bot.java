package co.learn.titactoe.models;

import co.learn.titactoe.factories.BotPlayingStrategyFactory;
import co.learn.titactoe.models.Enum.BotDifficultyLevelEnum;
import co.learn.titactoe.models.Enum.PlayerTypeEnum;
import co.learn.titactoe.strategies.bot.BotPlayingStrategy;

public class Bot extends Player{
    private BotPlayingStrategy botPlayingStrategy;
    private BotDifficultyLevelEnum botDifficultyLevelEnum;

    public Bot(Symbol symbol,BotDifficultyLevelEnum botDifficultyLevelEnum ){
        super(symbol, PlayerTypeEnum.BOT);
        this.botDifficultyLevelEnum = botDifficultyLevelEnum;
        this.botPlayingStrategy = new BotPlayingStrategyFactory().createBotPlayingStrategyForDifficultyLevel(this.botDifficultyLevelEnum);
    }

    Move makeMove(Board board) {
        return this.botPlayingStrategy.makeNextMove(board,this);
    }
}
