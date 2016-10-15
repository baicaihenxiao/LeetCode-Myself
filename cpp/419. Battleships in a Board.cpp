/*
2016-10-16 02:06:08

https://leetcode.com/problems/battleships-in-a-board/

Given an 2D board, count how many different battleships are in it. The battleships are represented with 'X's, empty slots are represented with '.'s. You may assume the following rules:

You receive a valid board, made of only battleships or empty slots.
Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column).
At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
Example:
X..X
...X
...X
In the above board there are 2 battleships.
Your algorithm should not modify the value of the board.
*/


class Solution {
public:
    int countBattleships(vector<vector<char>>& board) {
        

        if (board.size() == 0)
        {
        	return 0;
        }


        int height = board.size();
        int width = board[0].size();

        std::vector<bool> hasBattle(width, false);

        int res = 0;
        int k = 0;

        for (int i = 0; i < height; ++ i)
        {
        	for (int j = 0; j < width; ++j)
        	{
        		if (board[i][j] == 'X')
        		{
        			if (hasBattle[j])
        			{
        				continue;
        			}

        			for (k = j + 1; k < width && board[i][k] == 'X'; ++ k){}

        			if (k == j + 1)
        			{
        				hasBattle[j] = true;
        			}
        			else
        			{
        				j = k - 1;
        			}

        			++ res;

        		}
        		else 
        		{
        			if (hasBattle[j])
        			{
        				hasBattle[j] = false;
        			}
        		}

        	}
        }

        return res;

    }
};