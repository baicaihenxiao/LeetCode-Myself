/*
2016-10-3 00:39:52

https://leetcode.com/problems/remove-nth-node-from-end-of-list/

Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.

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
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        
		if (n == 0 || head == nullptr)
			return head;
		
		ListNode tmpHead(0);
		ListNode* phead = &tmpHead;
		phead->next = head;
		
		ListNode* res = phead;
		ListNode* pass = head;
		
		for (int i = 0; i < n; ++ i)
		{
			pass = pass->next;
		}
		
		while (pass != nullptr)
		{
			pass = pass->next;
			res = res->next;
		}
		
		res->next = res->next->next;
		
		return phead->next;
		
    }
};