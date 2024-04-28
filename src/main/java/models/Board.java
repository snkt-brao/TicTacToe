package models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Board {
    private int size;
    private List<List<Cell>> board;

    public Board(int size) {
        this.size = size;
        creteABoard();
    }

    private void creteABoard() {
        this.board = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Cell> cell = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                cell.add(new Cell(i, j));
            }
            this.board.add(cell);
        }
    }

    public void printBoard() {
        for (List<Cell> row : board) {
            System.out.print("|");
            for (Cell col : row) {
                col.display();
            }
            System.out.print("\n");
        }
    }
}
