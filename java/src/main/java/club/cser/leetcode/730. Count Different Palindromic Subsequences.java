package club.cser.leetcode;

import club.cser.commons.Converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class CountDifferentPalindromicSubsequences {
    final int CHAR_KIND = 4;
    final int MOD = 1000000007;
    List<Integer>[] charIndex = Stream.generate(ArrayList<Integer>::new).limit(CHAR_KIND).toArray(ArrayList[]::new);
    int[][] dp;
    String s;

    // 法 1
    public int countPalindromicSubsequences(String S) {
        dp = new int[S.length()][S.length()];
        for (int i = 0; i < S.length(); i++) {
            charIndex[S.charAt(i) - 'a'].add(i);
        }

        return dfs(0, S.length() - 1); // 不用传 S，神奇

    }

    private int dfs(int begin, int end) {
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

    // 法 2
    public int countPalindromicSubsequences1(String S) {
        dp = new int[S.length()][S.length()];
        this.s = S;
        for (int i = 0; i < S.length(); i++) {
            charIndex[S.charAt(i) - 'a'].add(i);
            dp[i][i] = 1;
        }

        dfs1(0, S.length() - 1);
//        Arrays.stream(dp).map(Arrays::toString).forEach(System.out::println);
        return dp[0][S.length() - 1];
    }

    private int dfs1(int begin, int end) {
        if (begin > end) {
            return 0;
        }

        if (dp[begin][end] > 0) {
            return dp[begin][end];
        }

        if (s.charAt(begin) != s.charAt(end)) {
            dp[begin][end] = dfs1(begin + 1, end) + dfs1(begin, end - 1) - dfs1(begin + 1, end - 1);
        } else {
            List<Integer> curCharIndices = charIndex[s.charAt(begin) - 'a'];
            int left = curCharIndices.indexOf(begin); // left 和 right 一定能找到。且 right > left，因为已经赋值了dp[i][i]=1
            int right = curCharIndices.lastIndexOf(end);
            if (left + 1 == right) { // 1. S[i+1 ~ j-1] 里不含 a
                dp[begin][end] = dfs1(begin + 1, end - 1) * 2 + 2;
            } else if (left + 2 == right) { // 2. S[i+1 ~ j-1] 含 1 个 a
                dp[begin][end] = dfs1(begin + 1, end - 1) * 2 + 1;
            } else { // 3. `S[i+1 ~ j-1]` 含 2 个（及以上）a
                left = curCharIndices.get(left + 1);
                right = curCharIndices.get(right - 1);
                dp[begin][end] = dfs1(begin + 1, end - 1) * 2 - dfs1(left + 1, right - 1);
            }
        }

        // 以 dp[begin][end] = dfs1(begin + 1, end) + dfs1(begin, end - 1) - dfs1(begin + 1, end - 1);为例， 前面两个大于 MOD 的数取余后可能是个很小的数，再减去后面的数就变成负数了。
        dp[begin][end] %= MOD;
        if (dp[begin][end] < 0)
            dp[begin][end] += MOD;
        //  不能这样写 dp[begin][end] = (dp[begin][end] + MOD) % MOD; 可能会 int 溢出。


        return dp[begin][end];
    }

    // 法 3
    public int countPalindromicSubsequences2(String S) {
        int res = 0;
        final int MOD = 1000000007;
        final int CHAR_KIND = 4;
        final int N = S.length();
        List<Integer>[] charIndex = Stream.generate(ArrayList<Integer>::new).limit(CHAR_KIND).toArray(ArrayList[]::new);
        int[][] dp = new int[N][N];

        for (int i = 0; i < S.length(); i++) {
            charIndex[S.charAt(i) - 'a'].add(i);
            dp[i][i] = 1;
        }


        for (int len = 2; len <= N; len++) {
            for (int i = 0; i <= N - len; i++) {
                int begin = i, end = i + len - 1;

                if (S.charAt(begin) != S.charAt(end)) {
                    dp[begin][end] = dp[begin + 1][end] + dp[begin][end - 1] - dp[begin + 1][end - 1];
                    // 后面不用写成  - ((begin + 1 < end - 1) ? 0 : dp[begin + 1][end - 1]);
                    // 因为如果 begin + 1 < end - 1，那么会落到 dp 数组的左下半区，即为0。
                } else {
                    List<Integer> curCharIndices = charIndex[S.charAt(begin) - 'a'];
                    int left = curCharIndices.indexOf(begin); // left 和 right 一定能找到。且 right > left，因为已经赋值了dp[i][i]=1
                    int right = curCharIndices.lastIndexOf(end);
                    if (left + 1 == right) { // 1. S[i+1 ~ j-1] 里不含 a
                        dp[begin][end] = dp[begin + 1][end - 1] * 2 + 2;
                    } else if (left + 2 == right) { // 2. S[i+1 ~ j-1] 含 1 个 a
                        dp[begin][end] = dp[begin + 1][end - 1] * 2 + 1;
                    } else { // 3. `S[i+1 ~ j-1]` 含 2 个（及以上）a
                        left = curCharIndices.get(left + 1);
                        right = curCharIndices.get(right - 1);
                        dp[begin][end] = dp[begin + 1][end - 1] * 2 - dp[left + 1][right - 1];
                    }
                }

                //  不能这样写 dp[begin][end] = (dp[begin][end] + MOD) % MOD; 可能会 int 溢出。
                dp[begin][end] %= MOD;
                if (dp[begin][end] < 0)
                    dp[begin][end] += MOD;
            }
        }

        return dp[0][N - 1];

    }
}