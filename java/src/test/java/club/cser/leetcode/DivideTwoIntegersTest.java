package club.cser.leetcode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class DivideTwoIntegersTest {
    static final Logger LOGGER = LogManager.getLogger(DivideTwoIntegersTest.class);

    @Test
    public void baseTest() {
        DivideTwoIntegers d = new DivideTwoIntegers();
        Assert.assertEquals(3, d.divide(10, 3));
        Assert.assertEquals(-2, d.divide(7, -3));

        Assert.assertEquals(3, d.divide1(10, 3));
        Assert.assertEquals(-2, d.divide1(7, -3));
    }

    @Test
    public void mTest() {
        DivideTwoIntegers d = new DivideTwoIntegers();
        Assert.assertEquals(2, d.divide(5, 2));

        Assert.assertEquals(2, d.divide1(5, 2));
    }

    @Test
    public void negativeTest() {
        DivideTwoIntegers d = new DivideTwoIntegers();
        Assert.assertEquals(2147483647, d.divide(-2147483647, -1));

        Assert.assertEquals(2147483647, d.divide1(-2147483647, -1));
    }

    @Test
    public void weirdTest() {
        DivideTwoIntegers d = new DivideTwoIntegers();
        Assert.assertEquals(2147483647, d.divide(-2147483648, -1));
        Assert.assertEquals(-2147483648, d.divide(-2147483648, 1));
        Assert.assertEquals(-1073741824, d.divide(-2147483648, 2));

        Assert.assertEquals(2147483647, d.divide1(-2147483648, -1));
        Assert.assertEquals(-2147483648, d.divide1(-2147483648, 1));
        Assert.assertEquals(-1073741824, d.divide1(-2147483648, 2));


    }

    @Test
    public void easyTest() {
        DivideTwoIntegers d = new DivideTwoIntegers();
        Assert.assertEquals(1, d.divide(1, 1));
        Assert.assertEquals(-1, d.divide(1, -1));

        Assert.assertEquals(1, d.divide1(1, 1));
        Assert.assertEquals(-1, d.divide1(1, -1));
    }
}
