/*
2017-8-20 19:31:05

https://leetcode.com/problems/sort-colors/description/

Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?

计数排序

*/


class Solution {
public:
    void sortColors(vector<int>& nums) {
        
        if (nums.size() == 0 || nums.size() == 1)
            return;
        
        vector<int> C(3, 0);//计数数组
        vector<int> B(nums.size(), 0);//排序后的数组
        
        for (int i = 0; i < nums.size(); ++ i)//C[i]表示数值为i的个数为C[i]
        {
            ++ C[nums[i]];
        }
        
        for (int i = 1; i < C.size(); ++ i)//C[i]表示数值小于等于i的个数为C[i]
        {
            C[i] += C[i - 1];
        }
        
        for (int i = nums.size() - 1; i >= 0; -- i)//一定要从大往小，以保持排序稳定性。
        {
            B[C[nums[i]] - 1] = nums[i];
            -- C[nums[i]];
        }
        
        copy(B.begin(), B.end(), nums.begin());
        
        return;
        
    }
};