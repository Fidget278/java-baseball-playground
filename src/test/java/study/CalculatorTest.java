package study;


import Calculator.Calculator_backup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class CalculatorTest {

    Calculator_backup calculatorBackup = null;
    //final String testStr = "2 / 2 * 3 + 1";
    final String testStr = "2 + 3 * 4 / 2";

    @BeforeEach
    @DisplayName("테스트마다 새로운 계산기 객체 생성")
    void createCalculatorTest() {
        calculatorBackup = new Calculator_backup();
    }

    @Test
    @DisplayName("계산기 입력값 split 테스트")
    void inputSplitTest() {
        //String[] expect = {"2", "/", "2", "*", "3", "+", "1"};
        String[] expect = {"2", "+", "3", "*", "4", "/", "2"};

        assertArrayEquals(expect, calculatorBackup.splitValue(testStr));
    }

    @Test
    @DisplayName("더하기 테스트")
    void addTest() {
        assertThat(calculatorBackup.doOps(1, 1, "+")).isEqualTo(2);
    }

    @Test
    @DisplayName("빼기 테스트")
    void minusTest() {
        assertThat(calculatorBackup.doOps(1, 1, "-")).isEqualTo(0);
    }

    @Test
    @DisplayName("나누기 테스트")
    void divideTest() {
        assertThat(calculatorBackup.doOps(1, 1, "/")).isEqualTo(1);
    }

    @Test
    @DisplayName("곱하기 테스트")
    void multiplyTest() {
        assertThat(calculatorBackup.doOps(1, 1, "*")).isEqualTo(1);
    }

    @Test
    @DisplayName("계산기 테스트")
    void calcTest() {
        //assertThat(calculator.calc()).isEqualTo(4);
        assertThat(calculatorBackup.calc(testStr)).isEqualTo(10);
    }
}
