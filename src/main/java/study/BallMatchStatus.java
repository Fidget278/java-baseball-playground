package study;

public enum BallMatchStatus {
    Ball, Strike, Nothing;

    /**
     * 두 개의 BallMatchStatus가 서로 같은지 비교해주고 int를 리턴함
     * @param status1 비교 대상 1
     * @param status2 비교 대상 2
     * @return 같으면 1, 다르면 0
     */
    public int compare (BallMatchStatus status2) {
        return Boolean.compare(this == status2, false);
    }
}
