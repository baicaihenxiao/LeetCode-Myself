/*
2016-9-22 11:33:26

https://leetcode.com/problems/single-number-iii/

Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?

*/

class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        
//        if (nums.size() == 0)

        vector<int> res(2, 0);
        
        int xorAll = accumulate(nums.begin(), nums.end(), 0, [](int res, int i){return res^i;});
        
		int tmp = xorAll & (~xorAll + 1);//ȡΪһ�����λ,��010100->000100;��֪��Ϊʲô�������ԣ�һ�����������෴�����Եõ����λ��1��
		//��������ﵽ��Ч����ͬ
        //int tmp = xorAll & ~(xorAll - 1);
        //int tmp = xorAll - (xorAll & (xorAll - 1));
		
        // cout << xorAll << endl;
        // cout << tmp << endl;
        // cout << res[0] << endl;
        for (auto i: nums)
        {
            // cout << i <<" " << tmp << " " << (i&tmp) << endl;
            if ((i & tmp) == 0)//i&tmpһ��Ҫ�����ţ�&�����ȼ���Ȼ��==�ͣ�
            {
                res[0] ^= i;
                 // cout << "a" <<  i << " " << res[0] << endl;
            }
            else
            {
                res[1] ^= i;
                // cout << "b" <<  i << " " << res[1] << endl;
            }
        }
        
        return res;
        
    }
};