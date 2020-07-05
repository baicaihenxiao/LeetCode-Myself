package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KthLargestElementinanArrayTest {

    KthLargestElementinanArray s;

    @Before
    public void init() {
        s = new KthLargestElementinanArray();
    }

    @Test
    public void basicTest1() {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        int res = 5;

        Assert.assertEquals(res, s.findKthLargest(nums, k));
    }

    @Test
    public void basicTest2() {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        int res = 4;

        Assert.assertEquals(res, s.findKthLargest(nums, k));
    }
}
