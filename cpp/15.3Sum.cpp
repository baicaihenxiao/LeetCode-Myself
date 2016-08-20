/*
2016-8-20 17:10:32

https://leetcode.com/problems/3sum/

Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

*/

#include <iostream>
#include <algrithm>
using namespace std;

class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> res;
		
		if (nums.size() < 3)
		{
			return res;
		}
		
		sort(nums.begin(), nums.end());
		
		for (auto iter = nums.begin(); iter != nums.end() - 2 && *iter <= 0; ++ iter)
		{
			if (iter != nums.begin() && *iter == *(iter - 1))//防止出现相同的tuple；
				continue;
			
			auto left = iter + 1;
			auto right = nums.end() -1;
			
			while (right > left)
			{
				
				if (*iter + *left + *right == 0)
				{
					res.push_back({*iter, *left, *right});
					++ left;
					-- right;
					while (*left == *(left -1) && left < right)//防止出现相同的tuple；
						++ left;
					while (*right == *(right + 1) && left < right)
						-- right;
				}
				else if (*iter + *left + *right < 0)
				{
					++ left;
				}
				else
				{
					-- right;
				}
			}
			
		}
		
		return res;
    }
};