/*
2016-9-21 16:27:55

https://leetcode.com/problems/single-number/

Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

*/

class Solution {
public:
    int singleNumber(vector<int>& nums) {
        
		int res = 0;
		
		for (auto iter = nums.begin(); iter != nums.end(); ++ iter)
		{
			res ^= *iter;
		}
		
		return res;
    }
};