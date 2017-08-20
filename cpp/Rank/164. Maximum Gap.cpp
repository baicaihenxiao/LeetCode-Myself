/*
2017-8-20 23:34:54

https://leetcode.com/problems/maximum-gap/description/

Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Return 0 if the array contains less than 2 elements.

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.

桶排序
http://blog.csdn.net/u012162613/article/details/41936569

*/


class Solution {
public:
    int maximumGap(vector<int>& nums) {
        
        if (nums.empty() || nums.size() == 1)
            return 0;
        
        
        int min1 = *min_element(nums.begin(), nums.end());
        int max1 = *max_element(nums.begin(), nums.end());
        
        //这里区间细节不知道
        int capacityOfBucket = (max1 - min1) / nums.size() + 1;//每个桶的区间
        int sizeOfBucket = (max1 - min1) / capacityOfBucket + 1;//桶个数，不能直接等于nums.size()，不一样。
        
        vector<vector<int>> buc(sizeOfBucket);
        
        for (auto i: nums)
        {
            int tmp = (i - min1) / capacityOfBucket;
            
            if (buc[tmp].empty())
            {
                buc.reserve(2);
                buc[tmp].push_back(i);
                buc[tmp].push_back(i);
            }
            else
            {
                buc[tmp][0] = min(i, buc[tmp][0]);
                buc[tmp][1] = max(i, buc[tmp][1]);
            } 
        }
        
        int res = 0;
        int pre = 0;
        
        //return buc.size();

        
        for (int i = 1; i < buc.size(); ++ i)
        {
            if (buc[i].empty())
            {
                continue;
            }
            else
            {
                
                res = max(res, buc[i][0] - buc[pre][1]);
                pre = i;
            }
        }
        
        return res;
        
    }
};