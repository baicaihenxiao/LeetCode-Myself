/*
2017-5-25 20:53:41

https://leetcode.com/problems/interleaving-string/description/


Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.

*/

class Solution {
public:
    bool isInterleave(string s1, string s2, string s3) {
        
    	if (s1.size() + s2.size() != s3.size())
    		return false;

    	if (s3.empty())
    		return true;

        queue<char> tmpStr;

        auto itr1 = s1.begin();
        auto itr2 = s2.begin();
        auto itr3 = s3.begin();

        while (itr1 != s1.end() && itr2 != s2.end() && itr3 != s3.end())
        {
/*        	if (itr1 == s1.end())
        	{
        		if (itr2 == s2.end())
        		{
        			return false;
        		}
        		else
        		{
        			if (*itr2 == ch)
        			{
        				continue;
        			}
        			else
        			{
        				return false;
        			}
        		}
        	}

        	if (itr2 == s2.end())
        	{
        		if (itr1 == s1.end())
        		{
        			return false;
        		}
        		else
        		{
        			if (*itr1 == ch)
        			{
        				continue;
        			}
        			else
        			{
        				return false;
        			}
        		}
        	}
*/

        	char tmp = tmpStr.empty()?'0':tmpStr.front();

        	if ((*itr3 != *itr1) && (*itr3 != *itr2) && (*itr3 != tmp))
        	{
        		return false;
        	}

        	if (*itr1 == *itr2 && *itr2 == *itr3)
        	{
        		tmpStr.push(*itr3);

        		++ itr1;
        		++ itr2;
        	}
        	else if (*itr1 == tmp && tmp == *itr3)
        	{
        		++ itr1;
        	}
        	else if (*itr2 == tmp && tmp == *itr3)
        	{
        		++ itr2;
        	}
        	else if (*itr3 == *itr1)
        	{
        		++ itr1;
        	}
        	else if (*itr3 == *itr2)
        	{
        		++ itr2;
        	}
        	else if (*itr3 == tmp)
        	{
        		tmpStr.pop();
        	}

        	++ itr3;

        }

        while (itr1 != s1.end() && itr3 != s3.end())
        {
        	char tmp = tmpStr.empty()?'0':tmpStr.front();

        	if ((*itr3 != *itr1) && (*itr3 != tmp))
        	{
        		return false;
        	}

        	if (*itr3 == *itr1)
        	{
        		++ itr1;
        	}
        	else
        	{
        		tmpStr.pop();
        	}

        	++ itr3;

        }

        while (itr2 != s2.end() && itr3 != s3.end())
        {
        	char tmp = tmpStr.empty()?'0':tmpStr.front();

        	if ((*itr3 != *itr2) && (*itr3 != tmp))
        	{
        		return false;
        	}

        	if (*itr3 == *itr2)
        	{
        		++ itr2;
        	}
        	else
        	{
        		tmpStr.pop();
        	}

        	++ itr3;
        }

        while (!tmpStr.empty() && itr3 != s3.end())
        {
        	if (tmpStr.front() == *itr3)
        	{
        		++ itr3;
        		tmpStr.pop();
        	}
        	else
        	{
        		return false;
        	}
        }


        return true;

    }
};