package game;

import board.Board;
import player.Player;
import util.GameStatus;

public class Game {

    private Board board;
    private Player current;
    private Player other;
    private GameStatus status = GameStatus.IN_PROGRESS;

    void init(Board board, Player p1, Player p2) {
        this.board = board;
        this.current = p1;
        this.other = p2;
    }

    public void start() {
        while (status == GameStatus.IN_PROGRESS) {

            int[] move = current.play(board);

            if (board.isEmpty(move[0], move[1])) {
                board.place(move[0], move[1], current.getSymbol());

                if (checkWin(current.getSymbol())) {
                    System.out.println("Player " + current.getSymbol() + " wins!");
                    status = GameStatus.WON;
                } else if (board.getEmptyCells().isEmpty()) {
                    System.out.println("Game Draw!");
                    status = GameStatus.DRAW;
                } else {
                    swap();
                }
            }
        }
    }

    private void swap() {
        Player temp = current;
        current = other;
        other = temp;
    }

    private boolean checkWin(char s) {
        char[][] g = board.getGrid();
        int n = g.length;

        for (int i = 0; i < n; i++)
            if (row(g, i, s) || col(g, i, s))
                return true;

        return diag(g, s) || antiDiag(g, s);
    }

    private boolean row(char[][] g, int r, char s) {
        for (int c = 0; c < g.length; c++)
            if (g[r][c] != s) return false;
        return true;
    }

    private boolean col(char[][] g, int c, char s) {
        for (int r = 0; r < g.length; r++)
            if (g[r][c] != s) return false;
        return true;
    }

    private boolean diag(char[][] g, char s) {
        for (int i = 0; i < g.length; i++)
            if (g[i][i] != s) return false;
        return true;
    }

    private boolean antiDiag(char[][] g, char s) {
        for (int i = 0; i < g.length; i++)
            if (g[i][g.length - i - 1] != s) return false;
        return true;
    }
}
