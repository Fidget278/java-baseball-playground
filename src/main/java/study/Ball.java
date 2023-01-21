package study;

public class Ball {
    private final int index;
    private final int number;

    public Ball(int index, int number) {
        this.index = index;
        this.number = number;
    }

    public BallMatchStatus ballMatch(Ball ball) {
        if(this.equals(ball))
            return BallMatchStatus.Strike;

        if(ball.isNumberMatch(this.number))
            return BallMatchStatus.Ball;

        return BallMatchStatus.Nothing;
    }

    private boolean isNumberMatch(int number) {
        return this.number == number;
    }

    @Override
    public String toString() {
        return "index : " + index + " num : " + number;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;

        if(obj instanceof Ball == false)
            return false;

        return this.index == ((Ball) obj).index
                && this.number == ((Ball) obj).number;
    }
}
