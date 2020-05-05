package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BestTimetoBuyandSellStockIITest {
    BestTimetoBuyandSellStockII b;

    @Before
    public void init() {
        b = new BestTimetoBuyandSellStockII();
    }

    @Test
    public void basicTest1() {
        int[] prices = {7,1,5,3,6,4};
        Assert.assertEquals(7, b.maxProfit(prices));
    }

    @Test
    public void basicTest2() {
        int[] prices = {1,2,3,4,5};
        Assert.assertEquals(4, b.maxProfit(prices));
    }


}
