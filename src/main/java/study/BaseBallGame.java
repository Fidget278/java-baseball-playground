package study;

import java.nio.file.Path;
import java.util.List;

public class BaseBallGame {
    private BaseBalls comBalls;

    public void start() {

        InputView inputView = InputView.getInputview();
        boolean run = true;

        setComBall();
        while(run) {
            BaseBalls playerBalls = stage_input(inputView);
            GameResult gameResult = comBalls.play(playerBalls);
            run = stage_result(gameResult);
        }

    }


    public BaseBalls stage_input(InputView inputView) {
        List<Integer> num = null;

        while(num == null)
            num = inputView.inputUI_baseball();

        return new BaseBalls(num);
    }

    public boolean stage_result(GameResult gameResult) {
        ResultView.roundResultUI(gameResult);

        if(gameResult.isEnd())
            return stage_chooseRestart(InputView.getInputview());

        return true;
    }

    /**
     * true (재시작), false (종료)
     * @param inputView
     * @return
     */
    public boolean stage_chooseRestart(InputView inputView) {
        boolean run = true;
        int choice = 0;
        while(run) {
            choice = inputView.inputUI_end();
            run = (choice != 1 && choice != 2);
        }

        if(choice == 1)
            setComBall();

        return choice == 1;
    }

    public void setComBall() {

        comBalls = new BaseBalls(ValidateNumUtil.pickComBallNums());
        comBalls.printBallsForDebug();
    }

}
