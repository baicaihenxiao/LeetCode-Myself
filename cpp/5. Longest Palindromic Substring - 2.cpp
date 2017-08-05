/*
https://leetcode.com/problems/longest-palindromic-substring/#/description


解法： http://blog.csdn.net/hopeztm/article/details/7932245
第二个思路来源于字符串匹配，最长回文串有如下性质：　

对于串S, 假设它的 Reverse是 S', 那么S的最长回文串是 S 和 S' 的最长公共字串。

例如 S = abcddca,  S' = acddcba， S和S'的最长公共字串是 cddc 也是S的最长回文字串。

如果S‘是 模式串，我们可以对S’的所有后缀枚举(S0, S1, S2, Sn) 然后用每个后缀和S匹配，寻找最长的匹配前缀。

例如当前枚举是 S0 = acddcba 最长匹配前缀是 a

S1  = cddcba 最长匹配前缀是 cddc

S2 = ddcba 最长匹配前缀是 ddc

当然这个过程可以做适当剪枝，如果当前枚举的后缀长度，小于当前找到的最长匹配，则直接跳过。


这个思路是错的，比如"abcdasdfghjkldcba"，这样每次更新最大长度之后需要判断是否为回文字符串。

*/
class Solution {
public:
    vector<int> computePrefixFunction(string& s)
    {
        vector<int> res(s.size(), 0);
        res[0] = -1;
        int k = -1;//表示pattern里已经匹配了s[0~k]
        for (int i = 1; i < s.size(); ++ i)
        {
            while (k >= 0 && s[i] != s[k + 1])
            {
                k = res[k];
            }
            if (s[i] == s[k + 1])
            {
                ++ k;
            }
            res[i] = k;
        }
        return res;
    }
    int computeMaxPalindrome(string& text, string& pattern)
    {
        vector<int> prefix = computePrefixFunction(pattern);
        int k = -1;
        int max = -1;
        for (int i = 0; i < text.size(); ++ i)
        {
            while (k >= 0 && text[i] != pattern[k + 1])
            {
                k = prefix[k];
            }
            if (text[i] == pattern[k + 1])
            {
                ++ k;
                if (k > max)
                    max = k;
            }
            if (k + 1 == pattern.size())
            {
                return k + 1;
            }
        }
        return max + 1;
    }

    string longestPalindrome(string s) {

        int len = s.size();

        if (len == 0 || len == 1)
            return s;

        int maxLengthOfPalindrome = 1;
        int beg = 0;
        int end = 1;

        string reverseS(s);
        reverse(reverseS.begin(), reverseS.end());

        int maxLen = 1;
        string maxPalindrome(s.begin(), s.begin() + 1);


        for (int i = 0; i < reverseS.size(); ++ i)
        {

            if (i + maxLen >= reverseS.size())
                break;

            string pattern = reverseS.substr(i, reverseS.size() - i);

            int tmpMaxLen = computeMaxPalindrome(s, pattern);

            if (tmpMaxLen > maxLen)
            {
                maxLen = tmpMaxLen;
                maxPalindrome = pattern.substr(0, maxLen);
            }

        }

        return maxPalindrome;

    }
};