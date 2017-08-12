/*
2017-8-12 21:25:01

Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 6.

参考：http://blog.csdn.net/makuiyu/article/details/44857479


这个思路是从第一行往下扫。

每个位置计算1能达到的最左、最右的位置以及高度。

以最上为优先，比如：

001
011

这里matrix[1][2]的最左是2，最右是2，高度是2。（程序里面将最左最右数组从1开始 故为 3,3,2），
而不是最左是1，最右是2，高度是1(或2)。

这样该处的面积为height*(right - left).

当然可能会考虑如下情况
00001
11111

可能回想matrix[1][4]处的面积为2，是错误的结果。
但是matrix[1][3]处的面积为5,最终结果还是对的。


1.为什么程序里面将最左最右数组从1开始？
答：因为程序里最左最右数组设置为0表示不存在最左左右，如果从0开始，若本来就是能向左或向右扩展到0处，不能区分这两种情况。

时间复杂度O(n^2)。

*/

class Solution {
public:



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

        vector<int> left(col + 1, 0);
        vector<int> right(col + 1, 0);
        vector<int> height(col + 1, 0);

        int tmpLeft = 0;
        int tmpRight = 0;

        for (int i = 0; i < row; ++ i)
        {
            tmpLeft = 0;
            tmpRight = 0;
            for (int j = 0; j < col; ++ j)
            {
                if (matrix[i][j] == '0')
                {
                    tmpLeft = 0;
                    left[j] = 0;

                    height[j] = 0;
                }
                else
                {
                    if (tmpLeft == 0)
                    {
                        tmpLeft = j + 1;
                    }

                    if (left[j] == 0)//这个判断可以删去，即使left数组不从1开始？
                    {
                        left[j] = tmpLeft;
                    }

                    left[j] = max(left[j], tmpLeft);


                    ++ height[j];

                }

                if (matrix[i][col - j - 1] == '0')
                {
                    tmpRight = 0;
                    right[col - j - 1] = 0;
                }
                else
                {

                    if (tmpRight == 0)
                    {
                        tmpRight = col - j - 1 + 1;
                    }
                    
                    //cout << j << " " << tmpRight << endl;

                    if (right[col - j - 1] == 0)//这个判断不能删除，因为min之后每次都赋值为0.
                    {
                        right[col - j - 1] = tmpRight;
                    }
                    else
                    {
                        right[col - j - 1] = min(right[col - j - 1], tmpRight);
                    }
                    
                    //cout << j << " " << right[col - j - 1] << endl;

                }

            }
            
            //cout << i << endl << endl;

            for (int j = 0; j < col; ++ j)
            {
                res = max(res, (right[j] - left[j] + 1) * height[j]);
                //cout << j << " "  << right[j] << " "  << left[j] << " "  << height[j] << " " << (right[j] - left[j] + 1) * height[j] << endl;
            }

        }

        return res;
    }
};