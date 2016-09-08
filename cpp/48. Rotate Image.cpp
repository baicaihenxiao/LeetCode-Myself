/*
2016-9-2 18:10:48

https://leetcode.com/problems/rotate-image/

You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?

*/


class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        
		int n = matrix.size();
		
		if (n <= 1)
		{
			return;
		}
			
		int tmp = 0;
		int jRange = 0;
		
		if (n % 2 == 1)
		{
		    jRange = n / 2 + 1;
		}
		else
		{
		    jRange = n / 2;
		}
		
		for (int i = 0; i < n / 2; ++ i)
		{
			for (int j = 0; j < jRange; ++ j)
			{
				//clockwise: matrix[i][j]  matrix[j][n - i - 1]  matrix[n - i - 1][n - j - 1]  matrix[n - j - 1][i] 
				tmp = matrix[i][j];
				matrix[i][j] = matrix[n - j - 1][i];
				matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
				matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
				matrix[j][n - i - 1] = tmp;
				// matrix[j][n - i - 1] = matrix[i][j];
				// matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
				// matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
				
				
				
			}
		}
		
		return;
		
    }
};
