package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


public class BallTest {
    Ball computerBall;

    @BeforeEach
    public void 컴퓨터숫자() {
        computerBall = new Ball(0, 1);
    }

    @Test
    public void 낫싱() {
        Ball playerBall = new Ball(0, 4);
        assertThat(computerBall.ballMatch(playerBall)).isEqualTo(BallMatchStatus.Nothing);
    }

    @Test
    public void 볼() {
        Ball playerBall = new Ball(1, 1);
        assertThat(computerBall.ballMatch(playerBall)).isEqualTo(BallMatchStatus.Ball);
    }

    @Test
    public void 스트라이크() {
        Ball playerBall = new Ball(0, 1);
        assertThat(computerBall.ballMatch(playerBall)).isEqualTo(BallMatchStatus.Strike);
    }
}
