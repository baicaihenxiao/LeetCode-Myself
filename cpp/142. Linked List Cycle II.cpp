/*
2016-10-6 17:09:09

https://leetcode.com/problems/linked-list-cycle-ii/

Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

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
    ListNode *detectCycle(ListNode *head) {
        
		if (head == nullptr || head->next == nullptr)
		{
			return nullptr;
		}
		
		ListNode* onestep = head;
		ListNode* twostep = head->next;
		
		//1.judge whether a cycle exists;
		while (true)
		{
			if (onestep == twostep)
			{
				break;
			}
			
			onestep = onestep->next;
			
			if (twostep == nullptr || twostep->next == nullptr)
			{
				return false;
			}
			
			twostep = twostep->next->next;			
		}
		
		int cycleLength = 0;
		
		/* do
		{
			onestep = onestep->next;
			twostep = twostep->next->next;	
			
			++ cycleLength;
		}
		while (onestep != twostep); */
		
		//2.calculate the length of cycle/the number of nodes in cycle;
		do
		{
			twostep = twostep->next;	
			
			++ cycleLength;
		}
		while (onestep != twostep);
		
		
		ListNode* res = head;
		onestep = head;

		//3.the 'onestep' pointer is cycleLength steps front of the 'res' pointer;
		for (int i = 0; i < cycleLength; ++ i)
		{
			onestep = onestep->next;
		}
		
		//4.when res meets onestep, res is the entry point;
		while (res != onestep)
		{
			
			res = res->next;
			onestep = onestep->next;
			
		}
		
		return res;
		
		
		
    }
};