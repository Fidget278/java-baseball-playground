package Calculator;


public class Calculator_backup {
    private String[] values;

    public String[] splitValue(String value) {
        String regex = " ";
        values = value.split(regex);
        return values;
    }

    public int calc(String calcStr) {
        int number = 0, answer = 0;
        String operator = "";

        splitValue(calcStr);
        for(int i = 0; i < values.length; ++i) {
            if(i % 2 == 0) {
                number = Integer.parseInt(values[i]);
                answer = doOps(number, answer, operator);
            } else {
                operator = values[i];
            }
        }

        return answer;
    }

    public int doOps(int number, int target, String operator) {

        if(operator.length() <= 0)
            return number;

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
