package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HouseRobberIITest {
    private HouseRobberII s;

    @Before
    public void init() {
        s = new HouseRobberII();
    }

    @Test
    public void basicTest1() {
        int[] nums = {1,2,3,1};
        int res = 4;
        Assert.assertEquals(res, s.rob(nums));
    }

    @Test
    public void basicTest2() {
        int[] nums = {0};
        int res = 0;
        Assert.assertEquals(res, s.rob(nums));
    }

    @Test
    public void basicTest3() {
        int[] nums = {2,3,2};
        int res = 3;
        Assert.assertEquals(res, s.rob(nums));
    }
}
