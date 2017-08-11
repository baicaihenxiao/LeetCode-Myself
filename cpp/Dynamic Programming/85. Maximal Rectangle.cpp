/*
2017-8-11 22:23:56

Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 6.

思路是用dp算法算出来dp[i][j]表示矩形matrix[0-(i-1)][0-(j-1)]中以i和j为顶点的最大矩形面积。而不是matrix[0-(i-1)][0-(j-1)]的全部可能中的最大面积。
原以为dp[i][j] = max{ 同行+1， 同列 + 1， 左边和上边元素重合的部分    }。
但是会有["000011101","001111101","000111110"]这种情况
000011101
001111101
000111110
左上角部分的右下角dp[2][6] = 4，但是面积为4有两种情况，如果记录col = 4, row = 1， 这导致dp[2][7]计算成col = 5, row = 1的情况，错误。
000011
001111

*/

class Solution {
public:

	class rec
	{
	public:
		int row = 0;
		int col = 0;

		rec(){}

		rec(int l, int w):row(l), col(w){}

		int getArea()
		{
			return row * col;
		}

	};

    int maximalRectangle(vector<vector<char>>& matrix) {

    	if (matrix.empty())
    	{
    		return 0;
    	}

    	if (matrix[0].empty())
    	{
    		return 0;
    	}

    	int res = 0;

    	int row = matrix.size();
    	int col = matrix[0].size();

    	rec tmpRec;
    	vector<rec> tmpVec(col + 1, tmpRec);
    	vector<vector<rec>> dp(row + 1, tmpVec);

    	for (int i = 1; i <= row; ++ i)
    	{

    		for (int j = 1; j <= col; ++ j)
    		{

    			if (matrix[i - 1][j - 1] == '1')
    			{

    				if (dp[i - 1][j].row >= dp[i][j - 1].col)
    				{
    					dp[i][j].row = dp[i - 1][j].row + 1;
    					dp[i][j].col = 1;
    				}
    				else
    				{
    					dp[i][j].row = 1;
    					dp[i][j].col = dp[i][j - 1].col + 1;
    				}

    				int tmpRow = min(dp[i - 1][j].row + 1, dp[i][j - 1].row);
    				int tmpCol = min(dp[i - 1][j].col, dp[i][j - 1].col + 1);

    				if (tmpRow * tmpCol > dp[i][j].getArea())
    				{
    					dp[i][j].row = tmpRow;
    					dp[i][j].col = tmpCol;
    				}


    				if (dp[i][j].getArea() > res)
    				{
    					res = dp[i][j].getArea();
    				}
    			}
/*    			else 如果为0则表示以i-1,j-1为顶点不存在1矩形，而不是表示matrix[i - 1][j - 1]矩形中最大的1矩形面积为0.
    			{

    			}*/


    		}


    	}

        return res;
    }
};