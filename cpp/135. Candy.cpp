/*
2016-9-21 12:47:52

https://leetcode.com/problems/candy/

There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

*/

#include <algrithm>

class Solution {
public:
    int candy(vector<int>& ratings) {
        
		int res = 0;
		vector<int> candy(ratings.size(), 1);
		//candy.reserve(ratings.size());
		
		for (int i = 1; i < ratings.size(); ++ i)
		{
			if (ratings[i] > ratings[i - 1])
			{
				candy[i] = candy[i - 1] + 1;
			}
		}
		
		for (int i = ratings.size() - 2; i >= 0; -- i)
		{
			if (ratings[i] > ratings[i + 1])
			{
				candy[i] = std::max(candy[i + 1] + 1, candy[i]);
			}
			
		}
		
		for (int i = 0; i < ratings.size(); ++ i)
		{
			res += candy[i];
		}
		
		return res;
		
    }
};