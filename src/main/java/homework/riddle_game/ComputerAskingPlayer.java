package homework.riddle_game;

import java.util.concurrent.ThreadLocalRandom;

public class ComputerAskingPlayer extends RiddlePlayer {
    public ComputerAskingPlayer(String name) {
        super(name);
        setNumber(ThreadLocalRandom.current().nextInt(1, 100));
    }
}
