package homework.riddle_game;

import lombok.Getter;
import lombok.Setter;

public class RiddlePlayer implements Player {
    public RiddlePlayer(String name) {
        this.name = name;
    }

    @Override
    public void makeMove() {
    }

    @Getter
    private String name;

    @Getter
    @Setter
    private int number;
}
