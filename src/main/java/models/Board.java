package models;

import lombok.Getter;
import lombok.Setter;
import models.enums.CellState;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Board {
    List<List<Cell>> board;
    private int size;

    public Board(int size) {
        this.size = size;
        this.board = createBoard();
    }

    private List<List<Cell>> createBoard() {
        this.board = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            this.board.add(new ArrayList<>());
            for (int j = 0; j < size; j++) {
                this.board.get(i).add(new Cell(i, j));
            }
        }

        return this.board;
    }

    public void print() {

        for (int i = 0; i < size; i++) {
            System.out.print("|\t");
            for (int j = 0; j < size; j++) {
                if (CellState.EMPTY.equals(board.get(i).get(j).getCellState())) {
                    System.out.print("\t|\t");
                } else {
                    System.out.print(board.get(i).get(j).getPlayer().getSymbol() + "\t|\t");
                }
            }
            System.out.println();
        }
    }

}
