package club.cser.leetcode;

import java.util.Arrays;

class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        assert 0 != nums.length;

        int dest = Arrays.stream(nums).sum();

        if ((dest & 1) == 1)
            return false;

        dest = dest >> 1;

        boolean[] dp = new boolean[dest + 1];
        dp[0] = true;

        for (int num : nums) {
            // 只能从大到小，从小到大的话前面计算的会影响后面的
            for (int j = dp.length - 1;  j >= 0; j --) {
                if (dp[j] && j + num < dp.length)
                    dp[j + num] = true;
            }
        }
//        System.out.println(Arrays.toString(dp));
        return dp[dp.length - 1];
    }
}