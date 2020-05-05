package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BestTimetoBuyandSellStockwithCooldownTest {
    BestTimetoBuyandSellStockwithCooldown b;

    @Before
    public void init() {
        b = new BestTimetoBuyandSellStockwithCooldown();
    }

    @Test
    public void basicTest1() {
        int[] prices = {1,2,3,0,2};
        Assert.assertEquals(3, b.maxProfit(prices));
    }

    @Test
    public void basicTest2() {
        int[] prices = {1,2,3,4,5};
        Assert.assertEquals(4, b.maxProfit(prices));
    }

    @Test
    public void noPriceTest() {
        int[] prices = {};
        Assert.assertEquals(0, b.maxProfit(prices));
    }

    @Test
    public void basicTest2Simplfied() {
        int[] prices = {1,2,3,4,5,1,2,3,4};
        Assert.assertEquals(6, b.maxProfitSimplified(prices));
    }

}
