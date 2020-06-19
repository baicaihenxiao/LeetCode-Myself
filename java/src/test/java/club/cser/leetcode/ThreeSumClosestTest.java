package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ThreeSumClosestTest {

    ThreeSumClosest t;

    @Before
    public void init() {
        t = new ThreeSumClosest();
    }

    @Test
    public void basicTest1() {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        int res = 2;
        Assert.assertEquals(res, t.threeSumClosest(nums, target));
    }

    @Test
    public void basicTest2() {
        int[] nums = {0,1,2};
        int target = 3;
        int res = 3;
        Assert.assertEquals(res, t.threeSumClosest(nums, target));
    }

    @Test
    public void cornerTest1() {
        int[] nums = {0,0,0};
        int target = 1;
        int res = 0;
        Assert.assertEquals(res, t.threeSumClosest(nums, target));
    }

    @Test
    @Ignore
    // 题目规定了范围，不会有这种越界的情况
    public void cornerTest2() {
        int[] nums = {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE};
        int target = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE; // no
        Assert.assertEquals(res, t.threeSumClosest(nums, target));
    }
}
