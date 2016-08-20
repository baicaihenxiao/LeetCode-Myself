/*
2016-8-20 11:14:04

https://leetcode.com/problems/two-sum/

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
UPDATE (2016/2/13):
The return format had been changed to zero-based indices. Please read the above updated description carefully.

*/


class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        std::unordered_map<int, int> mymap;
		vector<int> res;
		for (int i = 0; i < nums.size(); ++ i)
		{
			mymap[nums[i]] = i;
		}
		
		for (int i = 0; i < nums.size(); ++ i)
		{
			int gap = target - nums[i];
			auto iter = mymap.find(gap);
			if (iter != mymap.end() && iter->second != i)
			{
				res.push_back(i);
				res.push_back(iter->second);
				break;
			}
		}
		
		return res;
    }
};