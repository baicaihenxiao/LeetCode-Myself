/*
2016-10-3 21:04:32

https://leetcode.com/problems/reverse-nodes-in-k-group/

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
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
    ListNode* reverseKGroup(ListNode* head, int k) {
        
		if (head == nullptr || k == 0 || k == 1)
		{
			return head;
		}
		
		ListNode dummy(0);
		ListNode* phead = &dummy;
		
		phead->next = head;
		
		ListNode* begin = phead;
		ListNode* end;
		ListNode* tmp;
		
		int i = 0;
		
		while (true)
		{
			
			end = begin;
			
			for (i = 0; i < k; ++ i)
			{
				if (end->next == nullptr)
				{
					break;
				}
				
				end = end->next;
			}
			
			if (k == i)
			{
				ListNode* iter = begin->next;
				
				for (i = 1; i < k; ++ i)
				{
					tmp = begin->next;
					begin->next = iter->next;
					iter->next = iter->next->next;
					begin->next->next = tmp;
					
				}
				
				begin = iter;
			}
			else
			{
				break;
			}
			
		}
		
		
		return phead->next;

		
		
    }
};