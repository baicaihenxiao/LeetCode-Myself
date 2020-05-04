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

    public int SimplifiedNumDecodings(String s) {
        long e0 = 1, e1 = 0, e2 = 0, f0, f1, f2, M = 1000000007;
        for (char c : s.toCharArray()) { //从最开始迭代
            if (c == '*') { //当前字符为*
                f0 = 9 * e0 + 9 * e1 + 6 * e2; // dp[i + 1] = 9 * dp[i] + (上一个字符为1 ? 9 * dp[i - 1]) + (上一个字符为2 ? 6 * dp[i - 1])
                f1 = e0; //当前字符为*，所以即是1又是2，当前字符为1，则1和后一个字符组成编码时，前面的编码个数为e0
                f2 = e0;
            } else { //当前字符为数字
                f0 = (c > '0' ? 1 : 0) * e0 + e1 + (c <= '6' ? 1 : 0) * e2; //dp[i + 1] = (当前字符不为0 ? 1 : 0) * dp[i] + (上一个字符为1 当前字符为0~9 ? 1 : 0) * dp[i - 1] + (上一个字符为2 当前字符为0~6 ? 1 : 0) * dp[i - 1]
                f1 = (c == '1' ? 1 : 0) * e0; //当前字符为1，则1和后一个字符组成编码时，前面的编码个数为e0。 这里就相当于用f1(e1)记录了该字符为1
                f2 = (c == '2' ? 1 : 0) * e0;
            }
            e0 = f0 % M; //将f0 f1 f2赋值回e0 e1 e2，并做取mod
            e1 = f1;
            e2 = f2;
        }
        return (int)e0; //返回dp[i + 1]
    }
}