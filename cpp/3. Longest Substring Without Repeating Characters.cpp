/*

2016-11-6 23:19:37

https://leetcode.com/problems/longest-substring-without-repeating-characters/


Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


*/


class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        
    	unordered_map<char, int> mymap;

    	int res = 0;
    	int tmpRes = 0;
    	int threIndex = 0;

    	const char* str = s.c_str();
    	for (int i = 0, len = s.size(); i != len; ++ i)
    	{
    		if (mymap.find(str[i]) == mymap.end())
    		{
    			++ tmpRes;
    			mymap[str[i]] = i;
    		}
    		else if (mymap[str[i]] < threIndex)
    		{
    			++ tmpRes;
    			mymap[str[i]] = i;
    		}
    		else
    		{
    			if (tmpRes > res)
    			{
    				 res = tmpRes;
    			}
    			threIndex = mymap[str[i]] + 1;
    			tmpRes = i - mymap[str[i]];
    			mymap[str[i]] = i;
    		}
    	}

    	if (tmpRes > res)
    	{
    		 res = tmpRes;
    	}

    	return res;

    }
};