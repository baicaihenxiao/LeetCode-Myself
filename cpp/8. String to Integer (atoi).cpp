/*
2017-3-23 21:50:03

https://leetcode.com/problems/string-to-integer-atoi/#/description

Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.

spoilers alert... click to show requirements for atoi.

*/

//八进制，十六进制
// 加括号(-4)
// 0099以零开头怎么处理
// -0
//+1

#include <limits>
#include <string>
#include <sstream>
#include <iostream>
using namespace std;

class Solution {
public:

	//Solution(){}
	int myAtoi(string str) {


		const int ERROR = 0;

		if (str.size() == 0)
		{
			return 0;
		}

		int max = std::numeric_limits<int>::max();
		int min = std::numeric_limits<int>::min();

		string maxStr = to_string(max);
		string minStr = to_string(min);

		minStr = minStr.substr(1, minStr.size());

		auto begMinStr = minStr.begin();
		auto begMaxStr = maxStr.begin();


		int symbol = 1;

		auto it = str.begin();
		for (; it < str.end() && (*it == ' '); ++ it )
		{
		}

		for (; it < str.end() && (*it == '0'); ++it)
		{
		}

		str = str.substr(it - str.begin(), str.size());

		it = str.begin();

		if (*it == '-')
		{
			symbol = -1;
			++it;
		}
		else if (*it == '+')
		{
			symbol = 1;
			++it;
		}

		str = str.substr(it - str.begin(), str.size());

		string res;

		it = str.begin();

		if (*it > '9' || *it < '0')
		{
			return ERROR;
		}

		for (; (it < str.end()) && (it - str.begin() <= maxStr.size()); ++ it )
		{
			if (*it > '9' || *it < '0')
			{
				break;
			}
			else
			{
				res += *it;
			}
		}

		if (it - str.begin() == (maxStr.size() + 1))
		{
			if (symbol == -1)
			{
				return min;
			}
			return max;
		}

		if (symbol == -1 && (res.size() == minStr.size()) && (res >= minStr))
		{
			return min;
		}

		if (symbol == 1 && (res.size() == maxStr.size()) && (res >= maxStr))
		{
			return max;
		}
		

		istringstream ss(res);

		int resInt = 0;
		ss >> resInt;

		return resInt*symbol;


	}
};

/*int main()
{
	Solution s;
	cout << s.myAtoi(string("23a8f"));
}*/
