/*
2016-9-23 20:38:45

https://leetcode.com/problems/reverse-linked-list/

Reverse a singly linked list.

click to show more hints.

Hint:
A linked list can be reversed either iteratively or recursively. Could you implement both?

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
    ListNode* reverseList(ListNode* head) {
        
		if (head == nullptr)
			return head;
		
		ListNode* pre = nullptr;
		ListNode* cur = nullptr;
		ListNode* nex = nullptr;
		
		
		pre = head;
		cur = head->next;
		pre->next = nullptr;
		
		while (cur != nullptr)
		{
			nex = cur->next;
			cur->next = pre;
			pre = cur;
			cur = nex;
		}
		
		return pre;
		
    }
};