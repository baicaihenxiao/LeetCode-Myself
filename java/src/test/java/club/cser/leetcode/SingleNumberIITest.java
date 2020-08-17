package club.cser.leetcode;

import club.cser.commons.MyAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SingleNumberIITest {
    private SingleNumberII s;

    @Before
    public void init() {
        s = new SingleNumberII();
    }

    @Test
    public void basicTest1() {
        int[] nums = {2,2,3,2};
        int res = 3;
        Assert.assertEquals(res, s.singleNumber(nums));
    }

    @Test
    public void basicTest2() {
        int[] nums = {0,1,0,1,0,1,99};
        int res = 99;
        Assert.assertEquals(res, s.singleNumber(nums));
    }

    @Test
    public void basicTest3() {
        int[] nums = {0, -1,0, -1,0, -1,99};
        int res = 99;
        Assert.assertEquals(res, s.singleNumber(nums));
    }
}
