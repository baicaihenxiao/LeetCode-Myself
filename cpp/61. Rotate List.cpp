/*
2016-10-2 00:43:05

https://leetcode.com/problems/rotate-list/

Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.

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
    ListNode* rotateRight(ListNode* head, int k) {
        
		ListNode* tmp = head;
		
		int length = 0;
		
		while (tmp != nullptr)
		{
			++ length;
			tmp = tmp->next;
		}
		
		if (length == 0 || k % length == 0)
		{
			return head;
		}
		
		k %= length;
		
		k = length - k;
		
		tmp = head;
		
		for (int i = 1; i < k; ++ i)
		{
			tmp = tmp->next;
		}
				
		ListNode* res = tmp->next;
		tmp->next = nullptr;
		
		tmp = res;
		
			
		while (tmp->next != nullptr)
		{
			tmp = tmp->next;
		}
		
		tmp->next = head;
		
		return res;
		
    }
};