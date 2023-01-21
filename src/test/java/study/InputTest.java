package study;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class InputTest {

    @Test
    public void StringUtil_숫자로변환() {
        assertThat(StringUtil.splitAndConvertToInteger("123")).isEqualTo(Arrays.asList(1, 2, 3));

        assertThatThrownBy(() -> {
            StringUtil.splitAndConvertToInteger("asdf");
        }).isInstanceOf(NumberFormatException.class);
    }

    @Test
    public void 입력_검증() {

        assertThat(ValidateNumUtil.validateNum("123")).isEqualTo(Arrays.asList(1, 2, 3));

        assertThatThrownBy(() -> {
            ValidateNumUtil.validateNum("1234");
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            ValidateNumUtil.validateNum("1");
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            ValidateNumUtil.validateNum("190");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
