/*
2016-10-24 21:30:24

https://leetcode.com/problems/add-binary/

Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/


class Solution {
public:
    string addBinary(string a, string b) {
        auto aiter = a.rbegin();
        auto biter = b.rbegin();

        string res;

        int carry = 0;

        while (aiter != a.rend() && biter != b.rend())
        {
            if (*aiter == '0' && *biter == '0')
            {
                res.insert(res.begin(), '0' + carry);
                carry = 0;
            }
            else if (*aiter == '1' && *biter == '1')
            {

                res.insert(res.begin(), carry + '0');
                carry = 1;
            }
            else
            {
                res.insert(res.begin(), 1 - carry + '0');
            }

            ++ aiter;
            ++ biter;

        }

        while (aiter != a.rend())
        {
            res.insert(res.begin(), (*aiter - '0' + carry) % 2 + '0');
            carry = (*aiter - '0' + carry) / 2;
            ++ aiter;
        }

        while (biter != b.rend())
        {
            res.insert(res.begin(), (*biter - '0' + carry) % 2 + '0');
            carry = (*biter - '0' + carry) / 2;
            ++ biter;
        }

        if (carry == 1)
        {
            res.insert(res.begin(), '1');
        }
        return res;

    }
};

