package club.cser.leetcode;

class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int n: nums)
            diff ^= n;
        diff &= -diff; // 取出从右往左第一个为1的位。

        int[] res = new int[2];
        for (int n: nums) {
            if ((n & diff) == 0)
                res[0] ^= n;
            else
                res[1] ^= n;
        }
        return res;
    }
}