package in.game;

import in.game.models.Game;
import in.game.models.Player;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        int dimension = 10;

        Player player1 = new Player("Aastha", 1);
        Player player2 = new Player("Swati", 1);

        Queue<Player> players = new LinkedList<>();
        players.add(player1);
        players.add(player2);

        Game game = new Game(dimension, players);

        game.launch();
    }
}
