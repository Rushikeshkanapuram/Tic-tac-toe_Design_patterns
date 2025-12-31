package board;

public class ConsoleBoardObserver implements BoardObserver {

    @Override
    public void update(Board board) {
        System.out.println("\nCurrent Board:");
        for (char[] row : board.getGrid()) {
            for (char c : row)
                System.out.print("[" + c + "]");
            System.out.println();
        }
    }
}
