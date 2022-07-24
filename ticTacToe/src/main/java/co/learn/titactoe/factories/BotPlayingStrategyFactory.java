package co.learn.titactoe.factories;

import co.learn.titactoe.models.Enum.BotDifficultyLevelEnum;
import co.learn.titactoe.strategies.bot.BotPlayingStrategy;
import co.learn.titactoe.strategies.bot.RandomBotPlayingStrategy;

public class BotPlayingStrategyFactory {

    public BotPlayingStrategy createBotPlayingStrategyForDifficultyLevel (BotDifficultyLevelEnum botDifficultyLevelEnum){

        return switch(botDifficultyLevelEnum){
            case EASY, MEDIUM, HARD -> new RandomBotPlayingStrategy();
        };
    }
}
