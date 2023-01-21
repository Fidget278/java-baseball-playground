package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class BaseBallTest {

    BaseBalls comBalls;

    @BeforeEach
    public void 컴퓨터볼생성() {
        comBalls = new BaseBalls(ValidateNumUtil.validateNum("123"));
    }

    @Test
    public void 낫싱() {
        BaseBalls playerBalls = new BaseBalls(ValidateNumUtil.validateNum("456"));
        GameResult gameResult = comBalls.play(playerBalls);

        assertThat(gameResult.getStrike()).isEqualTo(0);
        assertThat(gameResult.getBall()).isEqualTo(0);
    }

    @Test
    public void 스트라이크_3개() {
        BaseBalls playerBalls = new BaseBalls(ValidateNumUtil.validateNum("123"));
        GameResult gameResult = comBalls.play(playerBalls);

        assertThat(gameResult.getStrike()).isEqualTo(3);
        assertThat(gameResult.getBall()).isEqualTo(0);
    }

    @Test
    public void 볼_3개() {
        BaseBalls playerBalls = new BaseBalls(ValidateNumUtil.validateNum("231"));
        GameResult gameResult = comBalls.play(playerBalls);

        assertThat(gameResult.getStrike()).isEqualTo(0);
        assertThat(gameResult.getBall()).isEqualTo(3);
    }

    @Test
    public void 스트라이크1개_볼2개() {
        BaseBalls playerBalls = new BaseBalls(ValidateNumUtil.validateNum("213"));
        GameResult gameResult = comBalls.play(playerBalls);

        assertThat(gameResult.getStrike()).isEqualTo(1);
        assertThat(gameResult.getBall()).isEqualTo(2);
    }
}

