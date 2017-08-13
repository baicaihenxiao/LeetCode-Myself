/*
2017-5-25 20:53:41

https://leetcode.com/problems/interleaving-string/description/


Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.

dp[i][j]表示s1[0-(i-1)]和s2[0-(j-1)]能否构成s3[0-(i + j -1)]，这需要判断两部分:
dp[i-1][j]&&s1[i-1]==s3[0-(i + j -1)]
和
dp[i][j-1]&&(s2[j-1]==s3[0-(i + j -1)]
即s3的最后一个字符到底是由s1还是s2提供。

1.dp[0][4]=true表示s1不给出字符，s2给出s2[0-3](前四个字符的意思),即可配对s3[0-3]。
如果dp[0][4]=true表示的是s1给出字符s[0]，s2给出s2[0-4](下标到4的意思),即可配对s3[0-5]，则无法计算s1为空的情况，即使s1不为空，算dp[0][]这一排的时候也写的麻烦。
2.注意边界的处理，dp[0][0]应该恒为true。
*/

class Solution {
public:
	bool isInterleave(string s1, string s2, string s3) {

		if (s1.size() + s2.size() != s3.size())
			return false;

		if (s3.empty())
			return true;

		int row = s1.size();
		int col = s2.size();

		vector<bool> tmpVec(col + 1, false);
		vector<vector<bool>> dp(row + 1, tmpVec);

		for (int i = 0; i <= row; ++i)
		{

			for (int j = 0; j <= col; ++j)
			{
				if (i == j && j == 0)
				{
					dp[i][j] = true;
					continue;
				}

				bool tmp1 = false;
				bool tmp2 = false;
				if (i != 0)
				{
					cout << (dp[i - 1][j]) << (s1[i - 1] == s3[i + j - 1]) << endl;
					tmp1 = (dp[i - 1][j]) && (s1[i - 1] == s3[i + j - 1]);
				}

				if (j != 0)
				{
					tmp2 = dp[i][j - 1] && (s2[j - 1] == s3[i + j - 1]);
				}
				dp[i][j] = tmp1 || tmp2;
			}
		}

		return dp[row][col];

	}
};