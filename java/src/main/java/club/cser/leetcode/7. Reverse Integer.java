package club.cser.leetcode;

// 2018-07-01 03:00:42
// https://leetcode.com/problems/reverse-integer/description/

import org.junit.Test;

class ReverseInteger {
    public int reverse(int x) {
        if (x == 0)
            return 0;
        boolean isNegative = (x < 0);
        x = isNegative ? -x : x;
        String xStr = Integer.toString(x);
        String maxStr = "2147483647";
        xStr = new StringBuilder(xStr).reverse().toString();

        if (isNegative && "2147483648".equals(xStr))
            return Integer.MIN_VALUE;

        if (xStr.length() >= maxStr.length() && xStr.compareTo(maxStr) > 0)
            return 0;
        else
            return Integer.parseInt(xStr) * (isNegative ? -1 : 1);
    }

}