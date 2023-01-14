package Baseball;

import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Baseball {

    final private Map<String, Integer> numberMap = new LinkedHashMap<>();
    final private Map<String, Integer> answerMap = new HashMap<>();

    public Map<String, Integer> getNumberMap() {
        return numberMap;
    }

    public Map<String, Integer> getAnswerMap() {
        return answerMap;
    }

    private int pickRandomNum() {
        return (int) (Math.random() * 9 + 1);
    }

    public int setNewNumber(String number) {
        numberMap.clear();

        String[] nums = number.split("");

        for (String num : nums)
            putNumber(Integer.parseInt(num));

        return Integer.parseInt(number);
    }

    public int setNewNumber() {
        numberMap.clear();

        StringBuffer number = new StringBuffer();
        while(numberMap.size() < 3) {
            Integer randomNum = pickRandomNum();
            putNumber(randomNum);
            number.append(randomNum);
        }

        System.out.println("debug - answer : ");
        for (String s : numberMap.keySet()) {
            System.out.print(s);
        }
        System.out.println();

        return Integer.parseInt(number.toString());
    }

    private void putNumber(Integer randomNum) {
        if(numberMap.get(randomNum.toString()) != null)
            return;

        numberMap.put(randomNum.toString(), numberMap.size());
    }

    public Map<String, Integer> checkAnswer(String answer) {
        String[] answerArray = answer.split("");

        resetAnswerMap();

        for(int i = 0; i < 3; ++i)
            checkStrikeOrBall(i, answerArray);

        checkNothing();

        return answerMap;
    }

    private void resetAnswerMap() {
        answerMap.put(BaseballEnum.Strike.name(), 0);
        answerMap.put(BaseballEnum.Ball.name(), 0);
        answerMap.put(BaseballEnum.Nothing.name(), 0);
    }

    private void checkStrikeOrBall(int index, String[] answerArray) {
        Integer answerIndex = numberMap.get(answerArray[index]);
        if(answerIndex == null)
            return;

        int strike = falseToZero(answerIndex == index);
        int ball = falseToZero(strike == 0);

        answerMap.put(BaseballEnum.Strike.name()
                , answerMap.get(BaseballEnum.Strike.name()) + strike);
        answerMap.put(BaseballEnum.Ball.name()
                , answerMap.get(BaseballEnum.Ball.name()) + ball);
    }

    private void checkNothing() {
        if(answerMap.get(BaseballEnum.Strike.name()) == 0
                && answerMap.get(BaseballEnum.Ball.name()) == 0)
            answerMap.put(BaseballEnum.Nothing.name(), 1);
    }

    private int falseToZero(boolean b) {
        return Boolean.compare(b, false);
    }
}
