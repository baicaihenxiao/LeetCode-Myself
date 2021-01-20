package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StoneGameTest {

    private StoneGame s;

    @Before
    public void init() {
        s = new StoneGame();
    }

    @Test
    public void basicTest1() {
        int[] nums = {5,3,4,5};
        int res = 3;

        Assert.assertEquals(true, s.stoneGame1(nums));
    }
}
