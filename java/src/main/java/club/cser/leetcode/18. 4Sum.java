package club.cser.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; ++ i) {

            // 重复数字 跳过
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            if (nums[i] * 4 > target)
                break;

            for (int j = i + 1; j <  nums.length - 2; ++ j) {

                // 重复数字 跳过
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                int tmpTarget = target - nums[i] - nums[j];

                if (nums[j] * 2 > tmpTarget)
                    break;


                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    if (nums[left] + nums[right] == tmpTarget) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        ++ left;
                        -- right;

                        while (left < right && nums[left - 1] == nums[left]) {
                            ++ left;
                        }

                        while (left < right && nums[right + 1] == nums[right]) {
                            -- right;
                        }
                    } else if (nums[left] + nums[right] > tmpTarget) {
                        -- right;
                    } else {
                        ++ left;
                    }
                }
            }

        }

        return res;
    }

}
