//brute force 2018-04-28 17:48:57
class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[] res = {0, 1};
        for (int i = 0; i != nums.length; ++ i) {
            for (int j = i + 1; j < nums.length; ++ j) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }
}