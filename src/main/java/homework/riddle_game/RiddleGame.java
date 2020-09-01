package homework.riddle_game;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Evgeny Borisov
 */
public final class RiddleGame extends AbstractGame<RiddlePlayer> {
    public RiddleGame(RiddlePlayer player1, RiddlePlayer player2) {
        super(player1, player2);

        this.moveCount = 0;
        this.results = new ArrayList<>();
    }

    @Override
    protected boolean endOfGame() {
        int expected = this.player1.getNumber();
        int answer = this.player2.getNumber();
        boolean result = expected == answer;

        if (moveCount == 0) {
            moveCount++;
            return false;
        }

        if (result) {
            int score = (int) 100.0 / this.moveCount;
            this.results.add(new Pair(player2.getName(), score));

            System.out.println("Правильно!");
        } else {
            System.out.println("Вы не угадали");
        }

        moveCount++;

        return result;
    }

    @Override
    protected List<Pair> calcBestScores() {
        return results.stream()
                .sorted((p1, p2) -> -Integer.compare(p1.getScore(), p2.getScore()))
                .limit(5)
                .collect(Collectors.toList());
    }

    @Override
    protected void prepareBoard() {

    }

    private int moveCount;
    private List<Pair> results;
}
