package Calculator;

import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Calculator {
    //private static final Pattern IS_NUMBER = Pattern.compile("^[0-9]*$");

    public static String[] splitValue(String value){
        String[] values = value.split(" ");
        if(value.isEmpty()) {
            throw new IllegalArgumentException("입력된 내용이 없습니다.");
        }
        if(values.length < 3) {
            throw new IllegalArgumentException("올바르지 않은 입력 양식입니다.");
        }
        return values;
    }

    public static String calc(String calcStr) {
        String result = null;
        try {
            result = calc(splitValue(calcStr));
        } catch (ArithmeticException ae) {
            return "0으로 나눌 수 없습니다.";
        } /*catch (NumberFormatException ne) {
            return "숫자가 아닙니다.";
        }*/

        return result;
    }

    private static String calc(String[] values) throws ArithmeticException {
        Integer result = Integer.parseInt(values[0]);
        Operator operator = Operator.of(values[1]);

        for(int i = 2; i < values.length; ++i) {
            if(i % 2 == 0) {
                result = operator.calculate(result, Integer.parseInt(values[i]));
            } else {
                operator = Operator.of(values[i]);
            }
        }
        return result.toString();
    }
}
