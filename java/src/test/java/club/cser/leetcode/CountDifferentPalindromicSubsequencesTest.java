package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CountDifferentPalindromicSubsequencesTest {
    private CountDifferentPalindromicSubsequences l;

    @Before
    public void init() {
        l = new CountDifferentPalindromicSubsequences();
    }

    // 'b', 'c', 'bb', 'cc', 'bcb', 'bccb'
    @Test
    public void basicTest1() {
        String s = "bccb";
        int res = 6;

        Assert.assertEquals(res, l.countPalindromicSubsequences(s));
    }
    // a b aa bb aba bab
    @Test
    public void basicTest2() {
        String s = "abab";
        int res = 6;

        Assert.assertEquals(res, l.countPalindromicSubsequences(s));
    }

    @Test
    public void basicTest3() {
        String s = "abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba";
        int res = 104860361;

        Assert.assertEquals(res, l.countPalindromicSubsequences(s));
    }

    @Test
    public void basicTest4() {
        String s = "bcbacbabdcbcbdcbddcaaccdcbbcdbcabbcdddadaadddbdbbbdacbabaabdddcaccccdccdbabcddbdcccabccbbcdbcdbdaada";
        int res = 117990582;

        Assert.assertEquals(res, l.countPalindromicSubsequences(s));
    }
}
