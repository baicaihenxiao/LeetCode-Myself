package club.cser.leetcode;

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

        if (prices == null || prices.length == 0) return 0;

        int[] sell = new int[prices.length];
        int[] buy = new int[prices.length];
        sell[0] = 0;
        buy[0] = -prices[0];

        for (int i = 1; i < prices.length; ++i) {
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            buy[i] = Math.max(buy[i - 1], (i > 1 ? sell[i - 2] : 0) - prices[i]);
        }
        return sell[prices.length - 1];

    }
}