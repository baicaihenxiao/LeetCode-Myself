package club.cser.leetcode;

import java.util.Arrays;

class StoneGame {
    public boolean stoneGame(int[] piles) {

        int[] dp = new int[piles.length];

        for (int i = 0; i < piles.length; i++) {
            dp[i] = -piles[i];
        }

        for (int i = 2; i <= piles.length; i++) {
            for (int j = 0; j <= piles.length - i; j++) {
                if (i % 2 == 0) { // A取
                    dp[j] = Math.max(dp[j + 1] + piles[j], dp[j] + piles[j + i - 1]);
                } else { // B取
                    dp[j] = Math.max(dp[j + 1] - piles[j], dp[j] - piles[j + i - 1]);
                }
            }
        }

        return dp[0] > 0;

    }

    public boolean stoneGame1(int[] piles) {

        int[] dp = new int[piles.length];

        for (int i = 0; i < piles.length; i++) {
            dp[i] = piles[i];
        }

        for (int i = 2; i <= piles.length; i++) {
            for (int j = 0; j <= piles.length - i; j++) {
                dp[j] = Math.max(piles[j] - dp[j + 1] , piles[j + i - 1] - dp[j]);
            }
        }
//        System.out.println(Arrays.toString(dp));
        return dp[0] > 0;

    }
}
