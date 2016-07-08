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

class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        
		if (nums.empty())
			return 0;
		int res = 0;
		bool dup = false;
		
		for (int i = 1; i < nums.size(); ++ i)
		{
			if (nums[i] != nums[res])
			{
				++ res;
				nums[res] = nums[i];
				dup = false;
			}
			else
			{
				if (!dup)//the first dup. when dup equals false, it means the first duplication happens, so just copy and move the res;
				{
					++ res;
					nums[res] = nums[i];
				}
				
				dup = true;
			}
			
		}
		
		return res + 1;
		
    }
};