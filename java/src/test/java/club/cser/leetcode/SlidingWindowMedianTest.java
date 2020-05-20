package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class SlidingWindowMedianTest {
    SlidingWindowMedian s;

    @Before
    public void init() {
        s = new SlidingWindowMedian();
    }

    @Test
    public void basicTest1() {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        double[] res = {1,-1,-1,3,5,6};
        Assert.assertEquals(Arrays.toString(res), Arrays.toString(s.medianSlidingWindow(nums, k)));
    }

    @Test
    public void extreamTest1() {
        int[] nums = {2147483647,2147483647};
        int k = 2;
        double[] res = {2147483647.00000};
        Assert.assertEquals(Arrays.toString(res), Arrays.toString(s.medianSlidingWindow(nums, k)));
    }
}
