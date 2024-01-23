package models;

import lombok.Getter;
import lombok.Setter;
import models.enums.GameStatus;
import stratergies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private List<WinningStrategy> winningStrategies;
    private int nextPlayerIndex;
    private GameStatus gameStatus;
    private Player winner;

    public Game(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.players = players;
        this.winningStrategies = winningStrategies;
        this.board = new Board(dimension);
        this.moves = new ArrayList<>();
        this.nextPlayerIndex = 0;
        this.gameStatus = GameStatus.INIT;
    }
}
