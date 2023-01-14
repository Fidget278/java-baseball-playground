package Calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

enum Operator2{
    ADD, SUBTRACT, MULTIPLY, DIVIDE
}
public class Calculator3 {
    private double num1;
    private double num2;
    private Operator2 operator;

    public Calculator3(double num1, double num2, Operator2 operator) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
    }

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    public Operator2 getOperator() {
        return operator;
    }

    private static final Map<Operator2, BinaryOperator<Double>> operations = new HashMap<>();

    static {
        operations.put(Operator2.ADD, (a, b) -> a + b);
        operations.put(Operator2.SUBTRACT, (a, b) -> a - b);
        operations.put(Operator2.MULTIPLY, (a, b) -> a * b);
        operations.put(Operator2.DIVIDE, (a, b) -> a / b);
    }

    public double calculate() {
        BinaryOperator<Double> operation = operations.get(operator);
        if (operation == null) {
            throw new IllegalArgumentException("Invalid operator: " + operator);
        }
        return operation.apply(num1, num2);
    }
}
