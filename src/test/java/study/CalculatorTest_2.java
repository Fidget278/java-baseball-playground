package study;

import Calculator.Calculator;
import Calculator.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CalculatorTest_2 {

    final String testStr = "2 / 2 * 3 + 1";
    //final String testStr = "2 + 3 * 4 / 2";

    @Test
    @DisplayName("계산기 입력값 split 테스트")
    void inputSplitTest() {
        String[] expect = {"2", "/", "2", "*", "3", "+", "1"};
        //String[] expect = {"2", "+", "3", "*", "4", "/", "2"};

        assertArrayEquals(expect, Calculator.splitValue(testStr));

        assertThatThrownBy(() -> {
            Calculator.splitValue(null);
        }).isInstanceOf(NullPointerException.class);

        assertThatThrownBy(() -> {
            Calculator.splitValue("");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력된 내용이 없습니다.");

        assertThatThrownBy(() -> {
            Calculator.splitValue("1 + ");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("올바르지 않은 입력 양식입니다.");

        assertThatThrownBy(() -> {
            Calculator.splitValue("1+2");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("올바르지 않은 입력 양식입니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"+:2", "-:0", "*:1", "/:1"}, delimiter = ':')
    void 사칙연산테스트(String expression, int result) {
        assertThat(Operator.of(expression).calculate(1, 1)).isEqualTo(result);
    }

    @Test
    @DisplayName("0으로 나누기")
    void dividedByZero() {
        assertThat(Calculator.calc("1 / 0")).isEqualTo("0으로 나눌 수 없습니다.");
    }

    @Test
    @DisplayName("숫자가 아닌 입력")
    void checkDigit() {
        assertThatThrownBy(() -> {
            Calculator.calc("1 + A");
        }).isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("올바르지 않은 사칙연산 표현식 테스트")
    void expressionCheckTest() {
        assertThatThrownBy(() -> {
            Operator.of("(");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사칙연산 표현식이 아닙니다");

        assertThatThrownBy(() -> {
            Calculator.calc("1 ( 2");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사칙연산 표현식이 아닙니다");
    }

    @Test
    @DisplayName("계산기 테스트")
    void calcTest() {
        assertThat(Calculator.calc(testStr)).isEqualTo("4");
        //assertThat(Calculator.calc(testStr)).isEqualTo("10");
    }
}
