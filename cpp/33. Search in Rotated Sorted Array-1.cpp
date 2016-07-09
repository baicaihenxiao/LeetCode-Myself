/*
2016-7-8 21:43:26

https://leetcode.com/problems/search-in-rotated-sorted-array/

33. Search in Rotated Sorted Array  QuestionEditorial Solution  My Submissions
Total Accepted: 108765
Total Submissions: 354448
Difficulty: Hard
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.


*/

//binary search

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
				return mid;
			}
			
			if (nums[begin] <= nums[mid])//[begin, mid] is ordered;
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
			else//[mid, end) is ordered;
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
			
			
			
		}
		
		return -1;
    }
};
