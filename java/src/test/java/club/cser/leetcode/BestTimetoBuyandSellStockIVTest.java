package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BestTimetoBuyandSellStockIVTest {
    BestTimetoBuyandSellStockIV b;

    @Before
    public void init() {
        b = new BestTimetoBuyandSellStockIV();
    }

    @Test
    public void basicTest1() {
        int[] prices = {2,4,1};
        int k = 2;
        Assert.assertEquals(2, b.maxProfit(k, prices));
    }

    @Test
    public void basicTest2() {
        int[] prices = {3,2,6,5,0,3};
        int k = 2;
        Assert.assertEquals(7, b.maxProfit(k, prices));
    }
}
