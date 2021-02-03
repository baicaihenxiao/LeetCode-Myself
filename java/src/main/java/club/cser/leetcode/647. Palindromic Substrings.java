package club.cser.leetcode;

class PalindromicSubstrings {
    public int countSubstrings(String s) {
        final int N = s.length();
        boolean[][] dp = new boolean[N][N];
        int res = 0;

        for (int len = 1; len <= N; len++) {
            for (int i = 0; i <= N - len; i++) {
                int left = i, right = i + len - 1;
                if (right - left <= 1) {
                    dp[left][right] = s.charAt(left) == s.charAt(right);
                } else {
                    dp[left][right] = (s.charAt(left) == s.charAt(right)) && dp[left + 1][right - 1];
                }

                if (dp[left][right]) {
                    ++ res;
                }
            }
        }
        return res;
    }

    // 中间往外扩张
    public int countSubstrings1(String s) {
        final int N = s.length();
        int res = 0;

        for (int i = 0; i < N; i++) {
            for (int len = 0; i - len >= 0 && i + len < N ; len++) {
                if (s.charAt(i - len) == s.charAt(i + len))
                    ++ res;
                else
                    break;
            }

            for (int len = 0; i - len >= 0 && i + len + 1 < N ; len++) {
                if (s.charAt(i - len) == s.charAt(i + len + 1))
                    ++ res;
                else
                    break;
            }
        }
        return res;
    }
}