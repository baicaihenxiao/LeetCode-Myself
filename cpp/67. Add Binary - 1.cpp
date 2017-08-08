
/*
2017-8-8 17:09:36

https://leetcode.com/problems/add-binary/

Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".


不能把string直接转换成bitset，因为得不到constexpr类型string的大小。

将两个string从最后一位往前加，长度不一样再分别计算。

需要注意的是进位，计算每一位时将a[i] + b[i] + carry。

转换char为十进制可以-'0'。



*/
#include <iostream>
#include <stdio.h>
#include <string>
#include <fstream>
#include <vector>
#include <unordered_map>
#include <stack>
#include <bitset>

#include <algorithm>
using namespace std;

class Solution {
public:


    string addBinary(string a, string b) {

        if (a.empty())
        {
            return b;
        }

        if (b.empty())
        {
            return a;
        }

        auto aBeg = a.rbegin();
        auto bBeg = b.rbegin();

        int carry = 0;
        int sum = 0;

        string res;

        while (aBeg != a.rend() && bBeg != b.rend())
        {
            sum = *aBeg - '0' + *bBeg - '0' + carry;
            res += '0' + sum % 2;
            carry = sum / 2;

            ++ aBeg;
            ++bBeg;

        }

        while (aBeg != a.rend())
        {
            sum = *aBeg - '0' + carry;
            res += '0' + sum % 2;
            carry = sum / 2;

            ++ aBeg;
        }

        while (bBeg != b.rend())
        {
            sum = *bBeg - '0' + carry;
            res += '0' + sum % 2;
            carry = sum / 2;

            ++ bBeg;
        }
        
        if (carry == 1)
        {
            res += '0' + carry;
        }

        reverse(res.begin(), res.end());

        return res;

    }
};
