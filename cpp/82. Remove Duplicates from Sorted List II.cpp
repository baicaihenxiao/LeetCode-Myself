/*
2016-10-1 23:45:12

https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.

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
    ListNode* deleteDuplicates(ListNode* head) {
        
		ListNode tmpHead(0);
		ListNode* phead = &tmpHead;
		
		phead->next = head;
		
		ListNode* res = phead;
		
		while (phead->next != nullptr && phead->next->next != nullptr)
		{
			
			if (phead->next->val == phead->next->next->val)
			{
				
				ListNode* tmp = phead->next->next;
				
				while (tmp != nullptr && tmp->val == phead->next->val)
				{
					tmp = tmp->next;
				}
				
				phead->next = tmp;
				
			}
			else
			{
				phead = phead->next;
			}
			
		}
		
		return res->next;
    }
};