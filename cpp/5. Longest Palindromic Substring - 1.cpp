/*
https://leetcode.com/problems/longest-palindromic-substring/#/description


解法： http://blog.csdn.net/hopeztm/article/details/7932245
思路1. 动态规划
这里动态规划的思路是 dp[i][j] 表示的是 从i 到 j 的字串，是否是回文串。

则根据回文的规则我们可以知道：

如果s[i] == s[j] 那么是否是回文决定于 dp[i+1][ j - 1]

当 s[i] != s[j] 的时候， dp[i][j] 直接就是 false。

动态规划的进行是按照字符串的长度从1 到 n推进的。

*/


class Solution {
public:
    string longestPalindrome(string s) {

        int len = s.size();

        if (len == 0 || len == 1)
            return s;

        int maxLengthOfPalindrome = 1;
        int beg = 0;
        int end = 1;

        std::vector<bool> tmp(len, false);
        vector<vector<bool>> dp(len, tmp);

        for (int i = 0; i < len; ++i)
        {
            dp[i][i] = true;

            for (int j = i + 1; j < len; ++j)
            {
                dp[i][j] = false;
            }
        }


        //从对角线往右上角推进
        for (int i = 1; i < len; ++i)
        {
            for (int j = 0; j < len - i; ++j)
            {

                if (s[j] == s[j + i])
                {
                    if (i == 1)
                    {
                        dp[j][j + i] = (s[j] == s[j + i]);
                    }
                    else
                    {
                        dp[j][j + i] = dp[j + 1][j + i - 1] && (s[j] == s[j + i]);
                    }
                }

                

                if (dp[j][j + i] && (i + 1 > maxLengthOfPalindrome))
                {
                    maxLengthOfPalindrome = i + 1;
                    beg = j;
                }
            }

        }

        return s.substr(beg, maxLengthOfPalindrome);

    }
};