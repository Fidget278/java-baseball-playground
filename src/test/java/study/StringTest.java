package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    /*

    요구사항 1
            "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
            "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
    힌트
    배열로 반환하는 값의 경우 assertj의 contains()를 활용해 반환 값이 맞는지 검증한다.
    배열로 반환하는 값의 경우 assertj의 containsExactly()를 활용해 반환 값이 맞는지 검증한다.

    */

    @Test
    void splitTest1() {
        String str = "1,2";
        String strSplit[] = str.split(",");

        assertThat(strSplit[0]).isEqualTo("1");
        assertThat(strSplit[1]).isEqualTo("2");
    }

    @Test
    void splitTest2() {
        String str = "1";
        String strSplit[] = str.split(",");

        assertThat(strSplit[0]).isEqualTo("2");
    }


    /*
    요구사항 2
    "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
    */

    @Test
    void substringTest() {
        String str = "(1,2)";

        str = str.substring(1, str.length()-1);
        assertThat(str).isEqualTo("1,2");
    }
    /*
    요구사항 3
    "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
    String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
    JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
    */

    @DisplayName("StringIndexOutOfBoundsException 에러 발생 부분 확인")
    @Test
    void charAtTest() {
        String str = "abc";

        assertThatThrownBy(() -> {
            str.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("index out of range");
    }
}