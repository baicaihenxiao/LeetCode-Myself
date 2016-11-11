/*
2016-11-11 16:01:42

https://leetcode.com/problems/implement-strstr/

Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

*/


class Solution {
public:
    int strStr(string haystack, string needle) {
        int hayLen = haystack.size();
        int neeLen = needle.size();

        if (neeLen == 0)
        {
        	return 0;
        }

        if (hayLen == 0)
        {
        	return -1;
        }

        char* hay = &haystack[0];
        char* nee = &needle[0];

        int j = 0;
        for (int i = 0; i <= hayLen - neeLen; ++ i)
        {
        	for (j = 0; j < neeLen && hay[j + i] == nee[j]; ++j){}

        	if (j == neeLen)
        	{
        		return i;
        	}
        }

        return -1;

    }
};