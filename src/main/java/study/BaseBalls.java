package study;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class BaseBalls {

    final private List<Ball> balls;

    public void printBallsForDebug() {
        for (Ball ball : balls)
            System.out.println(ball);
    }

    public BaseBalls(List<Integer> numbers) {
        this.balls = makeBallList(numbers);
    }

    public GameResult play(BaseBalls baseBalls) {
        return new GameResult(balls.stream()
                .map(ball -> baseBalls.play(ball))
                .collect(Collectors.toList()));
    }

    private BallMatchStatus play(Ball ball) {
        return balls.stream()
                .map(b -> b.ballMatch(ball))
                .filter(status -> status != BallMatchStatus.Nothing)
                .findFirst()
                .orElse(BallMatchStatus.Nothing);
    }

    private static List<Ball> makeBallList(List<Integer> numbers) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        return numbers.stream()
                .map(number -> new Ball(atomicInteger.getAndIncrement(), number))
                .collect(Collectors.toList());
    }
}
