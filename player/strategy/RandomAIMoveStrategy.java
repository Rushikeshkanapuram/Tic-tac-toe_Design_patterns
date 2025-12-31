package player.strategy;

import board.Board;
import java.util.*;

public class RandomAIMoveStrategy implements MoveStrategy {

    @Override
    public int[] makeMove(Board board, char symbol) {
        List<int[]> empty = board.getEmptyCells();
        return empty.get(new Random().nextInt(empty.size()));
    }
}
