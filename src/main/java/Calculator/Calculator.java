package Calculator;

import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.Scanner;


public class Calculator {
    private String[] values;
    private String regex = " ";

    public String[] splitValue(String value) {
        values = value.split(regex);
        return values;
    }

    public int calc() {
        int number = 0, answer = 0;
        String operator = "";

        for(int i = 0; i < values.length; ++i) {
            if(i % 2 == 0)
                number = Integer.parseInt(values[i]);
            else
                operator = values[i];

            answer = doOps(number, answer, operator);
        }


        return answer;
    }

    public int doOps(int number, int target, String operator) {

        if(operator.length() <= 0)
            return target;

        switch(operator) {
            case "+" :
                target += number;
                break;
            case "-" :
                target -= number;
                break;
            case "/" :
                target /= number;
                break;
            case "*":
                target *= number;
                break;
        }
        return target;
    }
}
