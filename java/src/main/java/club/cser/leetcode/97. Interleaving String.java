package club.cser.leetcode;

import java.util.Arrays;

class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {

        if (s3.length() != s1.length() + s2.length())
            return false;

        boolean[][] dp = new boolean[2][s2.length() + 1];

        dp[0][0] = true;
        for (int i = 1; i < s2.length() + 1; ++ i) {
            dp[0][i] = dp[0][i - 1] && (s3.charAt(i - 1) == s2.charAt(i - 1));
        }

        int currentRow = 1, previousRow = 0;

        for (int i = 1; i < s1.length() + 1; ++ i) {
            dp[currentRow][0] = dp[previousRow][0] && (s3.charAt(i - 1) == s1.charAt(i - 1));
            for (int j = 1; j < s2.length() + 1; ++ j) {
                dp[currentRow][j] =
                        (dp[previousRow][j] && (s3.charAt(i + j - 1) == s1.charAt(i - 1)))
                        || (dp[currentRow][j - 1] && (s3.charAt(i + j - 1) == s2.charAt(j - 1)));
            }
            currentRow = previousRow;
            previousRow = (currentRow + 1) % 2;
        }

        return dp[previousRow][s2.length()];
    }
}