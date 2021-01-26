package club.cser.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

class StoneGameIV {

    public boolean winnerSquareGame(int n) {
        final int N_MAX_VALUE = 100000; // 100000改成n速度加快
        final int SQUARE_ROOT_MAX_VALUE = 316; //sqrt(100000) = 316.?
        // 事先算好各个数的平方
        final int[] square = IntStream.range(0, SQUARE_ROOT_MAX_VALUE + 2).map(i -> i * i).toArray();

        boolean[] dp = new boolean[N_MAX_VALUE + 1];

//        System.out.println(Arrays.toString(square));
        for (int i = 0; i <= N_MAX_VALUE; i++) {
            for (int j = 1; square[j] <= i ; j++) {
                if (dp[i - square[j]] == false) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    public boolean winnerSquareGame1(int n) {

        // 默认false，先手必败
        boolean[] dp = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            if (dp[i] == true)
                continue;
            // dp[i]为先手必败，那么dp[i + j * j]先手必胜
            for (int j = 1; i + j * j <= n ; j ++) {
                dp[i + j * j] = true;
            }
        }

        return dp[n];
    }
}