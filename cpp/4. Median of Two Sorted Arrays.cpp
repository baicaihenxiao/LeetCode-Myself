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

		//if (num1.size() > nums2.size())
		//{
		//	findMedianSortedArrays(nums2, nums1);
		//}

		int sum = nums1.size() + nums2.size();

		if (sum & 0x1)//(end1 + end2) is odd
		{
			return findKthElement(nums1.begin(), nums1.size(), nums2.begin(), nums2.size(), sum / 2 + 1);
		}
		else
		{
			return (findKthElement(nums1.begin(), nums1.size(), nums2.begin(), nums2.size(), sum / 2) + findKthElement(nums1.begin(), nums1.size(), nums2.begin(), nums2.size(), sum / 2 + 1)) / 2.0;
		}

	}

private:
	//kth: the k-th element, count from 1;
	static int findKthElement(vector<int>::const_iterator itrA, int sA, vector<int>::const_iterator itrB, int sB, int kth)
	{
		if (sA > sB)//ensure sA < sB, otherwise exchange them;
		{
			return findKthElement(itrB, sB, itrA, sA, kth);
		}

		if (sA == 0)
		{
			return *(itrB + kth - 1);
		}

		if (kth == 1)
		{
			return *itrA > *itrB ? *itrB : *itrA;
		}

		int posA = kth / 2 > sA ? sA : kth / 2;
		int posB = kth - posA;
		
		if (*(itrA + posA - 1) < *(itrB + posB - 1))
		{
			return findKthElement(itrA + posA, sA - posA, itrB, sB, kth - posA);
		}
		else if (*(itrA + posA - 1) > *(itrB + posB - 1))
		{
			return findKthElement(itrA, sA, itrB + posB, sB - posB, kth - posB);
		}
		else
		{
			return *(itrA + posA - 1);
			//return itrA[posA - 1];
		}
	}
};