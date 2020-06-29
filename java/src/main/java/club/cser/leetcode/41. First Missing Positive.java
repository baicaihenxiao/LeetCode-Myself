package club.cser.leetcode;

class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int N = nums.length;

        for (int i = 0; i < N; ++ i) {
            if (nums[i] > N || nums[i] <= 0) { // 过大或过小
                nums[i] = 0;
                continue;
            }
            if (nums[i] == i + 1) { // 位置已经存储了正确的值
                continue;
            }

            if (nums[nums[i] - 1] == nums[i]) { // 要换的地方的值和此时的值相等，防止有重复数字出现
                nums[i] = 0;
                continue;
            }

            int tmp = nums[nums[i] - 1];
            nums[nums[i] - 1] = nums[i];
            nums[i] = tmp;
            -- i;
        }

        for (int i = 0; i < N; ++ i) {
            if (nums[i] == 0)
                return i + 1;
        }

        return N + 1;
    }

    public int firstMissingPositive1(int[] nums) {
        int N = nums.length;

        for (int i = 0; i < N; ++ i) {
            if (nums[i] > N || nums[i] <= 0 || nums[i] == i + 1 || nums[nums[i] - 1] == nums[i]) {
                continue;
            }

            int tmp = nums[nums[i] - 1];
            nums[nums[i] - 1] = nums[i];
            nums[i] = tmp;
            -- i;
        }

        for (int i = 0; i < N; ++ i) {
            if (nums[i] != i + 1)
                return i + 1;
        }

        return N + 1;
    }
}