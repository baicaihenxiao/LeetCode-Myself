package club.cser.leetcode;

import club.cser.commons.Converter;

import java.util.Arrays;

class NonegativeIntegerswithoutConsecutiveOnes {

    public int findIntegers(int num) {
        int res = 0;
        final int BIT_SIZE = 31;
        // 第i + 1位为0的满足条件的个数
        int[] zeroLeading = new int[BIT_SIZE];
        // 第i + 1位为1的满足条件的个数
        int[] oneLeading = new int[BIT_SIZE];

        // i = 0, 即第1位为0，0满足
        zeroLeading[0] = 1;
        // i = 0, 即第1位为1，1满足
        oneLeading[0] = 1;

        for (int i = 1; i < BIT_SIZE; i++) {
            // 该位为0，那么前一位为0和1都可以。
            zeroLeading[i] = zeroLeading[i - 1] + oneLeading[i - 1];
            // 该位为1，前一位只能为0
            oneLeading[i] = zeroLeading[i - 1];
        }

        System.out.println(Arrays.toString(zeroLeading));
        System.out.println(Arrays.toString(oneLeading));

        // 转换成2进制
        String numStr = Integer.toBinaryString(num);
//        System.out.println(numStr);

        boolean preBitIsOne = false;
        // 从2进制最高位开始
        for (int i = 0; i < numStr.length(); i++) {

            if (numStr.charAt(i) == '1') {
                res += zeroLeading[numStr.length() - i - 1];

                if (preBitIsOne)
                    return res;

                preBitIsOne = true;
            } else {
                preBitIsOne = false;
            }
        }
        // 字符串本身满足情况，所以加1
        return res + 1;
    }
}