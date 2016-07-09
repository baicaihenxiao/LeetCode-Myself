/*
2016-7-10 00:52:17

https://leetcode.com/problems/search-in-rotated-sorted-array-ii/

 81. Search in Rotated Sorted Array II  QuestionEditorial Solution  My Submissions
Total Accepted: 66782
Total Submissions: 207396
Difficulty: Medium
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array. 
*/



class Solution {
public:
    int search(vector<int>& nums, int target) {
        int begin = 0, end = nums.size();//range [begin, end);
		int mid;
		while (begin != end)
		{
			mid = (begin + end) / 2;// [begin, mid), mid, [mid + 1, end);
			
			/* 不能这样判断，因为target>mid时，有可能在左边也有可能在右边;
			if (target == nums[mid])
			{
				return mid;
			}
			else if (target > nums[mid])
			{
				if (nums[mid] <= nums[end - 1])
					begin = mid + 1;
				else 
			}
			else if (target < nums[mid])
			{
				end = mid;
			} */
			if (target == nums[mid])
			{
				return true;
			}
			
			if (nums[begin] < nums[mid])//[begin, mid] is ordered;
			{
				//ensure begin < target < mid, only target < mid is not ture;
				if (target < nums[mid] && target >= nums[begin])//so we can ensure target is in the [begin, mid) if target < mid;
				{
					end = mid;
				}
				else//because this range is disordered, we can focus on the range with the else condition;
				{
					begin = mid + 1;
				}
			}
			else if (nums[begin] > nums[mid])//[mid, end) is ordered;
			{
				if (target > nums[mid] && target <= nums[end - 1])
				{
					begin = mid + 1;
				}
				else
				{
					end = mid;
				}
			}
			else
			    ++ begin;
			
			
			
		}
		
		return false;
    }
};
