package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LongestPalindromicSubstringTest {

    private LongestPalindromicSubstring l;

    @Before
    public void init() {
        l = new LongestPalindromicSubstring();
    }

    @Test
    public void basicTest1() {
        String s = "babad";
        String res = "bab";

        Assert.assertEquals(res, l.longestPalindrome(s));
    }

    @Test
    public void basicTest2() {
        String s = "cbbd";
        String res = "bb";

        Assert.assertEquals(res, l.longestPalindrome(s));
    }

    @Test
    public void basicTest3() {
        String s = "a";
        String res = "a";

        Assert.assertEquals(res, l.longestPalindrome(s));
    }

    @Test
    public void basicTest4() {
        String s = "ac";
        String res = "a";

        Assert.assertEquals(res, l.longestPalindrome(s));
    }
}
