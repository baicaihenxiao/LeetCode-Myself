/*
2016-9-30 19:27:31

https://leetcode.com/problems/binary-tree-preorder-traversal/

Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

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
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> res;
		stack<TreeNode*> s;
		TreeNode* iter = root;
		TreeNode* tmp;
		
		while ((iter != nullptr) || !s.empty())
		{
			if (iter != nullptr)
			{
				res.push_back(iter->val);
				s.push(iter);
				iter = iter->left;
			}
			else
			{
				iter = s.top();
				s.pop();
				
				
				iter = iter->right;
				
			}
		}
		
		return res;
    }
};