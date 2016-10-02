/*
2016-10-3 00:49:50

https://leetcode.com/problems/swap-nodes-in-pairs/

Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

*/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* swapPairs(ListNode* head) {
        
		ListNode dummy(0);
		ListNode* phead = &dummy;
		phead->next = head;
		
		ListNode* iter = phead;
		ListNode* tmp = nullptr;
		
		while (iter->next != nullptr && iter->next->next != nullptr)
		{
			
			tmp = iter->next;
			iter->next = iter->next->next;
			tmp->next = iter->next->next;
			iter->next->next = tmp;
			
			iter = iter->next->next;
			
		}
		
		return phead->next;
		
    }
};