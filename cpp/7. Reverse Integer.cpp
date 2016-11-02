/*
2016-11-2 22:54:25

https://leetcode.com/problems/reverse-integer/

Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

click to show spoilers.

Have you thought about this?
Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

Update (2014-11-10):
Test cases had been added to test the overflow behavior.
*/

class Solution {
public:
    int reverse(int x) {
        
        long long res = x;

    	if (res == 0)
    	{
    		return 0;
    	}

    	int times = 1;

        if (res < 0)
        {
        	times = -1;
        	res = -res;
        }

        // int digit = 0;
        int len = 0;
        int data[32] = {0};

        while (res)
        {
        	data[len] = res % 10;
        	res /= 10;
        	++ len;
        }

        int i = 0;
        res = 0;

        while (i < len && data[i] == 0)
        {
        	++ i;
        }

        while (i < len)
        {
        	res = res * 10 + data[i];
        	++ i;
        }

        if (res > 0X7FFFFFFF)
        {
        	return 0;
        }

        return res * times;


    }
};