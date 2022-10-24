package org.scaler.ttt.Factory;

import org.scaler.ttt.models.DifficultyLevel;
import org.scaler.ttt.strategy.botplaying.BotPlayingStrategy;
import org.scaler.ttt.strategy.botplaying.EasyBotPlayingStrategy;
import org.scaler.ttt.strategy.botplaying.HardBotPlayingStrategy;
import org.scaler.ttt.strategy.botplaying.MediumBotPlayingStrategy;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy createPlayingStrategy(DifficultyLevel difficultyLevel) {
        BotPlayingStrategy botPlayingStrategy = null;
        switch (difficultyLevel) {
            case EASY:
                botPlayingStrategy = new EasyBotPlayingStrategy();
                break;
            case MEDIUM:
                botPlayingStrategy = new MediumBotPlayingStrategy();
                break;
            case HARD:
                botPlayingStrategy = new HardBotPlayingStrategy();
                break;
        }
        return botPlayingStrategy;
    }

}
