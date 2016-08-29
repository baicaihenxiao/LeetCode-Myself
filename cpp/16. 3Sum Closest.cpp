/*
2016-8-30 00:01:06

https://leetcode.com/problems/3sum-closest/

Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

*/

#include <iostream>
#include <algrithm>
#include <limits>
#include <math>
using namespace std;

class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        
		sort(nums.begin(), nums.end());
		int minGap = numeric_limits<int>::max();
		int res = 0;
		
		for (auto i = nums.begin(); i < nums.end() - 2; ++ i)
		{
			auto beg = i + 1;
			auto end = nums.end() - 1;
			
			while (beg < end)
			{
				int sum = *i + *beg + *end;
				int gap = abs(target - sum);
				
				if (gap < minGap)
				{
					minGap = gap;
					res = sum;
				}
				
				if (sum < target)
				{
					++ beg;
				}
				else
				{
					-- end;
				}
			}
			
		}
		
		return res;
    }
};