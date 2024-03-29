package club.cser.leetcode;

class ReverseBits {

    public int reverseBits(int n) {

        int res = 0;

        for (int i = 0; i < 32; ++ i) {
            res = (res << 1) + ((n & 1) == 1 ? 1 : 0);
            n = n >>> 1;
        }

        return res;
    }

}
