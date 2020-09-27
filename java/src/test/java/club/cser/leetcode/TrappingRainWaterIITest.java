package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrappingRainWaterIITest {
    private TrappingRainWaterII s;

    @Before
    public void init() {
        s = new TrappingRainWaterII();
    }

    @Test
    public void basicTest1() {
        int[][] height = {
                {1,4,3,1,3,2},
                {3,2,1,3,2,4},
                {2,3,3,2,3,1}
        };
        int res = 4;

        Assert.assertEquals(res, s.trapRainWater(height));
    }
    @Test
    public void basicTest2() {
        int[][] height = {
                {12,13,1,12 },
                {13,4,13,12 },
                {13,8,10,12 },
                {12,13,12,12},
                {13,13,13,13}
        };
        int res = 14;

        Assert.assertEquals(res, s.trapRainWater(height));
    }
}
