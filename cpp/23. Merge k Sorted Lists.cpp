/*
2016-8-21 21:05:33

https://leetcode.com/problems/merge-k-sorted-lists/

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

*/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
 
#include <limits>
 
class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
		ListNode* res;
        //std::cout << lists[0]->val <<  lists[0]->next->val << std::endl;
		//std::cout << lists.size();
		
		while (lists.size() != 0)
		{
			int var = std::numeric_limits<int>::max;
			for (auto iter = lists.begin(); iter != lists.end(); ++ iter)
			{
				ListNode* node = *iter;
				if (node->next == 0)
				{
					
				}
			}
		}
		
		return res;
    }
};