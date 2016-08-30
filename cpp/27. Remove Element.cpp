/*
2016-8-30 14:47:40

https://leetcode.com/problems/remove-element/

Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.
*/

class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        auto i = nums.begin();
		auto j = i;
		
		for (; i < nums.end(); ++ i)
		{
			if (*i != val)
			{
				*j = *i;
				++ j;
			}
		}
		
		return (j - nums.begin());
    }
};
