//https://leetcode.com/problems/divide-two-integers/

package club.cser.leetcode;

import java.util.ArrayList;
import java.util.List;

// divide two integers without using multiplication, division and mod operator.
// Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range
// 只能使用int，不能使用 乘除模
class DivideTwoIntegers {

    //用除法，很简单
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        return dividend / divisor;
    }

    public int divide1(int dividend, int divisor) {
        assert divisor != 0;

        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        boolean isPositive = (dividend > 0) == (divisor > 0);

        //都转成负数，本来是要abs都转成正数的，但是Integer.MIN_VALUE转正会越界
        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;

        List<Integer> mulList = new ArrayList<>();
        int res = 0;
        int mulTest = 0;

        for(int i = divisor; i < 0 && i >= dividend; i = i + i) {
            mulList.add(i);
        }

        for (int i = mulList.size() - 1; i >= 0; -- i) {
            int tmp = mulTest + mulList.get(i);
            if (tmp < 0 && tmp >= dividend) {
                mulTest += mulList.get(i);
                res += 1 << i;
            }
//            System.out.println(res);
        }
//        System.out.println(mulList);

        return isPositive ? res : -res;
    }
}