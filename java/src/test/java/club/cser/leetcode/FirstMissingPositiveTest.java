package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FirstMissingPositiveTest {
    FirstMissingPositive m;

    @Before
    public void init() {
        m = new FirstMissingPositive();
    }

    @Test
    public void basicTest1() {
        int[] nums = {3,0,1};
        int res = 2;
        Assert.assertEquals(res, m.firstMissingPositive1(nums));
    }

    @Test
    public void basicTest2() {
        int[] nums = {3,4,-1,1};
        int res = 2;
        Assert.assertEquals(res, m.firstMissingPositive1(nums));
    }

    @Test
    public void basicTest3() {
        int[] nums = {7,8,9,11,12};
        int res = 1;
        Assert.assertEquals(res, m.firstMissingPositive1(nums));
    }
}
