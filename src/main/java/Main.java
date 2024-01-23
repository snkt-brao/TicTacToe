import models.Game;
import models.HumanPlayer;
import models.Player;
import models.enums.PlayerType;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Player player = new HumanPlayer();
        player.setId(1);
        player.setPlayerType(PlayerType.HUMAN);
        player.setSymbol('+');
        player.setName("Sanket");

        Game game = new Game(3, List.of(player), new ArrayList<>());

        game.getBoard().print();
    }
}
