package models;

import exceptions.InvalidMoveException;
import factories.BotPlayingStratergyFactory;
import lombok.Getter;
import lombok.Setter;
import models.enums.BotDifficultyLevel;
import models.enums.PlayerType;
import stratergies.BotStrateries.BotPlayingStrategy;

@Getter
@Setter
public class Bot extends Player {
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStratergy;

    public Bot(Symbol symbol, String name, PlayerType playerType, BotDifficultyLevel botDifficultyLevel) {
        super(symbol, name, playerType);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStratergy = BotPlayingStratergyFactory.getBotPlayingStratergy(botDifficultyLevel);
    }

    @Override
    public Move makeMove(Board board) throws InvalidMoveException {
        return botPlayingStratergy.makeMove(board);
    }
}
