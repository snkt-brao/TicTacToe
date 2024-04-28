package stratergies.BotStrateries;

import exceptions.InvalidMoveException;
import models.Board;
import models.Move;

public interface BotPlayingStrategy {
    Move makeMove(Board board) throws InvalidMoveException;
}
