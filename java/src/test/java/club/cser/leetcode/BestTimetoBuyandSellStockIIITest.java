package club.cser.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class BestTimetoBuyandSellStockIIITest {
    BestTimetoBuyandSellStockIII b;

    @Before
    public void init() {
        b = new BestTimetoBuyandSellStockIII();
    }

    @Test
    public void basicTest1() {
        int[] prices = {3,3,5,0,0,3,1,4};
        Assert.assertEquals(6, b.maxProfit(prices));
    }

    @Test
    public void basicTest2() {
        int[] prices = {1,2,3,4,5};
        Assert.assertEquals(4, b.maxProfit(prices));
    }

    @Test
    public void basicTest3() {
        int[] prices = {7,6,4,3,1};
        Assert.assertEquals(0, b.maxProfit(prices));
    }

}
