package controllers;

import exceptions.InvalidMoveException;
import models.Game;
import models.Player;
import models.enums.GameState;
import stratergies.winningStratergies.GameWinningStrategy;

import java.util.List;

public class GameController {

    public Game startGame(int dimension, List<Player> players, List<GameWinningStrategy> gameWinningStrategies) {
        return Game.getBuilder()
                .setDimension(dimension)
                .setPlayers(players)
                .setGameWinningStrategies(gameWinningStrategies)
                .build();
    }

    public GameState getState(Game game) {
        return game.getGameState();
    }

    public void printBoard(Game game) {
        game.printBoard();
    }

    public void undo(Game game) {
        game.undo();
    }

    public void makeMove(Game game) throws InvalidMoveException {
        game.makeMove();
    }
}
