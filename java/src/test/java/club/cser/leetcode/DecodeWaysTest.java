package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DecodeWaysTest {

    DecodeWays d;

    @Before
    public void init() {
        d = new DecodeWays();
    }

    @Test
    public void normalTest() {
        Assert.assertEquals(2, d.numDecodings("12"));
        Assert.assertEquals(1, d.numDecodings("2"));
        Assert.assertEquals(1, d.numDecodings("52"));
        Assert.assertEquals(3, d.numDecodings("226"));
    }

    @Test
    public void extremePositiveTest() {
        Assert.assertEquals(0 ,d.numDecodings("0"));
        Assert.assertEquals(0 ,d.numDecodings("05"));
        Assert.assertEquals(0 ,d.numDecodings("00"));
        Assert.assertEquals(0 ,d.numDecodings("50"));
        Assert.assertEquals(1 ,d.numDecodings("10"));
        Assert.assertEquals(0 ,d.numDecodings("100"));
    }


    @Test
    public void normalSimplifiedTest() {
        Assert.assertEquals(2, d.simplifiedNumDecodings("12"));
        Assert.assertEquals(1, d.simplifiedNumDecodings("2"));
        Assert.assertEquals(1, d.simplifiedNumDecodings("52"));
        Assert.assertEquals(3, d.simplifiedNumDecodings("226"));
    }

    @Test
    public void extremePositiveSimplifiedTest() {
        Assert.assertEquals(0 ,d.simplifiedNumDecodings("0"));
        Assert.assertEquals(0 ,d.simplifiedNumDecodings("05"));
        Assert.assertEquals(0 ,d.simplifiedNumDecodings("00"));
        Assert.assertEquals(0 ,d.simplifiedNumDecodings("50"));
        Assert.assertEquals(1 ,d.simplifiedNumDecodings("10"));
        Assert.assertEquals(0 ,d.simplifiedNumDecodings("100"));
        Assert.assertEquals(0 ,d.simplifiedNumDecodings("10058"));
    }
}
