/*
2017-5-26 00:01:40

Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.

dp算法先算出来dp[i][j]表示s[i - j]是否为回文字符串，状态转移函数为dp[i][j] = dp[i + 1][j - 1] && s[i] == s[j]。
dp只用计算上三角矩阵，根据转移函数应该从下往上算。

再用dp算法计算cut[i]表示s[0-i]最小划分数，状态转移函数为cut[i] = min(cut[i - 1], cut[k] + 1) for 0 <= k < i && dp[k][i] == true.


*/

class Solution {
public:
    int minCut(string s) {

    	vector<vector<string>> res;
        int len  = s.size();


        if (len == 0 || len == 1)
            return 0;


        vector<bool> tmp(len, false);

        std::vector<vector<bool>> dp(len, tmp);

        for (int i = len - 1; i >= 0; -- i)
        {
        	dp[i][i] = true;

            for (int j = i + 1; j < len; ++ j)
            {
            	if (s[i] == s[j])
            	{
            		if (dp[i + 1][j - 1] || (j == i + 1))
            		{
            			dp[i][j] = true;
            		}
            	}
            }
        }

        vector<int> cut(len, 0);

        for (int i = 1; i < len; ++ i)
        {
        	if (dp[0][i])
        	{
        		cut[i] = 0;
        		continue;
        	}

        	cut[i] = cut[i - 1] + 1;

        	for (int j = i - 1; j > 0; -- j)
        	{
        		if (dp[j][i] && (cut[j - 1] + 1 < cut[i]))
        		{
        			cut[i] = cut[j - 1] + 1;
        		}
        	}
        }

        return cut[len - 1];
        
    }
};