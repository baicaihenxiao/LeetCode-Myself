package club.cser.leetcode;

class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        final int N = s.length();
        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            dp[i][i] = 1;
        }

        for (int len = 2; len <= N; len++) {
            for (int i = 0; i <= N - len; i++) {
                int left = i, right = i + len - 1;

                if (s.charAt(left) == s.charAt(right)) {
                    dp[left][right] = 2 + ((right > left + 1) ? dp[left + 1][right - 1] : 0);
                } else {
                    dp[left][right] = Math.max(dp[left + 1][right], dp[left][right - 1]);
                }
            }
        }

        return dp[0][N - 1];

    }
}