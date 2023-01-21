package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringUtil {

    public static List<Integer> splitAndConvertToInteger(String number) {
        return Arrays.stream(Stream.of(number.split(""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toArray(Integer[]::new)).collect(Collectors.toList());
    }
}
