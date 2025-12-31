package player;

import board.Board;
import player.strategy.MoveStrategy;

public class Player {

    private final char symbol;
    private final MoveStrategy strategy;

    public Player(char symbol, MoveStrategy strategy) {
        this.symbol = symbol;
        this.strategy = strategy;
    }

    public char getSymbol() {
        return symbol;
    }

    public int[] play(Board board) {
        return strategy.makeMove(board, symbol);
    }
}
