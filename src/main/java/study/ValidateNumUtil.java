package study;

import java.util.List;

public class ValidateNumUtil {
    public static List<Integer> validateNum(String number) {
        List<Integer> numbers = StringUtil.splitAndConvertToInteger(number);

        if(isNotThreeDigits(numbers))
            throw new IllegalArgumentException("3자리의 숫자가 아닙니다.");

        if(isNumberDuplicated(numbers))
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");

        if(isNumbersNotInRange(numbers))
            throw new IllegalArgumentException("1~9 사이의 숫자가 아닙니다.");

        return numbers;
    }

    public static List<Integer> validateComNum(String number) {
        List<Integer> numbers = StringUtil.splitAndConvertToInteger(number);

        if(isNotThreeDigits(numbers)
                || isNumberDuplicated(numbers)
                || isNumbersNotInRange(numbers))
            return null;

        return numbers;
    }

    public static boolean isNotThreeDigits(List<Integer> numbers) {
        return numbers.size() != 3;
    }

    public static boolean isNumbersNotInRange(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number < RandomNum.MIN_RANDOM_NUM
                        || number > RandomNum.MAX_RANDOM_NUM)
                .toArray().length > 0;
    }

    public static boolean isNumberDuplicated(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .toArray().length != 3;
    }

    public static List<Integer> pickComBallNums() {
        List<Integer> numList = null;

        while(numList == null)
            numList = ValidateNumUtil.validateComNum(RandomNum.createRandomNumString());

        return numList;
    }
}
