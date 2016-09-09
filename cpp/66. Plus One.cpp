/*
2016-9-9 12:19:38

https://leetcode.com/problems/plus-one/

Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.

*/


class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        
		bool carry = false;
		
		for (int i = digits.size() - 1; i >= 0; -- i)
		{
			if (digits[i] != 9)
			{
				++ digits[i];
				carry = false;
				break;
			}
			else
			{
				digits[i] = 0;
				carry = true;
			}
		}
		
		if (carry)
		{
			digits.insert(digits.begin(), 1);
		}
		
		return digits;
    }
};