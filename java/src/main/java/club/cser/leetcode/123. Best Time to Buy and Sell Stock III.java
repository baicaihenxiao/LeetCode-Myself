package club.cser.leetcode;

class BestTimetoBuyandSellStockIII {
    public int maxProfit(int[] prices) {

        if (prices.length == 0 || prices.length == 1)
            return 0;

        final int days = prices.length;

        int[] leftMaxProfit = new int[days];
        int[] rightMaxProfit = new int[days];

        leftMaxProfit[0] = 0;
        rightMaxProfit[days - 1] = 0;

        int tmpMin = prices[0], tmpMax = prices[days - 1];

        for (int i = 1; i < days; ++ i) {
            if (prices[i] < tmpMin)
                tmpMin = prices[i];
            leftMaxProfit[i] = Math.max(leftMaxProfit[i - 1], prices[i] - tmpMin);
        }

        for (int i = days - 2; i >= 0; -- i) {
            if (prices[i] > tmpMax)
                tmpMax = prices[i];
            rightMaxProfit[i] = Math.max(rightMaxProfit[i + 1], tmpMax - prices[i]);
        }

        int res = Math.max(leftMaxProfit[days - 1], rightMaxProfit[0]);

        for (int i = 0; i < days - 1; ++ i) {
            res = Math.max(leftMaxProfit[i] + rightMaxProfit[i + 1], res);
        }

        return res;
    }
}