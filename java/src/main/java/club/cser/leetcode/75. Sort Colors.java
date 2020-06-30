package club.cser.leetcode;

class SortColors {
    public void sortColors(int[] nums) {
//        unstableCountingSort(nums);
//        stableCountingSort(nums);
        onePass(nums);
    }

    private void unstableCountingSort(int[] nums) {
        int[] counts = new int[3];

        for (int c: nums)
            ++ counts[c];

        int cur = 0;

        for (int i = 0; i < counts.length; ++ i) {
            for (int j = 0; j < counts[i]; ++ j)
                nums[cur ++] = i;
        }
    }

    private void stableCountingSort(int[] nums) {
        int[] counts = new int[3];
        int[] res = new int[nums.length];

        for (int c: nums)
            ++ counts[c];

        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }

        for (int i = nums.length - 1; i >= 0 ; -- i) {
            res[counts[nums[i]] - 1] = nums[i];
            -- counts[nums[i]];
        }
        System.arraycopy(res, 0, nums, 0, nums.length);
    }

    private void onePass(int[] nums) {
        int left = 0, right = nums.length - 1;

        for (int i = 0; i <= right;) {
            if (nums[i] == 0) {
                swap(nums, i ++, left ++);
            } else if (nums[i] == 2) {
                swap(nums, i, right --);
            } else {
                ++ i;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}