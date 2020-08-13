package club.cser.commons;

import java.util.Arrays;

public class Converter {
    public static String charToString(char[][] chs) {
        return Arrays.stream(chs).map(Arrays::toString).reduce((a, b) -> a + b).get();
    }
}
