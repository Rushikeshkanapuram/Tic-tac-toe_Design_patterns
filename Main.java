import board.ConsoleBoardObserver;
import game.Game;
import game.GameBuilder;
import player.Player;
import player.PlayerFactory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter board size (e.g. 3 or 4x4): ");
        String input = sc.next().toLowerCase();

        int boardSize;

        try {
            if (input.contains("x")) {
                String[] parts = input.split("x");
                boardSize = Integer.parseInt(parts[0]);
            } else {
                boardSize = Integer.parseInt(input);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid board size input.");
            return;
        }

        if (boardSize < 3) {
            System.out.println("Board size must be at least 3.");
            return;
        }

        System.out.println("Choose Game Mode:");
        System.out.println("1. Human vs Human");
        System.out.println("2. Human vs AI");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        Player p1 = PlayerFactory.create("HUMAN", 'X');
        Player p2 = (choice == 1)
                ? PlayerFactory.create("HUMAN", 'O')
                : PlayerFactory.create("AI", 'O');

        Game game = new GameBuilder(boardSize)
                .player1(p1)
                .player2(p2)
                .observer(new ConsoleBoardObserver())
                .build();

        game.start();
    }
}
