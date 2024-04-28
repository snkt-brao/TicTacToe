package stratergies.winningStratergies;

import models.Board;
import models.Move;

public interface GameWinningStrategy {
    boolean checkWinner(Board board, Move move);
}
