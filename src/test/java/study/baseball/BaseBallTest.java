package study.baseball;

import Baseball.Baseball;
import Baseball.InputView;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import Baseball.BaseballEnum;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BaseBallTest {

    @Test
    public void 숫자셋팅테스트() {
        Baseball baseball = new Baseball();

        for(int i = 0; i < 10; ++i) {
            baseball.setNewNumber();

            Map<String, Integer> map = baseball.getNumberMap();
            List<String> strList = new ArrayList<>();
            List<Integer> numList = new ArrayList<>();

            for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
                strList.add(stringIntegerEntry.getKey());
                numList.add(stringIntegerEntry.getValue());
            }

            assertThat(strList.stream()
                    .distinct()
                    .collect(Collectors.toList())
                    .size()
            ).isEqualTo(3);

            assertThat(numList.stream()
                    .distinct()
                    .collect(Collectors.toList())
                    .size()
            ).isEqualTo(3);
        }
    }

    @Test
    public void 스트라이크테스트() {
        Baseball baseball = new Baseball();
        baseball.setNewNumber("123");

        baseball.checkAnswer("123");
        validateStrikeAndBall(baseball, 3, 0, 0);

        baseball.checkAnswer("124");
        validateStrikeAndBall(baseball, 2, 0, 0);

        baseball.checkAnswer("167");
        validateStrikeAndBall(baseball, 1, 0, 0);
    }

    @Test
    public void 볼테스트() {
        Baseball baseball = new Baseball();
        baseball.setNewNumber("123");

        baseball.checkAnswer("376");
        validateStrikeAndBall(baseball, 0, 1, 0);

        baseball.checkAnswer("341");
        validateStrikeAndBall(baseball, 0, 2, 0);

        baseball.checkAnswer("231");
        validateStrikeAndBall(baseball, 0, 3, 0);
    }

    @Test
    public void 낫싱테스트() {
        Baseball baseball = new Baseball();
        baseball.setNewNumber("123");

        baseball.checkAnswer("567");
        validateStrikeAndBall(baseball, 0, 0, 1);
    }

    @Test
    public void 스트라이크볼테스트() {
        Baseball baseball = new Baseball();
        baseball.setNewNumber("123");

        baseball.checkAnswer("132");
        validateStrikeAndBall(baseball, 1, 2, 0);
    }

    private void validateStrikeAndBall(Baseball baseball, int strike, int ball, int nothing) {
        Map<String, Integer> answerMap = baseball.getAnswerMap();
        assertThat(answerMap.get(BaseballEnum.Strike.name())).isEqualTo(strike);
        assertThat(answerMap.get(BaseballEnum.Ball.name())).isEqualTo(ball);
        assertThat(answerMap.get(BaseballEnum.Nothing.name())).isEqualTo(nothing);
    }

//    @Test
//    public void 사용자숫자입력테스트() {
//        String input = "1233";
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//        InputView inputView = InputView.getInputview();
//        inputView.inputUI_baseball();
//    }

}
