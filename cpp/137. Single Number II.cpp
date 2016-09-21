/*
2016-9-21 17:05:46

https://leetcode.com/problems/single-number-ii/

Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

*/

#include <bitset>

class Solution {
public:
    int singleNumber(vector<int>& nums) {
        bitset<sizeof(int) * 8> tmp;
		
		vector<int> res(sizeof(int) * 8, 0);
		
		for (auto i: nums)
		{
			tmp = i;
			for (int j = 0; j < res.size(); ++ j)
			{
				res[j] += tmp[j];
			}
		}
		
		int res1 = 0;
		
		for (int i = 0; i < res.size(); ++ i)
		{
			res1 ^= (res[i] % 3) << i;
		}
		
		return res1;
		 
    }
};