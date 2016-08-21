/*
2016Äê4ÔÂ30ÈÕ21:01:11

88. Merge Sorted Array   My Submissions QuestionEditorial Solution
Total Accepted: 98619 Total Submissions: 328198 Difficulty: Easy
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.

Subscribe to see which companies asked this question

Hide Tags Array Two Pointers
Hide Similar Problems (E) Merge Two Sorted Lists
Have you met this question in a real interview? Yes  No
Discuss



*/

#include <stdio.h>
#include <iostream>
#include <string>
#include <vector>
using std::vector;
using std::cout;
using std::cin;
using std::endl;

int main()
{

	freopen("../test.txt", "r", stdin);


}


class Solution {
public:
	void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {


		vector<int> tmpArray(m + n);

		int i = 0, j = 0, k = 0;

		while (i < m && j < n)
		{
			if (nums1[i] < nums2[j])
			{
				tmpArray[k++] = nums1[i++];
			}
			else
			{
				tmpArray[k++] = nums2[j++];
			}
		}

		while (i < m)
		{
			tmpArray[k++] = nums1[i++];
		}

		while (j < n)
		{
			tmpArray[k++] = nums2[j++];
		}

		nums1 = tmpArray;
		return;
	}
};