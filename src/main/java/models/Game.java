package models;

import exceptions.InvalidMoveException;
import lombok.Getter;
import models.enums.CellState;
import models.enums.GameState;
import stratergies.winningStratergies.GameWinningStrategy;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Game {

    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameState gameState;
    private int nextPlayerIndex;
    private Player winner;
    private List<GameWinningStrategy> gameWinningStratergies;

    private Game(Builder builder) {
        this.board = new Board(builder.dimension);
        this.players = builder.players;
        this.gameWinningStratergies = builder.gameWinningStrategies;
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        this.nextPlayerIndex = getRandomPlayerIndex(builder.dimension);
        this.winner = null;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public void printBoard() {
        this.board.printBoard();
    }

    private int getRandomPlayerIndex(int size) {
        return 0;
    }

    public void makeMove() throws InvalidMoveException {
        Player currentPlayer = players.get(nextPlayerIndex);
        System.out.println("This is " + currentPlayer.getName() + " making move...");

        Move move = currentPlayer.makeMove(board);

        if (!validMove(move)) {
            throw new InvalidMoveException("Invalid move. please retry");
        }

        Move finalMove = updateBoard(move, currentPlayer);

        if (checkWin(finalMove)) {
            gameState = GameState.ENDED;
            winner = currentPlayer;
        } else if (moves.size() == board.getSize() * board.getSize()) {
            gameState = GameState.DRAW;
        }

    }

    private boolean checkWin(Move move) {
        for (GameWinningStrategy winningStrategy : gameWinningStratergies) {
            if (winningStrategy.checkWinner(board, move)) {
                return true;
            }
        }
        return false;
    }

    private Move updateBoard(Move move, Player player) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Cell cell = board.getBoard().get(row).get(col);
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(player);
        nextPlayerIndex = (nextPlayerIndex + 1) % players.size();
        Move finalMove = new Move(cell, player);
        moves.add(finalMove);
        return finalMove;
    }

    private boolean validMove(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        int size = board.getSize();

        if (row < 0 || row >= size || col < 0 || col >= size) return false;

        return board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY);
    }

    public void undo() {
        Move move = moves.get(moves.size() - 1);
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        move.setCell(new Cell(row, col));
        move.setPlayer(null);
        board.getBoard().get(row).get(col).setCellState(CellState.EMPTY);
        board.getBoard().get(row).get(col).setPlayer(null);
        moves.remove(moves.size() - 1);
    }


    public static class Builder {
        private int dimension;
        private List<Player> players;
        private List<GameWinningStrategy> gameWinningStrategies;


        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setGameWinningStrategies(List<GameWinningStrategy> gameWinningStrategies) {
            this.gameWinningStrategies = gameWinningStrategies;
            return this;
        }

        public Game build() {
            return new Game(this);
        }
    }
}
