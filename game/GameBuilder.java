package game;

import board.Board;
import board.BoardObserver;
import player.Player;

public class GameBuilder {

    private final Board board;
    private Player p1;
    private Player p2;

    public GameBuilder(int boardSize) {
        this.board = new Board(boardSize);
    }

    public GameBuilder player1(Player p1) {
        this.p1 = p1;
        return this;
    }

    public GameBuilder player2(Player p2) {
        this.p2 = p2;
        return this;
    }

    public GameBuilder observer(BoardObserver observer) {
        board.addObserver(observer);
        return this;
    }

    public Game build() {
        Game game = new Game();
        game.init(board, p1, p2);
        return game;
    }
}
