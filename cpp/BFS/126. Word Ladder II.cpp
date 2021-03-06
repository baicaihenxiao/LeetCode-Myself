/*
2017-8-16 17:43:52

https://leetcode.com/problems/word-ladder-ii/description/

Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:
Return an empty list if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
UPDATE (2017/1/20):
The wordList parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.

广搜。

*/


class Solution {
public:

	bool transform(string& s1, string& s2)//其实最后一行应该return true，因为可以不用考虑两个字符串相等的情况。
	{
		auto first1 = s1.begin();
		auto last1 = s1.end();
		auto first2 = s2.begin();

		bool oneDiff = false;

		while (first1 != last1)
		{
			if (*first1 != * first2)
			{
				if (!oneDiff)
				{
					oneDiff = true;
				}
				else
				{
					return false;
				}
			}

			++ first1;
			++ first2;
		}

		return oneDiff;
	}

    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {


/*        if (wordList.empty())
        {
        	return transform(beginWord, endWord);
        }*/


        deque<int> que;

        int sizeOfList = wordList.size() + 1;

        vector<bool> visited(sizeOfList, false);
        vector<int> step(sizeOfList, 0);
        vector<int? path(sizeOfList, 0);
        wordList.push_back(beginWord);

        visited[sizeOfList - 1] = true;
        step[sizeOfList - 1] = 1;
        path[sizeOfList - 1] = -1;
        que.push_front(sizeOfList - 1);


        vector<int> res;
        // vector<int> step;

        int endIndex = 0;

        while (!que.empty())
        {
        	int tmp = que.front();
        	que.pop_front();

        	if (wordList[tmp] == endWord)
        	{
/*                path.push_back(tmp);
                while (!que.empty())
                {
                    if
                }
        		return step[tmp];*/
                /*endIndex = tmp;
                path.push_back(path[tmp]);*/

                break;

        	}

        	for (int i = 0; i != sizeOfList; ++ i)
        	{
        		if (!visited[i] && transform(wordList[tmp], wordList[i]))
        		{
        			que.push_back(i);
                    if (wordList[i] == endWord)
                    {
                        visited[i] = false;

                        res.push_back(tmp);

                        endIndex = i;

                    }
                    else
                    {
                        visited[i] = true;
                        
                        path[i] = tmp;
                    }

                    // step[i] = step[tmp] + 1;
        			
                    //cout << i << " " << wordList[i] << " " << step[i] << " " << endl;
        		}
        	}
        }


        vector<vector<string>> resStr;

        for (auto i: path)
        {
            vector<string> tmp;
            tmp.push_back(wordList[endIndex]);
            while(i != -1)
            {
                tmp.push_back(i);
                i = path[i];
            }
            tmp.push_back(beginWord);
            resStr.push_back(tmp);

        }

        return resStr;

    }
};