package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NonegativeIntegerswithoutConsecutiveOnesTest {

    private NonegativeIntegerswithoutConsecutiveOnes s;

    @Before
    public void init() {
        s = new NonegativeIntegerswithoutConsecutiveOnes();
    }

    @Test
    public void basicTest1() {
        int num = 5;
        int res = 5;
        Assert.assertEquals(res, s.findIntegers(num));
    }

    @Test
    public void basicTest2() {
        int num = 7;
        int res = 5;
        Assert.assertEquals(res, s.findIntegers(num));
    }

    @Test
    public void basicTest3() {
        int num = 15;
        int res = 8;
        Assert.assertEquals(res, s.findIntegers(num));
    }
    @Test
    public void basicTest4() {
        int num = 59;
        int res = 21;
        Assert.assertEquals(res, s.findIntegers(num));
    }
    @Test
    public void basicTest5() {
        int num = 10000;
        int res = 843;
        Assert.assertEquals(res, s.findIntegers(num));
    }

}
