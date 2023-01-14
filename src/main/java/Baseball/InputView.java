package Baseball;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {
    private final static InputView inputview = new InputView();
    private final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static InputView getInputview() {
        return inputview;
    }

    public int inputUI_end() {
        String choice = null;

        boolean run = true;
        while(run) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            choice = input();
            run = !(choice.equals("1") || choice.equals("2"));
        }

        return Integer.parseInt(choice);
    }

    public String inputUI_baseball() {
        String inputNum = null;
        while(!checkValidNumInput(inputNum)) {
            System.out.print("숫자를 입력해주세요 : ");
            inputNum = input();
        }
        return inputNum;
    }

    private String input() throws InputMismatchException {
        return scanner.next();
    }

    public boolean checkValidNumInput(String num) {
        if (num == null) {
            return false;
        }

        try {
            Integer.parseInt(num);
        } catch(Exception e) {
            System.out.println("숫자만 입력해주세요.");
            return false;
        }

        if (num.length() != 3) {
            System.out.println("3자리의 숫자를 입력해주세요.");
            return false;
        }

        if(Arrays.stream(num.split(""))
                .distinct()
                .collect(Collectors.toList()).size() != 3) {
            System.out.println("중복 없이 입력해주세요.");
            return false;
        }

        return true;
    }

    public void close() {
        scanner.close();
    }

}
