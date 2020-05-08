package club.cser.leetcode;

import java.util.Arrays;
import java.util.BitSet;

class BestTimetoBuyandSellStockIV {

    public int maxProfit(int k, int[] prices) {

        if (prices.length == 0 || prices.length == 1 || k <= 0)
            return 0;

        final int days = prices.length;

        //转化为最大m子段和
        for (int i = 0; i < days - 1; ++ i) {
            prices[i] = prices[i + 1] - prices[i];
        }

        System.out.println("prices:" + Arrays.toString(prices));

        if (k > days / 2)
            k = days / 2;

        int[][] dp = new int[2][];
        dp[0] = new int[days];
        dp[1] = new int[days];
        int currentRow = 1;
        int res = 0;

        for (int i = 0; i < k; ++ i) {
            int previousRow = (currentRow + 1) % 2;
            int tmpMax = 0;
            for (int j = 1; j < days; ++ j) {
                dp[currentRow][j] = Math.max(dp[currentRow][j - 1] + prices[j - 1], tmpMax + prices[j - 1]);
                tmpMax = Math.max(tmpMax, dp[previousRow][j]);
                res = Math.max(res, dp[currentRow][j]);
            }

            System.out.println("i = " + i + ":" + Arrays.toString(dp[currentRow]));
            currentRow = previousRow;
        }

        return res;
    }


}
