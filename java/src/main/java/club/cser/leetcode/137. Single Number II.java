package club.cser.leetcode;

class SingleNumberII {
    public int singleNumber1(int[] nums) {
        // 2个bit统计1出现的次数 (secondBit, firstBit)  0,0->0,1->1,0->1,1->0,0 碰到1,1的状态直接变成0,0
        int firstBit = 0, secondBit = 0;
        for (int n: nums) {
            // 0,0->0,1->1,0->1,1
            secondBit = (firstBit & n) ^ secondBit; //
            firstBit = n ^ firstBit;
            // 如果为1,1 则置为0，0
            int tmp = firstBit & secondBit;
            firstBit &= ~tmp;
            secondBit &= ~tmp;
        }
        return firstBit;
    }

    public int singleNumber(int[] nums) {
        int firstBit = 0, secondBit = 0;
        int tmp = 0;
        for (int n: nums) {
            tmp = firstBit;
            firstBit ^= (~secondBit & n);
            secondBit ^= (tmp ^ secondBit) & n;
        }
        return firstBit;
    }


    // 统计1出现的个数，%3即为结果
    public int singleNumber0(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) { // 对每一位统计1的个数
            int cnt = 0;
            for (int n: nums) {
                cnt += (n >>> i) & 1;
            }
            res |= (cnt % 3) << i;
        }
        return res;
    }

}