package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FourSumIITest {
    FourSumII t;

    @Before
    public void init() {
        t = new FourSumII();
    }

    @Test
    public void basicTest1() {
        int[] A = { 1, 2};
        int[] B = {-2,-1};
        int[] C = {-1, 2};
        int[] D = { 0, 2};

        int res = 2;

        Assert.assertEquals(res, t.fourSumCount(A, B, C, D));
    }
}
