package club.cser.leetcode;

class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int tmp = nums[0];
        // 第一个不抢
        nums[0] = 0;
        int res = robLine(nums);
        // 抢第一个，则第二个和倒数第一个不能抢
        nums[0] = tmp;
        nums[1] = 0;
        nums[nums.length - 1] = 0;
        // 比较两种情况谁大
        return Math.max(res, robLine(nums));

    }

    // copy from leetcode 198
    public int robLine(int[] nums) {
        int last = 0;
        int secondToLast = 0;
        int cur = 0;

        for (int n: nums) {
            cur = Math.max(n + secondToLast, last);
            secondToLast = last;
            last = cur;
        }

        return cur;
    }
}