package club.cser.commons;

import org.junit.Assert;

import java.util.List;

public class MyAssert {
    public static void assertEquals(List<? extends Object> expected, List<? extends Object> actual) {
        Assert.assertEquals(Converter.listToString(expected), Converter.listToString(actual));
    }
    public static void assertEquals(char[][] expected, char[][] actual) {
        Assert.assertEquals(Converter.charToString(expected), Converter.charToString(actual));
    }
}
