/*
2016-9-14 11:26:54

https://leetcode.com/problems/add-two-numbers/

You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        //cout << l1->val << l1->next->val;
        
        ListNode* tmp =  new ListNode(0);
		ListNode* res = tmp;
		bool carry = false;
        
        
        while(l1 != nullptr && l2 != nullptr)
		{
			if (carry)
			{
				carry = (l1->val + l2->val + 1 > 9);
				tmp->next = new ListNode((l1->val + l2->val + 1) % 10);
			}
			else
			{
				carry = (l1->val + l2->val > 9);
				tmp->next = new ListNode((l1->val + l2->val) % 10);
			}
			
			tmp = tmp->next;
			l1 = l1->next;
			l2 = l2->next;
			
		}
		
		while (l1 != nullptr)
		{
			
			if (carry)
			{
				carry = (l1->val + 1 > 9);
				tmp->next = new ListNode((l1->val + 1) % 10);
			}
			else
			{
				tmp->next = new ListNode(l1->val);
			}
			
			tmp = tmp->next;
			l1 = l1->next;

		}
		
		while (l2 != nullptr)
		{
			
			if (carry)
			{
				carry = (l2->val + 1 > 9);
				tmp->next = new ListNode((l2->val + 1) % 10);
			}
			else
			{
				tmp->next = new ListNode(l2->val);
			}
			
			tmp = tmp->next;
			l2 = l2->next;
		}
		
		if (carry)
		{
			tmp->next = new ListNode(1);
		}
			
        return res->next;
    }
};