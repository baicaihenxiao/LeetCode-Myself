package club.cser.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class DecodeWaysII {
    public int numDecodings(String s) {

        final long mod = 1000000007;

        if (s.charAt(0) == '0')
            return 0;

        long[] dp = new long[s.length() + 1]; //要用long，因为3*1000000006%1000000007计算的结果不是1000000004
        Arrays.fill(dp, 0);

        dp[0] = 1;
        dp[1] = s.charAt(0) == '*' ? 9 : 1;

        for (int i = 1; i < s.length(); ++ i) {

            if (s.charAt(i) != '0') {
                dp[i + 1] += (s.charAt(i) == '*' ? 9 : 1) * dp[i] ;
            }

            if (s.charAt(i - 1) == '*') { //十位为*
                //判断个位
                //15: ** 11~19 21~26
                // 1: *789 17 不能是07，因为07不是一种编码 *也不能表示0
                //2: *0123456 16 26
                dp[i + 1] += (s.charAt(i) == '*' ? 15 : (s.charAt(i) > '6' ? 1 : 2)) * dp[i - 1];
            } else {//十位不为*
                //个位为* 1* 2* *只能表示1-9
                if (s.charAt(i) == '*') {
                    if (s.charAt(i - 1) == '1') //11 12 ... 19
                        dp[i + 1] += 9 * dp[i - 1];
                    if (s.charAt(i - 1) == '2') //21 22 ... 26
                        dp[i + 1] += 6 * dp[i - 1];
                } else {
                    //个位不为*
                    int twoDigit = (s.charAt(i -1) - '0') * 10 + s.charAt(i) - '0';
                    if (twoDigit >= 10 && twoDigit <=26)
                        dp[i + 1] += dp[i - 1];
                }
            }
            dp[i + 1] %= mod;
        }

        return (int)dp[s.length()];

    }
}