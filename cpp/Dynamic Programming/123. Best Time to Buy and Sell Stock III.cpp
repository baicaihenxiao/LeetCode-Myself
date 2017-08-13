/*
2017-8-13 13:21:34

https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).


这个题很简单， 从左往右扫一遍找到从0到i一次买卖最大利益，再从右往左找到从length到i的最大利益，每个地方的利益为0-i和i+1-len-1两次之和。

注意可能一次买卖为结果。

*/
class Solution {
public:
    int maxProfit(vector<int>& prices) {

    	if (prices.empty())
    	{
    		return 0;
    	}

    	int len = prices.size();

    	vector<int> leftProfit(len, 0);
    	vector<int> rightProfit(len, 0);

    	int res = 0;
    	int minValue = prices.front();

    	for (int i = 0; i < len; ++ i)
    	{
    		if (minValue >= prices[i])
    		{
    			minValue = prices[i];
    		}
    		else
    		{
    			res = max(prices[i] - minValue, res);
    		}
            
            leftProfit[i] = res;
    	}


    	res = 0;
    	int maxValue = prices.back();

    	for (int i = len - 1; i >= 0; -- i)
    	{
    		if (maxValue <= prices[i])
    		{
    			maxValue = prices[i];
    		}
    		else
    		{
    			res = max(maxValue - prices[i], res);
    		}
            rightProfit[i] = res;
    	}


    	res = leftProfit[len - 1];

    	for (int i = 0; i < len - 1; ++ i)
    	{
            //cout << i << " " << leftProfit[i] << " " <<  rightProfit[i] << endl;
    		res = max(res, leftProfit[i] + rightProfit[i + 1]);
    	}
        
        //cout << len-1 << " " << leftProfit[len-1] << " " <<  rightProfit[len-1] << endl;

    	return res;

        
    }
};