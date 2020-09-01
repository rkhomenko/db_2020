package homework.riddle_game;

import java.util.List;

/**
 * @author Evgeny Borisov
 */

public abstract class AbstractGame<T extends Player> implements Game {
    protected final T player1;
    protected final T player2;

    public AbstractGame(T player1, T player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public final void play() {
        prepareBoard();
        playGame();
        List<Pair> scores = calcBestScores();
        printScores(scores);
    }

    private void playGame() {
        while (!endOfGame()) {
            player1.makeMove();
            player2.makeMove();
        }
    }

    private void printScores(List<Pair> scores) {
        scores.forEach(System.out::println);
    }

    protected abstract boolean endOfGame();

    protected abstract List<Pair> calcBestScores();

    protected abstract void prepareBoard();

}
