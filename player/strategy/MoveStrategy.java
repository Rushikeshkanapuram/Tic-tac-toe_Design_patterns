package player.strategy;

import board.Board;

public interface MoveStrategy {
    int[] makeMove(Board board, char symbol);
}
