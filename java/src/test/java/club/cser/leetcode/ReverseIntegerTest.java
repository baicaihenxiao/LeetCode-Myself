package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReverseIntegerTest {

    ReverseInteger r;

    @Before
    public void init() {
        r = new ReverseInteger();
    }

    @Test
    public void normalPositiveTest() {
        Assert.assertEquals(432001 ,r.reverse(100234));
        Assert.assertEquals(32001 ,r.reverse(1002300));
        Assert.assertEquals(21 ,r.reverse(120));
    }

    @Test
    public void normalNegativeTest() {
        Assert.assertEquals(-432001 ,r.reverse(-100234));
        Assert.assertEquals(-32001 ,r.reverse(-1002300));
    }

    @Test
    public void extremePositiveTest() {
        Assert.assertEquals(0 ,r.reverse(Integer.MAX_VALUE));
    }


}
