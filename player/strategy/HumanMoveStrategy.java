package player.strategy;

import board.Board;
import java.util.Scanner;

public class HumanMoveStrategy implements MoveStrategy {

    private final Scanner sc = new Scanner(System.in);

    @Override
    public int[] makeMove(Board board, char symbol) {
        System.out.print("Player " + symbol + " enter row and col: ");
        return new int[]{sc.nextInt(), sc.nextInt()};
    }
}
