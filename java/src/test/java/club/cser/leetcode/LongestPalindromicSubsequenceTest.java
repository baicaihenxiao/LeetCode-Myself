package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LongestPalindromicSubsequenceTest {
    private LongestPalindromicSubsequence l;

    @Before
    public void init() {
        l = new LongestPalindromicSubsequence();
    }

    @Test
    public void basicTest1() {
        String s = "bbbab";
        int res = 4;

        Assert.assertEquals(res, l.longestPalindromeSubseq(s));
    }

    @Test
    public void basicTest2() {


        String s = "cbbd";
        int res = 2;

        Assert.assertEquals(res, l.longestPalindromeSubseq(s));
    }
}
