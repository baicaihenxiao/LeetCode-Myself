package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReverseBitsTest {

    ReverseBits r;

    @Before
    public void init() {
        r = new ReverseBits();
    }

    @Test
    public void basicTest1() {
        Assert.assertEquals(964176192, r.reverseBits(43261596));
    }

    @Test
    public void basicTest2() {
        Assert.assertEquals(-1073741825, r.reverseBits(-3));
    }

    @Test
    public void zeroTest() {
        Assert.assertEquals(0, r.reverseBits(0));
    }

    @Test
    public void minTest() {
        Assert.assertEquals(1, r.reverseBits(Integer.MIN_VALUE));
    }

    @Test
    public void maxTest() {
        Assert.assertEquals(-2, r.reverseBits(Integer.MAX_VALUE));
    }
}
