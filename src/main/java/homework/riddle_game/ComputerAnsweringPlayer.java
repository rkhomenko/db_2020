package homework.riddle_game;

import java.util.concurrent.ThreadLocalRandom;

public class ComputerAnsweringPlayer extends RiddlePlayer {
    public ComputerAnsweringPlayer(String name) {
        super(name);
    }

    @Override
    public void makeMove() {
        super.makeMove();
        setNumber(ThreadLocalRandom.current().nextInt(1, 100));
    }
}
