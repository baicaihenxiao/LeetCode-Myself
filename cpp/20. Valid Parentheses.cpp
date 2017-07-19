// https://leetcode.com/problems/valid-parentheses/#/description 

class Solution {
public:
	bool isValid(string s) {

		if (s.empty())
		{
			return true;
		}

		stack<char> mystack;

		auto i = s.begin();

		while (i != s.end())
		{
			if (*i == '(' || *i == '[' || *i == '{')
			{
				mystack.push(*i);
			}
			else
			{
				if (mystack.empty())
				{
					return false;
				}

				if ((mystack.top() == '(' && *i == ')') || (mystack.top() == '[' && *i == ']') || (mystack.top() == '{' && *i == '}'))
				{
					mystack.pop();
				}
				else
				{
					return false;
				}
			}

			++i;
		}

		if (mystack.empty())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
};