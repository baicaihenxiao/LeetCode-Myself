/*
2016-9-2 17:25:28

https://leetcode.com/problems/trapping-rain-water/

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

*/


class Solution {
public:
    int trap(vector<int>& height) {
        
		int res = 0;
		
		int indexMax = 0;
		
		for (int i = 0; i < height.size(); ++ i)// find the highest bar ->indexMax;
		{
			if (height[i] > height[indexMax])
			{
				indexMax = i;
			}
		}
		
		int peakTmp = 0;
		
		for (int i = 0; i < indexMax; ++ i)//from left to indexMax, find all trap in [peakTmp, height[indexMax]];
		{
			if (height[i] > peakTmp)
			{
				peakTmp = height[i];
			}
			else if (height[i] < peakTmp)
			{
				res += peakTmp - height[i];
			}
		}
		
		peakTmp = 0;
		
		for (int i = height.size() - 1; i > indexMax; -- i)//from right to indexMax, find all trap in [height[indexMax], peakTmp];
		{
			if (height[i] > peakTmp)
			{
				peakTmp = height[i];
			}
			else if (height[i] < peakTmp)
			{
				res += peakTmp - height[i];
			}
		}
		
		return res;
		
    }
};