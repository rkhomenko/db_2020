package homework.riddle_game;

public class Main {
    public static void main(String[] args) {
//        Game game = new RiddleGame(new AskingPlayer("left"), new AnsweringPlayer("right"));
//        game.play();

        Game game = new RiddleGame(new ComputerAskingPlayer("left"), new ComputerAnsweringPlayer("right"));
        game.play();
    }
}
