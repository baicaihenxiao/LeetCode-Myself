/*
2017-8-12 21:25:01

Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 6.

这个思路是利用84. Largest Rectangle in Histogram作为子程序。

每一行往上的矩形部分可以看作是一个直方图。

时间复杂度O(n^2)。

*/

class Solution {
public:

     int largestRectangleArea(vector<int>& heights) {

        if (heights.empty())
            return 0;

        int res = 0;

        stack<int> st;

        heights.push_back(0);


        for (int i = 0; i < heights.size(); ++ i)
        {
            if(st.empty())
            {
                st.push(i);
            }
            else
            {
                int tmp = st.top();
                if (heights[i] > heights[tmp])
                {
                    st.push(i);
                }
                else
                {
                    st.pop();
                    //cout <<  tmp << " " << heights[tmp] << " " << (st.empty() ? (i) : (i - st.top() - 1)) << endl;

                    res = max(res, heights[tmp] * (st.empty() ? (i) : (i - st.top() - 1)));

                    -- i;//注意每次--i.
                }

            }

        }

        return res;
        
    }


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

        vector<int> histogram(col, 0);


        for (int i = 0; i < row; ++ i)
        {
            for (int j = 0; j < col; ++ j)
            {
                histogram[j] = matrix[i][j] == '1' ? (histogram[j] + 1) : 0;
            }

            res = max(res, largestRectangleArea(histogram));
            //cout << histogram[0] << " " << histogram[1] << endl;
            //cout << res << endl;

        }

        return res;
    }
};