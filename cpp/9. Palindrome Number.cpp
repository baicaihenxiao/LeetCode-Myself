class Solution {
public:
    bool isPalindrome(int x) {
        if (x < 0)
        	return false;
        if (x < 10)
        	return true;

        int digit = 1;


        while (x / digit >= 10)
        {
        	digit *= 10;
        }

        while (x != 0)
        {
        	if (x/digit != x%10)
        		return false;

        	x %= digit;
        	x /= 10;
        	
        	digit /= 100;


        }


        return true;
    }
};