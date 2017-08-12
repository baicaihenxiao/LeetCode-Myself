/*

2017-8-12 13:28:04


https://leetcode.com/problems/largest-rectangle-in-histogram/description/

Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given heights = [2,1,5,6,2,3],
return 10.


思路是 若heights是一个递增序列，则容易O(n)算出来，比如 {2, 4, 6}。
如果{2, 4, 6, 5}, 可以把6占得最大面积算出来，在弹出6，变成{2, 4, 5}。

需要注意的是：
1.当弹出栈顶元素时，{2,4,5,3,1}，当要弹出3，计算3的面积不能用3*(index=3 - index=3 + 1)，而要计算3*(index=3 - index=0)，这里index=0是pop3之后的top。
2.不停的弹出来，会导致stack为空，{5,4,5,2}，当要弹出4，pop4之后stack没有元素了，这时候计算4*(index=2 - 0 + 1)。即表示栈底元素*将进栈元素index，因为栈底元素index的左边没有比其更小的元素，所以将进栈元素index的左边都是栈底元素可以占据的范围。
3，heights遍历完之后stack里面可能还有元素，这时候需要单独处理，当然也可以在heights的后面加一个高度为0的元素。


这里做的优化是：
1.往heights数组后面加了一个0，确保最后能清空栈。
2.当新加的元素小于栈顶元素时，所有都处理完之后，--i，即下一次循环处理相同的下一个欲进栈元素。

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
};