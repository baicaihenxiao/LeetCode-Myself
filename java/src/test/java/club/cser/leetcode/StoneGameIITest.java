package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StoneGameIITest {
    private StoneGameII s;

    @Before
    public void init() {
        s = new StoneGameII();
    }

    @Test
    public void basicTest1() {
        int[] nums = {2,7,9,4,4};
        int res = 10;

        Assert.assertEquals(res, s.stoneGameII(nums));
    }

    @Test
    public void basicTest2() {
        int[] nums = {1,2,3,4,5,100};
        int res = 104;

        Assert.assertEquals(res, s.stoneGameII(nums));
    }
    @Test
    public void basicTest3() {
        int[] nums = {3111,4303,2722,2183,6351,5227,8964,7167,9286,6626,2347,1465,5201,7240,5463,8523,8163,9391,8616,5063,7837,7050,1246,9579,7744,6932,7704,9841,6163,4829,7324,6006,4689,8781,621};
        int res = 112766;

        Assert.assertEquals(res, s.stoneGameII(nums));
    }
    @Test
    public void basicTest4() {
        int[] nums = {1};
        int res = 1;

        Assert.assertEquals(res, s.stoneGameII(nums));
    }
}
