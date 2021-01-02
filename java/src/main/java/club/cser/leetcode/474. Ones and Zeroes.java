package club.cser.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class OnesandZeroes {
    public int findMaxForm(String[] strs, int m, int n) {

        // m行n列
        int[][] dp = Stream.generate(() -> new int[n + 1]).limit(m + 1).toArray(int[][]::new);
//        int[][] dp1 = IntStream.range(0, m).mapToObj(index -> new int[n]).toArray(int[][]::new);

        for (String str : strs) {
            int zeros = 0, ones = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }

            if (zeros > m || ones > n)
                continue;

            for (int i = m; i >= zeros; i --) {
                for (int j = n; j >= ones; j --) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }

        return dp[m][n];

    }
}