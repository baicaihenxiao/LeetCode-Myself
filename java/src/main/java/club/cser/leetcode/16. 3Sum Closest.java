package club.cser.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        //  You may assume that each input would have exactly one solution.
        int resGap =  nums[0] + nums[1] + nums[2] - target;

        for (int i = 0; i < nums.length - 2; ++ i) {
            int left = i + 1;
            int right = nums.length - 1;

            // 重复数字 跳过
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            while (left < right) {

                int tmpGap = nums[i] + nums[left] + nums[right] - target;

                if (Math.abs(resGap) > Math.abs(tmpGap))
                    resGap = tmpGap;

                if (tmpGap < 0) {
                    ++ left;
                } else if (tmpGap > 0) {
                    -- right;
                } else {
                    return target;
                }
            }
        }

        return resGap + target;
    }
}