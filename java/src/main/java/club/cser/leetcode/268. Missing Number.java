package club.cser.leetcode;

class MissingNumber {
    public int missingNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; ++ i) {
            res = res ^ i ^ nums[i];
        }
        return res ^ nums.length;
    }

    public int missingNumber1(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; ++ i) {
            res = res + i - nums[i];
        }
        return res;
    }
}

