/*
2017-5-25 23:35:00

Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.




*/


class Solution {
public:
    int maxSubArray(vector<int>& nums) {

    	if (nums.size() == 0)
    	{
    		return 0;
    	}

    	if (nums.size() == 1)
    	{
    		return nums[0];
    	}

    	int res = nums[0];
    	int tmp = nums[0];
        
    	for (int i = 1; i != nums.size(); ++ i)
    	{
    		if (tmp > 0)
    		{
    			tmp += nums[i];
    		}
    		else
    		{
    			tmp = nums[i];
    		}

    		if (res < tmp)
    			res = tmp;
    	}

    	return res;


    }
};