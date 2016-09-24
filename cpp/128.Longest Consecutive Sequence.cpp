/*
2016-8-20 11:05:38

https://leetcode.com/problems/longest-consecutive-sequence/

128. Longest Consecutive Sequence  QuestionEditorial Solution  My Submissions
Total Accepted: 73848
Total Submissions: 220055
Difficulty: Hard
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.


*/


#include <unordered_map>

class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        
		unordered_map<int, bool> m;
		
		int longest = 0;
		int tmpLong = 0;
		
		for (auto i: nums)
		{
			m[i] = false;
		}
		
		for (auto i: nums)
		{
			if (m[i])
			{
				continue;
			}
			else
			{
				m[i] = true;
				
				tmpLong = 1;
				
				for (int j = i + 1; m.find(j) != m.end(); ++ j)
				{
					m[j] = true;
					++ tmpLong;
				}
				
				for (int j = i - 1; m.find(j) != m.end(); -- j)
				{
					m[j] = true;
					++ tmpLong;
				}
				
				if (tmpLong > longest)
					longest = tmpLong;
				
			}
		}
		
		return longest;

		
    }
};