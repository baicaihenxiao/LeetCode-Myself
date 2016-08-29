/*
2016-8-30 01:25:13

https://leetcode.com/problems/4sum/

Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note: The solution set must not contain duplicate quadruplets.

For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]

*/

#include <iostream>
#include <algrithm>
using namespace std;

class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
		
		vector<vector<int>> res;
		
		if (nums.size() < 4)
			return res;
		
		for (auto i = nums.begin(); i < nums.end() - 3; ++ i)
		{
			if (i != nums.begin() && *i == *(i - 1))
			{
				continue;
			}
			for (auto j = i + 1; j < nums.end() - 2; ++ j)
			{
				if (j != i + 1 && *j == *(j - 1))
				{
					continue;
				}
				
				auto m = j + 1;
				auto n = nums.end() - 1;
				
				while (m < n)
				{
					int sum = *i + *j + *m + *n;
					
					if (sum == target)
					{
						res.push_back({*i, *j, *m, *n});
						++ m;
						-- n;
						while (*m == *(m - 1) && m < n)
							++ m;
						while (*n == *(n + 1) && m < n)
							-- n;
					}
					else if (sum < target)
					{
						++ m;
					}
					else if (sum > target)
					{
						-- n;
					}
				}
			}
		}
		
		return res;
    }
};