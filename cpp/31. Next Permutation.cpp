/*
2016-8-31 00:15:03

https://leetcode.com/problems/next-permutation/

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 ¡ú 1,3,2
3,2,1 ¡ú 1,2,3
1,1,5 ¡ú 1,5,1

*/


class Solution {
public:
    void nextPermutation(vector<int>& nums) {
		
        auto rev = nums.end() - 1;//rev is the index next nums[rev - 1] < nums[rev] > nums[rev+1] >...>nums[end-1]
		
		while (rev > nums.begin())
		{
			if (*rev > *(rev - 1))
			{
				break;
			}
			
			-- rev;
		}
		
		if (rev == nums.begin())
		{
			reverse(rev, nums.end());
			return;
		}
		
		auto largerRev = rev;
		
		for (; largerRev < nums.end(); ++ largerRev)
		{
			if (*(rev - 1) >= *largerRev)
			{
				break;
			}
		}
		
		int tmp = *(largerRev - 1);
		*(largerRev - 1) = *(rev - 1);
		*(rev - 1) = tmp;
		
		reverse(rev, nums.end());
		
		return;
		
		
    }
};