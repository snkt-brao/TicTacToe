package stratergies.winningStratergies;

import models.Board;
import models.Move;

import java.util.HashMap;
import java.util.Map;

public class ColGameWinningStrategy implements GameWinningStrategy {
    Map<Integer, Map<Character, Integer>> map = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        int col = move.getCell().getCol();
        char aChar =move.getPlayer().getSymbol().getAChar();

        if (!map.containsKey(col)) map.put(col, new HashMap<>());

        Map<Character, Integer> curColMap = map.get(col);
        curColMap.put(aChar, curColMap.getOrDefault(aChar, 0) + 1);

        return curColMap.get(aChar).equals(board.getSize());
    }
}
