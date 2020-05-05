package club.cser.leetcode;

import java.util.Arrays;

class BestTimetoBuyandSellStockwithCooldown {

    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0 || prices.length == 1)
            return 0;

        int[] res = new int[prices.length];

        res[0] = 0;
        res[1] = Math.max(prices[1] - prices[0], 0);

        for (int i = 2; i < prices.length; ++ i) {
            //要么什么都不做，要么卖
            res[i] =  res[i - 1];//什么都不做
            res[i] = Math.max(res[i], prices[i] - prices[0]); // 第0天买，i天卖
            res[i] = Math.max(res[i], prices[i] - prices[1]); // 第1天买，i天卖

            for (int j = 2; j < i; ++ j) {
                res[i] = Math.max(res[i], prices[i] - prices[j] + res[j - 2]); // 第j天买，i天卖，加上前j-2天的收益
            }
        }

        return res[prices.length - 1];
        
    }

    public int maxProfitSimplified(int[] prices) {

        if (prices == null || prices.length == 0 || prices.length == 1)
            return 0;

        int[] sell = new int[prices.length];
        int[] buy = new int[prices.length];

        buy[0] = - prices[0]; //buy的意义在手上有股票，所以buy[0]一定要买prices[0]
        sell[0] = 0;

        buy[1] = - Math.min(prices[0], prices[1]); // 第0天买或者第1天买
        sell[1] = Math.max(prices[1] - prices[0], 0);

        for (int i = 2; i < prices.length; ++ i) {
            // max{当天不买 用昨天的值， 当天买 用前天卖完(未持有股票 不一定刚好是前天卖的)最大的利益-今天的股票价格}
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
            // max{当天不卖 用昨天的值， 当天卖 用昨天买完(持有股票 不一定刚好是昨天买的)最大利益+今天的股票价格}
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }

        return  sell[prices.length - 1];
    }
}

// sell[0] = 0;
//         buy[0] = -prices[0];
//
//         for (int i = 1; i < prices.length; ++i) {
//        sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
//        buy[i] = Math.max(buy[i - 1], (i > 1 ? sell[i - 2] : 0) - prices[i]);
//        }
//        System.out.println(Arrays.toString(buy));
//        System.out.println(Arrays.toString(sell));
//        return sell[prices.length - 1];