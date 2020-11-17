package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TargetSumTest {

    private TargetSum s;

    @Before
    public void init() {
        s = new TargetSum();
    }

    @Test
    public void basicTest1() {
        int[] param = {1,1,1,1,1};
        int target = 3;
        int res = 5;
        Assert.assertEquals(res, s.findTargetSumWays(param, target));
    }
}
