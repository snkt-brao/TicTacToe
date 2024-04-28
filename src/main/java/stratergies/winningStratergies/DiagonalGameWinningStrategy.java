package stratergies.winningStratergies;

import models.Board;
import models.Move;

import java.util.HashMap;
import java.util.Map;

public class DiagonalGameWinningStrategy implements GameWinningStrategy {

    Map<Character, Integer> leftDia = new HashMap<>();
    Map<Character, Integer> rightDia = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        char aChar = move.getPlayer().getSymbol().getAChar();

        if (row == col) {
            leftDia.put(aChar, leftDia.getOrDefault(aChar, 0) + 1);
            if (leftDia.get(aChar) == (board.getSize())) return true;
        }

        if (row + col == board.getSize() - 1) {
            rightDia.put(aChar, rightDia.getOrDefault(aChar, 0) + 1);
            if (rightDia.get(aChar) == (board.getSize())) return true;
        }

        return false;
    }

}
