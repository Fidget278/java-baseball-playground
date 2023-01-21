package study;

public class RandomNum {

    public final static int MIN_RANDOM_NUM = 1;
    public final static int MAX_RANDOM_NUM = 9;

    public static String createRandomNumString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < 3; ++i)
            stringBuilder.append((int) (Math.random() * MAX_RANDOM_NUM + MIN_RANDOM_NUM));

        return stringBuilder.toString();
    }
}
