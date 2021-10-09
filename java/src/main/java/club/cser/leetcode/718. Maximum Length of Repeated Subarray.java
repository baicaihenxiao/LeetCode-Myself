package club.cser.leetcode;

import java.util.Arrays;

class MaximumLengthofRepeatedSubarray {
    public int findLength(int[] A, int[] B) {

        int[][] dp = new int[A.length + 1][B.length + 1];
        int res = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    res = Math.max(res, dp[i + 1][j + 1]);
                } else {
                    dp[i + 1][j + 1] = 0;
                }
            }
        }

        return res;
    }
}