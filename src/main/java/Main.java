import controllers.GameController;
import exceptions.InvalidMoveException;
import models.Bot;
import models.Game;
import models.Player;
import models.Symbol;
import models.enums.BotDifficultyLevel;
import models.enums.GameState;
import models.enums.PlayerType;
import stratergies.winningStratergies.ColGameWinningStrategy;
import stratergies.winningStratergies.GameWinningStrategy;
import stratergies.winningStratergies.RowGameWinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidMoveException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Starting a game Tic Tac Toe");

        int dimension = 3;

        List<Player> players = new ArrayList<>();

        players.add(
                new Player(new Symbol('X'), "sanket", PlayerType.HUMAN)
        );

        players.add(
                new Bot(new Symbol('0'), "my bot", PlayerType.BOT, BotDifficultyLevel.EASY)
        );

        List<GameWinningStrategy> gameWinningStrategies = new ArrayList<>();

        gameWinningStrategies.add(
                new RowGameWinningStrategy()
        );

        gameWinningStrategies.add(
                new ColGameWinningStrategy()
        );
        GameController gameController = new GameController();

        Game game = gameController.startGame(dimension, players, gameWinningStrategies);


        while (gameController.getState(game).equals(GameState.IN_PROGRESS)) {


            gameController.printBoard(game);

            if (game.getMoves().size() > 0) {
//
                System.out.println("Do you want to make undo ? y/n");
                String isUndo = sc.next();

                if (isUndo.equals("y")) {
                    gameController.undo(game);
                    continue;
                }
            }

            gameController.makeMove(game);


            // show board
            // make a move
            //undo move

        }


        System.out.println();
    }
}
