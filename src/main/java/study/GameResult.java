package study;

import java.util.List;

public class GameResult {
    private int strike = 0;
    private int ball = 0;

    public GameResult(List<BallMatchStatus> ballMatchStatuses) {
        for (BallMatchStatus ballMatchStatus : ballMatchStatuses)
            addScore(ballMatchStatus);
    }

    private void addScore(BallMatchStatus ballMatchStatus) {
        strike += ballMatchStatus.compare(BallMatchStatus.Strike);
        ball += ballMatchStatus.compare(BallMatchStatus.Ball);

    }

    public boolean isEnd() {
        return strike == 3;
    }
    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }
}
