package club.cser.commons;

import org.junit.Assert;

public class MyAssert {
    public static void assertEquals(char[][] expected, char[][] actual) {
        Assert.assertEquals(Converter.charToString(expected), Converter.charToString(actual));
    }
}
