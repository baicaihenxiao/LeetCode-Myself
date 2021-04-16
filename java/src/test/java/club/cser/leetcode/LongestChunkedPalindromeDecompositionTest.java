package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LongestChunkedPalindromeDecompositionTest {

    private LongestChunkedPalindromeDecomposition l;

    @Before
    public void init() {
        l = new LongestChunkedPalindromeDecomposition();
    }

    // (ghi)(abcdef)(hello)(adam)(hello)(abcdef)(ghi
    @Test
    public void basicTest1() {
        String text = "ghiabcdefhelloadamhelloabcdefghi";
        int res = 7;

        Assert.assertEquals(res, l.longestDecomposition(text));
    }

    @Test
    public void basicTest2() {
        String text = "merchant";
        int res = 1;

        Assert.assertEquals(res, l.longestDecomposition(text));
    }

    // (a)(nt)(a)(pre)(za)(tpe)(za)(pre)(a)(nt)(a)
    @Test
    public void basicTest3() {
        String text = "antaprezatepzapreanta";
        int res = 11;

        Assert.assertEquals(res, l.longestDecomposition(text));
    }

    @Test
    public void basicTest4() {
        String text = "aaa";
        int res = 3;

        Assert.assertEquals(res, l.longestDecomposition(text));
    }


}
