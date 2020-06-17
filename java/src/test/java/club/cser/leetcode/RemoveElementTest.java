package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class RemoveElementTest {
    RemoveElement r;

    @Before
    public void init() {
        r = new RemoveElement();
    }

    @Test
    public void basicTest1() {
        int[] nums = {3,2,2,3};
        int val = 3;
        int[] res = {2, 2};
        Assert.assertEquals(2, r.removeElement(nums, val));
        Assert.assertArrayEquals(res, Arrays.stream(nums).limit(2).toArray());
    }

    @Test
    public void basicTest2() {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        int[] res = {0, 0, 1, 3, 4};
        Assert.assertEquals(5, r.removeElement(nums, val));
        Assert.assertArrayEquals(res, Arrays.stream(nums).limit(5).sorted().toArray());
    }

    @Test
    public void cornerTest1() {
        int[] nums = {1};
        int val = 1;
        int[] res = {};
        Assert.assertEquals(0, r.removeElement(nums, val));
        Assert.assertArrayEquals(res, Arrays.stream(nums).limit(0).sorted().toArray());
    }
}
