package club.cser.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

class TargetSum {
    // 转换成子集和问题
    public int findTargetSumWays1(int[] nums, int S) {
        int target = Arrays.stream(nums).sum();

        if (target < S || (target + S) % 2 == 1)
            return 0;

        target = (target + S) / 2;

        int[] dp = new int[target + 1];
        dp[0] = 1; // 这个很关键
        for (int num: nums) {
            for (int i = target; i >= num ; i --) {
                dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }

    // 正常dp，所有元素都要取
    public int findTargetSumWays(int[] nums, int S) {
        int target = Arrays.stream(nums).sum();

        if (target < S)
            return 0;

        int[][] dp = new int[2][];
        dp[0] = new int[2001];
        dp[1] = new int[2001];

        int curRow = 0;
        int nextRow = 1;
        dp[curRow][1000] = 1;

        for (int num: nums) {
            Arrays.fill(dp[nextRow], 0);
            // 因为题目规定所有值相加<=1000，所以只要进循环就不会有i > 2000 - num 时 dp[curRow][i] > 0 的情况。
            for (int i = 2000 - num; i >= num ; i --) {
                if (dp[curRow][i] != 0) {
                    dp[nextRow][i + num] += dp[curRow][i];
                    dp[nextRow][i - num] += dp[curRow][i];
                }
            }

            curRow ^= 1;
            nextRow ^= 1;
        }
//        final int sss = curRow;
//        IntStream.range(0, dp[sss].length).mapToObj(i -> String.format("%d-%d, ", i - 1000, dp[sss][i])).forEach(System.out::print);
        return dp[curRow][S + 1000];

    }
}