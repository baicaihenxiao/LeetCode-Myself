/*
2016-10-20 23:20:02

https://leetcode.com/problems/valid-palindrome/

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/
#include <cctype>
class Solution {
public:
    bool isPalindrome(string s) {
        for_each(s.begin(), s.end(), [](char& n){n = tolower(n);});

        auto beg = s.begin(), end = s.end() - 1;

        // cout << *beg << "  " << *end << endl;

        while (beg < end)
        {
            if (!isalnum(*beg))
            {
                ++ beg;
            }
            else if (!isalnum(*end))
            {
                -- end;
            }
            else if (*beg != *end)
            {
                return false;
            }
            else
            {
                ++ beg;
                -- end;
            }
        }

        return true;
    }
};