/*
2016-9-21 16:27:55

https://leetcode.com/problems/single-number/

Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

*/

//using lambda expression and accumulate function;

#include <numeric>

class Solution {
public:
    int singleNumber(vector<int>& nums) {
        	
		return std::accumulate(nums.begin(), nums.end(), 0, [](int res, int i){return res ^ i;} );
		
    }
};