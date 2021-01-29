package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StoneGameVITest {

    private StoneGameVI s;

    @Before
    public void init() {
        s = new StoneGameVI();
    }

    @Test
    public void basicTest1() {
        int[] aliceValues = {1,3}, bobValues = {2,1};
        int res = 1;

        Assert.assertEquals(res, s.stoneGameVI(aliceValues, bobValues));
    }

    @Test
    public void basicTest2() {
        int[] aliceValues = {1,2}, bobValues = {3,1};
        int res = 0;

        Assert.assertEquals(res, s.stoneGameVI(aliceValues, bobValues));
    }

    @Test
    public void basicTest3() {
        int[] aliceValues = {2,4,3}, bobValues = {1,6,7};
        int res = -1;

        Assert.assertEquals(res, s.stoneGameVI(aliceValues, bobValues));
    }
}
