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
using namespace std;

class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        
		bitset<9> dup;
		
		for (auto i = board.begin(); i < board.end(); ++ i)
		{
			for (auto j = (*i).begin(); j < (*i).end(); ++ j)
			{
				if (dup.test(*j))
				{
					return false;
				}
				
				dup.set(*j)
			}
			
			dup.reset();
		}
		
		for (int i = 0; i < 9; ++ i)
		{
			for (int j = 0; j < 9; ++ j)
			{
				if (dup.test(board.get(j).get(i)))
				{
					return false;
				}
				dup.set(board.get(j).get(i));
			}
			
			dup.reset();
		} 
		
		
		
    }
};
