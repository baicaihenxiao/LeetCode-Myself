package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HouseRobberTest {
    private HouseRobber s;

    @Before
    public void init() {
        s = new HouseRobber();
    }

    @Test
    public void basicTest1() {
        int[] nums = {1,2,3,1};
        int res = 4;
        Assert.assertEquals(res, s.rob(nums));
    }

    @Test
    public void basicTest2() {
        int[] nums = {2,7,9,3,1};
        int res = 12;
        Assert.assertEquals(res, s.rob(nums));
    }



}
