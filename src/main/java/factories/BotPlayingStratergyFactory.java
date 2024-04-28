package factories;

import models.enums.BotDifficultyLevel;
import stratergies.BotStrateries.BotEasyPlayingStrategy;
import stratergies.BotStrateries.BotHardPlayingStrategy;
import stratergies.BotStrateries.BotMediumPlayingStrategy;
import stratergies.BotStrateries.BotPlayingStrategy;

public class BotPlayingStratergyFactory {
    public static BotPlayingStrategy getBotPlayingStratergy(BotDifficultyLevel botDifficultyLevel){
        switch (botDifficultyLevel){
            case EASY -> {
                return new BotEasyPlayingStrategy();
            }
            case MEDIUM -> {
                return  new BotMediumPlayingStrategy();
            }
            case HARD -> {
                return new BotHardPlayingStrategy();
            }
            default -> {
                throw new RuntimeException("Invalid difficulty level");
            }
        }
    }
}
