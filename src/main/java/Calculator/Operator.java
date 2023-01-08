package Calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> num1 / num2);

    private String expression;
    private BiFunction<Integer, Integer, Integer> result;

    Operator(String expression, BiFunction<Integer, Integer, Integer> result) {
        this.expression = expression;
        this.result = result;
    }

    public static Operator of(String expression) {
        return Arrays.stream(values())
                .filter(v -> expression.equals(v.expression))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("%s는 사칙연산 표현식이 아닙니다", expression)));
    }

    public int calculate(int num1, int num2) {
        return result.apply(num1, num2);
    }
}