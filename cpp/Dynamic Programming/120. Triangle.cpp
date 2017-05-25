/*
2017-5-25 20:53:41

https://leetcode.com/problems/triangle/#/description

Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

*/

#include <algorithm>

class Solution {
public:
	int minimumTotal(vector<vector<int>>& triangle) {

		if (triangle.size() == 0)
		{
			return 0;
		}

		if (triangle.size() == 1)
		{
			return triangle[0][0];
		}

		//int *dp = new int[triangle.size()];
		vector<int> dp(triangle.size());

		dp[0] = triangle[0][0];

		for (int i = 1; i < triangle.size(); ++i)
		{

			dp[triangle[i].size() - 1] = dp[triangle[i].size() - 2] + triangle[i][triangle[i].size() - 1];

			//cout << dp[triangle[i].size() - 1] << " ";
			for (int j = triangle[i].size() - 2; j > 0; --j)
			{
				if (dp[j] > dp[j - 1])
					dp[j] = dp[j - 1];
				dp[j] += triangle[i][j];

				//cout << dp[j] << " ";
			}

			dp[0] += triangle[i][0];

			//cout << dp[0] << endl;

		}
		

		int res = *min_element(dp.begin(), dp.end());
		//delete[] dp;
		return  res;

	}
};