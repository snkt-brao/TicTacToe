package stratergies.winningStratergies;

import models.Board;
import models.Move;

import java.util.HashMap;
import java.util.Map;

public class RowGameWinningStrategy implements GameWinningStrategy {

    Map<Integer, Map<Character, Integer>> map = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        char aChar =move.getPlayer().getSymbol().getAChar();

        if (!map.containsKey(row)) map.put(row, new HashMap<>());

        Map<Character, Integer> curRowMap = map.get(row);
        curRowMap.put(aChar, curRowMap.getOrDefault(aChar, 0) + 1);

        return curRowMap.get(aChar).equals(board.getSize());
    }
}
