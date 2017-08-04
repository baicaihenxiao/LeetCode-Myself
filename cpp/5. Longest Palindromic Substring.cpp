/*
https://leetcode.com/problems/longest-palindromic-substring/#/description

*/

bool isPalindrome(string& s, int beg, int end)
{
	while (beg < end)
	{

		if (s[beg] != s[end])
		{
			return false;
		}

		-- end;
		++ beg;
	}

	return true;
}


class Solution {
public:
    string longestPalindrome(string s) {

    	int len = s.size();

    	if (len == 0 || len == 1)
    		return s;

    	int maxLengthOfPalindrome = 1;
    	int beg = 0;
    	int end = 1;

    	for (int i = 0; i < len; ++ i)
    	{
    		for (int j = i + 1; j < len; ++ j)
    		{
    			if (isPalindrome(s, i, j))
    			{
    				if (j - i + 1 > maxLengthOfPalindrome)
    				{
    					maxLengthOfPalindrome = j - i + 1;
    					beg = i;
    					end = j;
    				}
    			}

    		}
    	}

    	return s.substr(beg, maxLengthOfPalindrome);
        
    }
};