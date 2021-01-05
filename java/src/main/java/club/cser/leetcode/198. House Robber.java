package club.cser.leetcode;

class HouseRobber {
    public int rob(int[] nums) {
        int last = 0;
        int secondToLast = 0;
        int cur = 0;

        for (int n: nums) {
            cur = Math.max(n + secondToLast, last);
            secondToLast = last;
            last = cur;

//            System.out.println(cur);
        }

        return cur;
    }
}