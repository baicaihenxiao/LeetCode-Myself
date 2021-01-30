package club.cser.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class StoneGameVII {
    public int stoneGameVII(int[] stones) {
        final int N = stones.length;
        List<int[][]> dp = new ArrayList<>(2);
        dp.add(Stream.generate(() -> new int[N]).limit(N).toArray(int[][]::new));
        dp.add(Stream.generate(() -> new int[N]).limit(N).toArray(int[][]::new));
        int cur = 0, before = 1;

        for (int i = 0; i < N; i++) {
            dp.get(cur)[i][i] = stones[i];
        }

        for (int len = 2; len <= N; len++) {
            cur = 1 - cur;
            before = 1 - before;
            for (int i = 0; i <= N - len; i++) {
                if (dp.get(before)[i][i + len - 2] > dp.get(before)[i + 1][i + len - 1]) {
                    dp.get(cur)[i][i + len - 1] = dp.get(cur)[i][i + len - 2] + stones[i + len - 1];
                    dp.get(before)[i][i + len - 1] = dp.get(before)[i][i + len - 2];
                } else {
                    dp.get(cur)[i][i + len - 1] = dp.get(cur)[i + 1][i + len - 1] + stones[i];
                    dp.get(before)[i][i + len - 1] = dp.get(before)[i + 1][i + len - 1];

                }

            }
        }
//        Arrays.stream(dp.get(0)).map(Arrays::toString).forEach(System.out::println);
//        Arrays.stream(dp.get(1)).map(Arrays::toString).forEach(System.out::println);
        return dp.get(before)[0][N - 1];

    }

    public int stoneGameVII1(int[] stones) {
        final int N = stones.length;
        int[][] dp = Stream.generate(() -> new int[N]).limit(N).toArray(int[][]::new);
        int[] pre = new int[N + 1];

        for (int i = N - 1; i >= 0; i --) {
            pre[i] += stones[i] + pre[i + 1];
        }

        for (int len = 2; len <= N; len++) {
            for (int i = 0; i <= N - len; i++) {
                int left = i, right = i + len - 1;
                dp[left][right] = Math.max(pre[left] - pre[right] - dp[left][right - 1], pre[left + 1] - pre[right + 1] - dp[left + 1][right]);
            }
        }
        return dp[0][N - 1];

    }
}
