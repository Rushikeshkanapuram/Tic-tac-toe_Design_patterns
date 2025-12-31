package board;

import java.util.*;

public class Board {

    private final char[][] grid;
    private final List<BoardObserver> observers = new ArrayList<>();

    public Board(int size) {
        grid = new char[size][size];
        for (char[] row : grid)
            Arrays.fill(row, ' ');
    }

    public char[][] getGrid() {
        return grid;
    }

    public boolean isEmpty(int r, int c) {
        return grid[r][c] == ' ';
    }

    public void place(int r, int c, char symbol) {
        grid[r][c] = symbol;
        notifyObservers();
    }

    public List<int[]> getEmptyCells() {
        List<int[]> cells = new ArrayList<>();
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid.length; j++)
                if (grid[i][j] == ' ')
                    cells.add(new int[]{i, j});
        return cells;
    }

    public void addObserver(BoardObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (BoardObserver o : observers)
            o.update(this);
    }
}
