package club.cser.commons;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    public static String listToString(List<? extends Object> list) {
        return list.stream().map(Object::toString).collect(Collectors.joining(", "));
    }
    public static String charToString(char[][] chs) {
        return Arrays.stream(chs).map(Arrays::toString).reduce((a, b) -> a + b).get();
    }
}
