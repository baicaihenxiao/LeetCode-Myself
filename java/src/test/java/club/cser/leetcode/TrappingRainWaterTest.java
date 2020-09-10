package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrappingRainWaterTest {
    private TrappingRainWater s;

    @Before
    public void init() {
        s = new TrappingRainWater();
    }

    @Test
    public void basicTest1() {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int res = 6;

        Assert.assertEquals(res, s.trapStack(height));
    }
}
