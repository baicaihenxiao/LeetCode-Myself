/*
2016-8-31 10:52:30

https://leetcode.com/problems/permutation-sequence/

The set [1,2,3,бн,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.


refer to : http://blog.csdn.net/zifengchuanshuo007/article/details/38902123
			http://blog.csdn.net/zhongkeli/article/details/6966805

*/
#include <iostream>
#include <vector>
#include <string>
using namespace std;

class Solution {
public:
    string getPermutation(int n, int k) {

		if (n == 1)
			return string("1");

		string res;

		--k;

		int a[10];
		string s;

		int tmp = 1;
		for (int i = 1; i <= n; ++ i)
		{
			tmp *= i;
			a[i] = tmp;
			s += to_string(i);
		}

		for (int i = n - 1; i > 0; --i)
		{
			int div = k / a[i];

			res += s[div];
			s.erase(s.begin() + div);

			k = k % a[i];
		}

		res += s[0];

		return res;


	}


};