package homework.riddle_game;

import javax.swing.*;

public class AskingPlayer extends RiddlePlayer {
    public AskingPlayer(String name) {
        super(name);
        this.moveNumber = 0;
    }

    @Override
    public void makeMove() {
        super.makeMove();

        if (this.moveNumber == 0) {
            int number = Integer.parseInt(JOptionPane.showInputDialog("Придумайте число:"));
            setNumber(number);
        }

        this.moveNumber++;
    }

    protected int moveNumber;
}
