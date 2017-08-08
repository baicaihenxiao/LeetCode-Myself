/*
https://leetcode.com/problems/longest-palindromic-substring/#/description


解法： http://blog.csdn.net/hopeztm/article/details/7932245

Manacher's Algorithm

*/
class Solution {
public:
    string longestPalindrome(string s) {

        int len = s.size();

        if (len == 0 || len == 1)
            return s;


        //preprocess
        string T(2 * len + 3, '*');
        T[0] = '^';
        for (int i = 0; i < len; ++i)
        {
            T[2 * i + 2] = s[i];
        }
        T[2 * len + 1] = '*';
        T[2 * len + 2] = '$';


        vector<int> P(2 * len + 3, 0);


        int C = 0;

        int R = 0;


        for (int i = 1; i < 2 * len + 2; ++i)
        {
            //如果P没有初始化为0, 则在这里i>=R时 else{p[i] = 0;}
            if (i < R)
            {
                P[i] = min(P[C - (i - C)], R - i);
            }

            while (T[i + P[i] + 1] == T[i - P[i] - 1])
            {
                ++P[i];
            }

            if (i + P[i] > R)
            {
                C = i;
                R = i + P[i];
            }

        }

        int maxLen = 1;
        int beg = 0;


        for (int i = 0; i < T.size(); ++i)
        {
            if (P[i] > maxLen)
            {
                maxLen = P[i];
                beg = (i - maxLen + 1 - 2) / 2;//通过i和maxLen找到T中起始坐标为i - maxLen + 1，将该坐标转换到s中的坐标为（x-2)/2.
            }
        }


        return s.substr(beg, maxLen);

    }



};