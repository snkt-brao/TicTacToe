package models;

import lombok.Getter;
import lombok.Setter;
import models.enums.DifficultyLevel;

@Getter
@Setter
public class BotPlayer extends Player {
    private DifficultyLevel difficultyLevel;
}
