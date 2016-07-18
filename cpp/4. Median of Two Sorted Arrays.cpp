/*
2016-7-18 23:36:14

https://leetcode.com/problems/median-of-two-sorted-arrays/

4. Median of Two Sorted Arrays  QuestionEditorial Solution  My Submissions
Total Accepted: 103263
Total Submissions: 535884
Difficulty: Hard
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5

*/

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
		
		if (num1.size() > nums2.size())
		{
			findMedianSortedArrays(nums2, nums1);
		}
		
		int beg1 = 0, beg2 = 0;
		int end1 = nums1.size();
		int end2 = nums2.size();
		int pos = 0;
		if ((end1 + end2) & 0x1)//(end1 + end2) is odd
		{
			pos = (end1 + end2) / 2 + 1;
		}
		else
		{
			
		}
   
    }
	
	static findKthElement()
};