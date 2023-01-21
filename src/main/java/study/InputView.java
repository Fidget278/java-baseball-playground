package study;

import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final static InputView inputview = new InputView();
    private final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static InputView getInputview() {
        return inputview;
    }

    public int inputUI_end() {
        String choice = null;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        choice = input();

        int choiceNum = 0;

        try {
            choiceNum = Integer.parseInt(choice);
        } catch(Exception e) {
            System.out.println("숫자를 입력하세요.");
        }

        return choiceNum;
    }

    public List<Integer> inputUI_baseball() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputNum = input();

        List<Integer> num = null;
        try {
            num = ValidateNumUtil.validateNum(inputNum);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return num;
    }

    private String input() throws InputMismatchException {
        return scanner.next();
    }

    public void close() {
        scanner.close();
    }

}
