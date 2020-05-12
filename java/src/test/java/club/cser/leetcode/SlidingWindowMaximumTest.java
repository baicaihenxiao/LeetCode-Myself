package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class SlidingWindowMaximumTest {

    SlidingWindowMaximum s;

    @Before
    public void init() {
        s = new SlidingWindowMaximum();
    }

    @Test
    public void basicTest1() {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = {3,3,5,5,6,7};
        Assert.assertEquals(Arrays.toString(res), Arrays.toString(s.maxSlidingWindow(nums, k)));
    }

    @Test
    public void basicTest2() {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 8;
        int[] res = {7};
        Assert.assertEquals(Arrays.toString(res), Arrays.toString(s.maxSlidingWindow(nums, k)));
    }

    @Test
    public void basicTest3() {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 7;
        int[] res = {6, 7};
        Assert.assertEquals(Arrays.toString(res), Arrays.toString(s.maxSlidingWindow(nums, k)));
    }

}


