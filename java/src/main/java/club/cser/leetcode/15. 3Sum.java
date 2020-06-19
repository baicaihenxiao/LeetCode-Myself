package club.cser.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; ++ i) {
            int left = i + 1;
            int right = nums.length - 1;

            // 重复数字 跳过
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            // 为正数的话 后面2个更大的数再加的话 肯定比0大
            if (nums[i] > 0)
                break;

            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    ++ left;
                    -- right;

                    while (left < right && nums[left - 1] == nums[left]) {
                        ++ left;
                    }

                    while (left < right && nums[right + 1] == nums[right]) {
                        -- right;
                    }
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    -- right;
                } else {
                    ++ left;
                }
            }
        }

        return res;
    }
}