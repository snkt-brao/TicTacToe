package stratergies.BotStrateries;

import exceptions.InvalidMoveException;
import models.Board;
import models.Cell;
import models.Move;
import models.enums.CellState;

import java.util.List;

public class BotEasyPlayingStrategy implements BotPlayingStrategy {
    @Override
    public Move makeMove(Board board) throws InvalidMoveException {
        for (List<Cell> row : board.getBoard()) {
            for (Cell cell : row) {
                if (cell.getCellState().equals(CellState.EMPTY)) {
                    return new Move(cell, null);
                }
            }
        }
        throw new InvalidMoveException("Bot not permited to make move ");
    }
}
