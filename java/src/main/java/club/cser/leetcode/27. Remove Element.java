package club.cser.leetcode;



class RemoveElement {
    // 从左边找到等于val的， 从右边找到不等于val的，交换即可。
    public int removeElement(int[] nums, int val) {

        int i = 0, j = nums.length - 1;
        int res = nums.length;

        while (i <= j) {
            while (i <= j && nums[i] != val) {
                ++ i;
            }

            while (i <= j && nums[j] == val) {
                -- j;
                --res;
            }

            if (i <= j) {
                nums[i] = nums[j];
                ++ i;
                -- j;
                -- res;
            }
        }

        return res;
    }
}