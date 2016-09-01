/*
2016-9-1 01:21:44

https://leetcode.com/problems/valid-sudoku/

Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.


*/

#include <bitset>
#include <iostream>
using namespace std;

class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        
		bitset<10> dup;
		
		for (int i = 0; i < 9; ++ i)
		{
			for (int j = 0; j < 9; ++ j)
			{
				if (board[i][j] == '.')
				{
					continue;
				}
				
				if (dup.test(board[i][j] - '0'))
				{
					return false;
				}
				
				dup.set(board[i][j] - '0');
			}
			
			dup.reset();
		} 
		
		for (int i = 0; i < 9; ++ i)
		{
			for (int j = 0; j < 9; ++ j)
			{
				if (board[j][i] == '.')
				{
					continue;
				}
				
				if (dup.test(board[j][i] - '0'))
				{
					return false;
				}
				dup.set(board[j][i] - '0');
			}
			
			dup.reset();
		} 
		
		for (int i = 0; i < 3; ++ i)
		{
			for (int j = 0; j < 3; ++ j)
			{
				dup.reset();
				
				for (int m = 3 * i; m < 3 * (i + 1); ++ m)
				{
					for (int n = 3 * j; n < 3 * (j + 1); ++ n)
					{
						if (board[m][n] == '.')
						{
							continue;
						}
						
						
						if (dup.test(board[m][n] - '0'))
						{
							return false;
						}
						
						dup.set(board[m][n] - '0');
					}
				}
				
			}
		}
		
		return true;
		
		
    }
};
