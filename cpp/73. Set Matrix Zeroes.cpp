/*
2016-9-19 16:41:38

https://leetcode.com/problems/set-matrix-zeroes/

Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

*/

#include <algorithm>

class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        
		int m = matrix.size();
		int n = matrix[0].size();
		
		if (m == 0 || n == 0)
			return;
		
		bool firstRow = (std::find(matrix[0].begin(), matrix[0].end(), 0) != matrix[0].end());
		bool thisRow = false;
		
		
		for (int i = 1; i < m; ++ i)
		{
			for (int j = 0; j < n; ++ j)
			{
				if (matrix[i][j] == 0)
				{
					thisRow = true;
					matrix[0][j] = 0;
				}
			}
			
			if (thisRow)
			{
				std::fill(matrix[i].begin(), matrix[i].end(), 0);
			}
			
			thisRow = false;
			
		}
		
		
		for (int j = 0; j < n; ++ j)
		{
			if (matrix[0][j] == 0)
			{
				for (int i = 1; i < m; ++ i)
				{
					matrix[i][j] = 0;
				}

			}
			
		}
		
		if (firstRow)
		{
			std::fill(matrix[0].begin(), matrix[0].end(), 0);
		}
		
		
		return;
    }
};