package Baseball;

import java.util.Map;

public class ResultView {
    public static void roundResultUI(Map<String, Integer> result) {
        printResult(result, BaseballEnum.Strike);
        printResult(result, BaseballEnum.Ball);
        printNothing(String.valueOf(result.get(BaseballEnum.Nothing.name())));
        System.out.println();
    }

    public static void gameEndUI() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static void printResult(Map<String, Integer> result, BaseballEnum category) {
        String num = String.valueOf(result.get(category.name()));

        if(!num.equals("0"))
            System.out.print(num + " " + category.name() + " ");
    }

    private static void printNothing(String num) {
        if(!num.equals("0")) {
            System.out.println(BaseballEnum.Nothing.name());
        }
    }
}
