/*

https://leetcode.com/problems/palindrome-partitioning/description/

Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
  ["aa","b"],
  ["a","a","b"]
]


dp算法先算出来dp[i][j]表示s[i - j]是否为回文字符串，状态转移函数为dp[i][j] = dp[i + 1][j - 1] && s[i] == s[j]。
dp只用计算上三角矩阵，根据转移函数应该从下往上算。

然后深搜计算所有划分。


*/


class Solution {
public:

	vector<string> trans(string& s, vector<int>& vec)
	{

		/*for (const auto& i: vec)
		{
			cout << i << " ";
		}
		cout << endl;*/
		vector<string> res;

		for (int i = 0; i < vec.size() - 1; ++ i)
		{
			res.push_back(s.substr(vec[i], vec[i + 1] - vec[i]));
		}

		return res;

	}


    vector<vector<string>> partition(string s) {

        vector<vector<string>> res;
        int len  = s.size();


        if (len == 0)
            return res;

        if (len == 1)
        {
/*            vector<string> tmpVec;
            tmpVec.push_back(s);*/
            res.push_back({s});
            return res;
        }


        vector<bool> tmp(len, false);

        std::vector<vector<bool>> dp(len, tmp);

        for (int i = len - 1; i >= 0; -- i)
        {
        	dp[i][i] = true;

            for (int j = i + 1; j < len; ++ j)
            {
            	if (s[i] == s[j])
            	{
            		if (dp[i + 1][j - 1] || (j == i + 1))
            		{
            			dp[i][j] = true;
            		}
            	}
            }
        }

        stack<vector<int>> st;


        st.push({ 0 });


        while (!st.empty())
        {
        	vector<int> curVec = st.top();
        	st.pop();

        	int cur  = curVec.back();

        	if (cur == len)
        	{
        		res.push_back(trans(s, curVec));
        	}

        	for (int i = cur + 1; i <= len; ++ i)
        	{
        		if (dp[cur][i - 1])
        		{
        			curVec.push_back(i);
        			st.push(curVec);
        			curVec.pop_back();
        		}
        	}

        }



        
        return res;

    }




};
