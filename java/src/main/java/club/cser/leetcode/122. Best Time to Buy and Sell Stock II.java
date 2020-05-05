package club.cser.leetcode;

class BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        int res = 0;
        int tmpLow = prices[0];
        int tmpHigh = prices[0];
        for (int price: prices) {
            if (price >= tmpHigh) {
                tmpHigh = price;
            } else {
                res += tmpHigh - tmpLow;
                tmpLow = price;
                tmpHigh = price;
            }
        }

        return res + tmpHigh - tmpLow;
    }
}