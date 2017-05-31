class Solution {
public:
    vector<vector<string>> partition(string s) {

        vector<vector<string>> res;

        if (s.size() == 0)
            return res;

        if (s.size() == 1)
        {
            vector<string> tmpVec;
            tmpVec.push_back(s);
            res.push_back(tmpVec);
            return res;
        }

        stack<vector<int>> st;

        int sLen = s.size();

        st.push({ 0 });

        while (!st.empty())
        {
            vector<int> curVec = st.top();
            st.pop();
            int cur = *curVec.rbegin();

            for (int i = cur + 1; i < sLen; ++i)
            {
                if (isPalindrome(s, cur, i))
                {
                    vector<int> tmpVec = curVec;
                    tmpVec.push_back(i);
                    st.push(tmpVec);
                }
            }

            if (isPalindrome(s, cur, sLen))
            {
                curVec.push_back(sLen);
                res.push_back(trans(res, s, curVec));
            }
        }

        return res;

    }

    vector<string> trans(vector<vector<string>>& res, string& s, vector<int>& curVec)
    {
        vector<string> tr;

        for (int i = 1; i < curVec.size(); ++ i)
        {
            tr.push_back(s.substr(curVec[i - 1], curVec[i] - curVec[i - 1]));
        }

        return tr;
    }

    bool isPalindrome(string& s, int i, int j)
    {
        while (i < j)
        {
            if (s[i] != s[j - 1])
                return false;
            ++i;
            --j;
        }

        return true;
    }


};
