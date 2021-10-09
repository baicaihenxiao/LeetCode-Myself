package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MaximumLengthofRepeatedSubarrayTest {
    MaximumLengthofRepeatedSubarray b;

    @Before
    public void init() {
        b = new MaximumLengthofRepeatedSubarray();
    }

    @Test
    public void basicTest1() {
        int[] nums1 = {1,2,3,2,1}, nums2 = {3,2,1,4,7};
        int res = 3;
        Assert.assertEquals(res, b.findLength(nums1, nums2));
    }

    @Test
    public void basicTest2() {
        int[] nums1 = {0,0,0,0,0}, nums2 = {0,0,0,0,0};
        int res = 5;
        Assert.assertEquals(res, b.findLength(nums1, nums2));
    }

    @Test
    public void basicTest3() {
        int[] nums1 = {0,0,0,0,1}, nums2 = {1,0,0,0,0};
        int res = 4;
        Assert.assertEquals(res, b.findLength(nums1, nums2));
    }

    @Test
    public void basicTest4() {
        int[] nums1 = {1,2,3,2,1}, nums2 = {3,2,1,4};
        int res = 3;
        Assert.assertEquals(res, b.findLength(nums1, nums2));
    }

}
