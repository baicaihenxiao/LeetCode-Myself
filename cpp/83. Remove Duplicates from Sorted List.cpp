/*
2016-10-1 23:32:22

https://leetcode.com/problems/remove-duplicates-from-sorted-list/

Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

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
        
		ListNode* first = head;
		ListNode* dup;
		
		while (first != nullptr)
		{
			dup = first->next;
			
			while (dup != nullptr && dup->val == first->val)
			{
				first->next = dup->next;
				dup = dup->next;
			}
			
			first = dup;
		}
		
		return head;
    }
};