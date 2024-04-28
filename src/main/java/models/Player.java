package models;

import exceptions.InvalidMoveException;
import lombok.Getter;
import lombok.Setter;
import models.enums.PlayerType;

import java.util.Scanner;

@Getter
@Setter
public class Player {
    Scanner sc = new Scanner(System.in);
    private Symbol symbol;
    private String name;
    private PlayerType playerType;

    public Player(Symbol symbol, String name, PlayerType playerType) {
        this.symbol = symbol;
        this.name = name;
        this.playerType = playerType;
    }

    public Move makeMove(Board board) throws InvalidMoveException {
        System.out.println("Please enter details ");
        System.out.println("Row : ");
        int row = sc.nextInt();
        System.out.println("Col : ");
        int col = sc.nextInt();

        return new Move(new Cell(row, col), this);
    }
}
