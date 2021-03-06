/*
2016年7月8日14:13:07

26. Remove Duplicates from Sorted Array  QuestionEditorial Solution  My Submissions
Total Accepted: 140809
Total Submissions: 413770
Difficulty: Easy
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.

Subscribe to see which companies asked this question
*/

class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.size() == 0)
			return 0;
		
		int length = 0;
		int point = 1;
		
		while (point != nums.size())
		{
			if (nums[point] != nums[length])
			{
				++ length;
				nums[length] = nums[point];
			}
			
			++ point;
		}
		
		return length + 1;
    }
};
