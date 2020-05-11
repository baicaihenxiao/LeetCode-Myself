package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MinimumWindowSubstringTest {
    MinimumWindowSubstring m;

    @Before
    public void init() {
        m = new MinimumWindowSubstring();
    }

    @Test
    public void basicTest1() {
        String S = "ADOBECODEBANC", T = "ABC";
        Assert.assertEquals("BANC", m.minWindow(S, T));
    }

    @Test
    public void basicTest2() {
        String S = "ADOBECODEBANC", T = "ABCC";
        Assert.assertEquals("CODEBANC", m.minWindow(S, T));
    }

    @Test
    public void basicTest3() {
        String S = "ADOBECODEBANC", T = "ABCCC";
        Assert.assertEquals("", m.minWindow(S, T));
    }

    @Test
    public void notIncludeTest1() {
        String S = "ADOBECODEBANC", T = "ABCCH";
        Assert.assertEquals("", m.minWindow(S, T));
    }

}
