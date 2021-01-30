package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StoneGameVIITest {
    private StoneGameVII s;

    @Before
    public void init() {
        s = new StoneGameVII();
    }

    @Test
    public void basicTest1() {
        int[] stones = {5,3,1,4,2};
        int res = 6;

        Assert.assertEquals(res, s.stoneGameVII(stones));
    }

    @Test
    public void basicTest2() {
        int[] stones = {7,90,5,1,100,10,10,2};
        int res = 122;

        Assert.assertEquals(res, s.stoneGameVII(stones));
    }
    @Test
    public void basicTest3() {
        int[] stones = {1,2,3};
        int res = 2;

        Assert.assertEquals(res, s.stoneGameVII(stones));
    }
}
