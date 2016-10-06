/*
2016-10-5 13:06:57

https://leetcode.com/problems/linked-list-cycle/

Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
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
    bool hasCycle(ListNode *head) {
        
		if (head == nullptr || head->next == nullptr)
		{
			return false;
		}
		
		ListNode* onestep = head;
		ListNode* twostep = head->next;
		
		while (true)
		{
			if (onestep == twostep)
			{
				return true;
			}
			
			onestep = onestep->next;
			
			if (twostep == nullptr || twostep->next == nullptr)
			{
				return false;
			}
			
			twostep = twostep->next->next;			
		}
		
    }
};