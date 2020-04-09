package club.cser.leetcode;

import java.util.HashMap;

//one pass hash 2018-04-28 18:30:35
class TwoSum1 {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> h = new HashMap<>();

        for (int i = 0; i != nums.length; ++ i) {
            if (h.containsKey(target - nums[i])) {
                return new int[]{h.get(target - nums[i]), i};
            } else {
                h.put(nums[i], i);
            }
        }

        throw new IllegalArgumentException("No solution");
    }
}