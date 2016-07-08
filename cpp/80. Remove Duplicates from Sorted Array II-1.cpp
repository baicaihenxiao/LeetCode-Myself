/*
2016年7月8日17:18:28

80. Remove Duplicates from Sorted Array II  QuestionEditorial Solution  My Submissions
Total Accepted: 80155
Total Submissions: 240390
Difficulty: Medium
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.


*/

//notice that the array has been sorted.

class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        
		if (nums.size() <= 2)
			return nums.size();
		int res = 1;
		
		for (int i = 2; i < nums.size(); ++ i)
		{
			if (nums[i] != nums[res - 1])
			{
				++ res;
				nums[res] = nums[i];
			}
			
		}
		
		return res + 1;
		
    }
};