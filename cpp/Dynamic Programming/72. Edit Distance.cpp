/*


2017-8-16 15:44:21

https://leetcode.com/problems/edit-distance/description/


Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character


dp算法，如果s1[m] == s2[n]，则dp[m][n] = dp[m-1][n-1];
如果s1[m] != s2[n]:
1.替换s1[m]使s1[m]' == s2[n]，则dp[m][n] = dp[m-1][n-1] + 1;
2.在s1[m]之后加s1[m+1]使s1[m+1] == s2[n]。 则dp[m][n] = dp[m][n-1] + 1;
3.在s2[n]之后加s2[n+1]使s1[m] == s2[n + 1]。 则dp[m][n] = dp[m - 1][n] + 1;
取三者最小。



*/


class Solution {
public:
    int minDistance(string word1, string word2) {
        int m = word1.size();
        int n = word2.size();

        if (m == 0 || n == 0)
        {
        	return m == 0 ? n : m;
        }

        vector<int> dp(n + 1, 0);

        for (int i = 0; i < n + 1; ++ i)
        {
        	dp[i] = i;
        }


        for (int i = 1; i <= m; ++ i)
        {
        	int tmpLeft = dp[0];
        	dp[0] = i;

        	int tmpCur = 0;


        	for (int j = 1; j <= n; ++ j)
        	{
        		tmpCur = dp[j];

        		if (word1[i - 1]  == word2[j - 1])
        		{
        			dp[j] = tmpLeft;
        		}
        		else
        		{
        			dp[j] = min(tmpLeft, dp[j]);
        			dp[j] = min(dp[j - 1], dp[j]);
        			++ dp[j];
        		}
        		tmpLeft  = tmpCur;

        	}

        }

        return dp[n];
    }
};