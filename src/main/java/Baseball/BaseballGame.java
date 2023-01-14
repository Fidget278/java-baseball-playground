package Baseball;

import java.util.Map;

public class BaseballGame {

    public final static int RESTART = 1;
    public final static int ENDGAME = 2;

    public static void main(String[] args) {
        final InputView inputView = InputView.getInputview();
        final Baseball baseball = new Baseball();

        startNewGame(baseball);

        boolean run = true;
        while(run) {
            String input = inputView.inputUI_baseball();
            Map<String, Integer> answerMap = baseball.checkAnswer(input);
            ResultView.roundResultUI(answerMap);

            run = checkEndGame(baseball);
        }

        inputView.close();
    }

    public static void startNewGame(Baseball baseball) {
        baseball.setNewNumber();
    }

    public static boolean checkEndGame(Baseball baseball) {
        if(baseball.getAnswerMap().get(BaseballEnum.Strike.name()) == 3) {
            ResultView.gameEndUI();
            int choice = InputView.getInputview().inputUI_end();
            return isEnd(choice, baseball);
        }

        return true;
    }

    public static boolean isEnd(int choice, Baseball baseball) {
        if(choice == ENDGAME)
            return false;

        startNewGame(baseball);
        return true;
    }
}

