package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StoneGameIIITest {
    private StoneGameIII s;

    @Before
    public void init() {
        s = new StoneGameIII();
    }

    @Test
    public void basicTest1() {
        int[] nums = {1, 2, 3, 7};
        String res = "Bob";

        Assert.assertEquals(res, s.stoneGameIII_BottomUp(nums));
    }

    @Test
    public void basicTest2() {
        int[] nums = {1, 2, 3, -9};
        String res = "Alice";

        Assert.assertEquals(res, s.stoneGameIII_BottomUp(nums));
    }

    @Test
    public void basicTest3() {
        int[] nums = {1, 2, 3, 6};
        String res = "Tie";

        Assert.assertEquals(res, s.stoneGameIII_BottomUp(nums));
    }

    @Test
    public void basicTest4() {
        int[] nums = {1, 2, 3, -1, -2, -3, 7};
        String res = "Alice";

        Assert.assertEquals(res, s.stoneGameIII_BottomUp(nums));
    }

    @Test
    public void basicTest5() {
        int[] nums = {-1, -2, -3};
        String res = "Tie";

        Assert.assertEquals(res, s.stoneGameIII_BottomUp(nums));
    }


}
