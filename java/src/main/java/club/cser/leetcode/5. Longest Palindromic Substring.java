package club.cser.leetcode;

import java.util.stream.Stream;

class LongestPalindromicSubstring {
    // 最简单的dp，时间和空间都是O(n^2)
    public String longestPalindrome(String s) {
        final int N = s.length();
        boolean[][] dp = new boolean[N][N];
        int resLeft = 0, resRight = 0;

        for (int len = 1; len <= N; len++) {
            for (int i = 0; i <= N - len; i++) {
                int left = i, right = i + len - 1;
                if (right - left <= 1) {
                    dp[left][right] = s.charAt(left) == s.charAt(right);
                } else {
                    dp[left][right] = (s.charAt(left) == s.charAt(right)) && dp[left + 1][right - 1];
                }

                if (dp[left][right] && (right - left > resRight - resLeft)) {
                    resRight = right;
                    resLeft = left;
                }
            }
        }

        return s.substring(resLeft, resRight + 1);

    }
}