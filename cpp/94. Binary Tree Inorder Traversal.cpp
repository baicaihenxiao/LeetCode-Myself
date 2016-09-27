/*
2016-9-28 01:27:50

https://leetcode.com/problems/binary-tree-inorder-traversal/

Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
*/



/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> res;
		stack<TreeNode*> s;
		TreeNode* iter = root;
		TreeNode* tmp;
		
		while ((iter != nullptr) || !s.empty())
		{
			if (iter != nullptr)
			{
				s.push(iter);
				iter = iter->left;
			}
			else
			{
				iter = s.top();
				s.pop();
				
				res.push_back(iter->val);
				
				iter = iter->right;
				
			}
		}
		
		return res;
    }
};