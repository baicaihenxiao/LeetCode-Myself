package club.cser.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class CountDifferentPalindromicSubsequences {
    final int CHAR_KIND = 4;
    final int MOD = 1000000007;
    List<Integer>[] charIndex = Stream.generate(ArrayList<Integer>::new).limit(CHAR_KIND).toArray(ArrayList[]::new);
    int[][] dp;

    public int countPalindromicSubsequences(String S) {
        dp = new int[S.length()][S.length()];
        for (int i = 0; i < S.length(); i++) {
            charIndex[S.charAt(i) - 'a'].add(i);
        }

        return dfs(0, S.length() - 1); // 不用传 S，神奇

    }

    int dfs(int begin, int end) {
        if (begin > end) {
            return 0;
        }
        if (dp[begin][end] > 0) {
            return dp[begin][end];
        }

        int res = 0;

        for (int i = 0; i < CHAR_KIND; i++) {
            List<Integer> curIndexList = charIndex[i];
            int newBegin = -1, newEnd = -1;

            for (int index: curIndexList) {
                if (index >= begin) {
                    newBegin = index;
                    break;
                }
            }

            for (int j = curIndexList.size() - 1; j >=0; j --) {
                if (curIndexList.get(j) <= end) {
                    newEnd = curIndexList.get(j);
                    break;
                }
            }

            if (newBegin == -1 || newBegin > newEnd) {
                continue;
            }

            if (newBegin == newEnd) {
                res += 1;
            } else {
                res += 2;
            }

            res = (res + dfs(newBegin + 1, newEnd - 1)) % MOD;
        }

        dp[begin][end] = res;

        return res;
    }
/*    public int countPalindromicSubsequences(String S) {
        int res = 0;
        final int N = S.length();
        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            dp[i][i] = 1;
        }
        res += N;

        for (int len = 2; len <= N; len++) {
            for (int i = 0; i <= N - len; i++) {
                int left = i, right = i + len - 1;

                if (S.charAt(left) == S.charAt(right)) {
                    dp[left][right] = 2 + ((right > left + 1) ? dp[left + 1][right - 1] : 0);
                } else {
                    dp[left][right] = Math.max(dp[left + 1][right], dp[left][right - 1]);
                }
            }
        }

        return dp[0][N - 1];

    }*/
}