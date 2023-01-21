package study;

public class ResultView {
    public static void roundResultUI(GameResult gameResult) {

        if(gameResult.isEnd()) {
            gameEndUI();
            return;
        }

        if(gameResult.getStrike() > 0)
            System.out.print(gameResult.getStrike() + " Strinkes ");

        if(gameResult.getBall() > 0)
            System.out.print(gameResult.getBall() + " Balls ");

        if(gameResult.isNothing())
            System.out.print("Nothing");

        System.out.println();
    }

    public static void gameEndUI() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
