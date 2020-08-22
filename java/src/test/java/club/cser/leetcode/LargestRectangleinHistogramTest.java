package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LargestRectangleinHistogramTest {
    private LargestRectangleinHistogram s;

    @Before
    public void init() {
        s = new LargestRectangleinHistogram();
    }

    @Test
    public void basicTest1() {
        int[] nums = {2,1,5,6,2,3};
        int res = 10;
        Assert.assertEquals(res, s.largestRectangleArea(nums));
    }
    @Test
    public void basicTest2() {
        int[] nums = {4,2,0,3,2,4,3,4};
        int res = 10;
        Assert.assertEquals(res, s.largestRectangleArea(nums));
    }
    @Test
    public void basicTest3() {
        int[] nums = {4};
        int res = 4;
        Assert.assertEquals(res, s.largestRectangleArea(nums));
    }
}
