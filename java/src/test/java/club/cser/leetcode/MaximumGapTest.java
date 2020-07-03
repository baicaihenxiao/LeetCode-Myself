package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class MaximumGapTest {
    MaximumGap s;

    @Before
    public void init() {
        s = new MaximumGap();
    }

    @Test
    public void basicTest1() {
        int[] nums = {3,6,9,1};
        int res = 3;

        Assert.assertEquals(res, s.maximumGap1(nums));
    }

    @Test
    public void basicTest2() {
        int[] nums = {10};
        int res = 0;

        Assert.assertEquals(res, s.maximumGap1(nums));
    }

    @Test
    public void basicTest3() {
        int[] nums = {1,10000000};
        int res = 9999999;

        Assert.assertEquals(res, s.maximumGap1(nums));
    }
}
