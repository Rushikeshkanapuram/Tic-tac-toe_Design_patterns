package player;

import player.strategy.*;

public class PlayerFactory {

    public static Player create(String type, char symbol) {
        if ("HUMAN".equalsIgnoreCase(type))
            return new Player(symbol, new HumanMoveStrategy());
        if ("AI".equalsIgnoreCase(type))
            return new Player(symbol, new RandomAIMoveStrategy());

        throw new IllegalArgumentException("Invalid player type");
    }
}
