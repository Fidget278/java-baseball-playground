package study.baseball;

import Baseball.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class Baseball_InputTest {

    OutputStream out;
    @BeforeEach
    public void 준비() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Test
    public void 사용자입력검증_3자리초과() {
        InputView.getInputview().checkValidNumInput("1435");
        assertThat(out.toString()).contains("3자리의 숫자를 입력해주세요.");
    }

    @Test
    public void 사용자입력검증_숫자아님() {
        InputView.getInputview().checkValidNumInput("14ㅁ5");
        assertThat(out.toString()).contains("숫자만 입력해주세요");
    }

    @Test
    public void 사용자입력검증_중복() {
        InputView.getInputview().checkValidNumInput("122");
        assertThat(out.toString()).contains("중복 없이 입력해주세요");
    }

}
