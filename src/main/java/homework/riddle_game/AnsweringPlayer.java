package homework.riddle_game;

import javax.swing.*;

public class AnsweringPlayer extends RiddlePlayer {
    public AnsweringPlayer(String name) {
        super(name);
    }

    @Override
    public void makeMove() {
        super.makeMove();

        int number = Integer.parseInt(JOptionPane.showInputDialog("Ваш ответ:"));
        setNumber(number);
    }
}
